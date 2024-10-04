package Leetcode2220;

public class Solution {
    public int minBitFlips(int start, int goal) {
        int bit = goal ^ start;
        return Integer.bitCount(bit);
    }
}
