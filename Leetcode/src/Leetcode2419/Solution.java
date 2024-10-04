package Leetcode2419;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int longestSubarray(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int globalMax =0;
        int currMax=0;

        for (int i=0;i< nums.length;i++){
            if (nums[i]!=max){
                currMax=0;
            }else {
                currMax++;
                globalMax=Math.max(globalMax,currMax);

            }
        }
        return globalMax;
    }
}
