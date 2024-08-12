package Leetcode1658;

import java.util.Arrays;

public class Solution {
    public static int minOperations(int[] nums, int x) {
        int length=nums.length;
        int left=0;
        int right =0;
        int sum=nums[0];
        int maxLen=0;

        int total=0;
        for (int i=0;i<nums.length;i++){
            total+=nums[i];
        }
        int targeted= total-x;

        if (targeted<0){
            return -1;
        }

        if (targeted==0){
            return nums.length;
        }
        while (right< length){
            while (left<=right&& sum>targeted){
                sum-=nums[left];
                left++;
            }

            if (sum==targeted){
                maxLen=Math.max(maxLen,right-left+1);
            }
            right++;
            if (right<length) sum+=nums[right];
        }

        int out = length-maxLen;
        if (out==length){
            return -1;
        }else
            return length-maxLen ;
    }

}
