package Leetcode921;

public class Solution {
    public int minAddToMakeValid(String s) {
        int res =0;
        int count =0;
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='('){
                count++;
            }else {
                if (count==0){
                    res++;
                }else {
                    count--;
                }
            }
        }

        return res+count;
    }
}
