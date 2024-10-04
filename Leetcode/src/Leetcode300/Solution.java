package Leetcode300;

import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        int max =1;
        if (nums.length==1){
            return 1;
        }

        int[] arr = new int[nums.length];
        Arrays.fill(arr,1);
        for (int i=nums.length-2;i>=0;i--){
            for (int j=i;j<nums.length;j++){
                if (nums[i]<nums[j]){
                    arr[i]=Math.max(arr[i],arr[j]+1);
                }
            }
            max = Math.max(max,arr[i]);
        }

        return max;
    }
}
