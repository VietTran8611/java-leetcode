package Leetcode198;

public class Solution {
    public static void main(String[] args) {

    }

    public int rob(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }else if (nums.length==2){
            return Math.max(nums[0],nums[1]);
        }

        nums[1]=Math.max(nums[0],nums[1]);
        for (int i=2;i<nums.length;i++){
            nums[i] = Math.max(nums[i-1],nums[i]+nums[i-2]);
        }

        int length = nums.length;
        return Math.max(nums[length-1],nums[length-2]);
    }
}
