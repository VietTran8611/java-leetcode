package Leetcode22;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }


    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        String str ="(";
        recursive(str,1,0,n,list);
        return list;
    }


    public static void recursive(String str, int open,int close,int n, List list){
        if (close==n && open==n){
            list.add(str);
        }

        if (open<n){
            String copy = str+"(";
            recursive(copy,open+1,close,n,list);
        }

        if (close<open){
            String copy = str+")";
            recursive(copy,open,close+1,n,list);
        }

    }
}
