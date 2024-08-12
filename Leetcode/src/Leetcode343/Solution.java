package Leetcode343;

public class Solution {
    public static int integerBreak(int n) {
        if (n%3==2){
            return (int) Math.round(Math.pow(3,n/3)*2);
        }else if (n%3==1){
            return (int) Math.round(Math.pow(3,n/3-1)*4);
        }else {
            return (int) Math.round(Math.pow(3,n/3));
        }

    }
}
