package Leetcode56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

    }

    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[] newint = intervals[0];
        for (int i=1;i<intervals.length;i++){
            if (newint[1] < intervals[i][0]){
                list.add(newint);
                newint=intervals[i];
            }else {
                newint[0] = Math.min(intervals[i][0], newint[0]);
                newint[1] = Math.max(intervals[i][1], newint[1]);
            }
        }
        list.add(newint);

        return list.toArray(new int[list.size()][]);
    }
}
