package Leetcode435;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {

    }

    public int eraseOverlapIntervals(int[][] intervals) {
        int ret =0;
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        int[] n = intervals[0];
        for(int i=0;i<intervals.length;i++){
            if (intervals[i][0]<n[1]){
                ret++;
                if (intervals[i][1] < n[1]){
                    n = intervals[i];
                }
            }else {
                n = intervals[i];
            }
        }

        return ret;
    }
}
