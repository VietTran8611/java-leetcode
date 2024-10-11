package Leetcode962;

import java.util.Arrays;

public class Solution {
    public int maxWidthRamp(int[] nums) {
        int res =0;
        int[] prepros= new int[nums.length];
        prepros[nums.length-1]=nums[nums.length-1];
        for (int i=nums.length-2;i>=0;i--){
            prepros[i]= Math.max(prepros[i+1],nums[i]);
        }
        int left =0;
        for (int i=1;i<nums.length;i++){
            while (left<i && nums[left]>prepros[i]){
                left++;
            }
            res=Math.max(res,i-left);
        }

        return res;
    }
}
