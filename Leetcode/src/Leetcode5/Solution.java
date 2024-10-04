package Leetcode5;

public class Solution {

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }
    public static String longestPalindrome(String s) {
        String max = s.substring(0,1);
        for (int i=0;i<s.length();i++){
            String odd = expandFromCenter(s,i,i);
            String even = expandFromCenter(s,i,i+1);
            if (odd.length()>max.length()){
                max=odd;
            }

            if (even.length()>max.length()){
                max=even;
            }
        }
        return max;
    }

    private static String expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}
