package Leetcode91;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String s = "10";
        System.out.println(numDecodings(s));
    }

    public static int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1; // empty string
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i < s.length() + 1; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            if (
                    s.charAt(i - 2) == '1' ||
                            (s.charAt(i - 2) == '2' && s.charAt(i - 1) < '7')
            ) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }
}
