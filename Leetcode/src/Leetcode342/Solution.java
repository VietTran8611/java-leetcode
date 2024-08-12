package Leetcode342;

public class Solution {
    public static boolean isPowerOfFour(int n) {
        if (n==1){
            return true;
        }
        if (n<4){
            return false;
        }
        String result = Integer.toBinaryString(n);
        double x= (double) n;
        if (result.length()%2 != 0){
            if (x!= Math.pow(2,result.length()-1)){
                return false;
            }else {
                return true;
            }
        }
        return false;
    }
}
