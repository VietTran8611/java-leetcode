package Leetcode53;

public class Solution {
    public static void main(String[] args) {
        int[] num={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(num));
    }

    public static int maxSubArray(int[] nums) {
        int globalMax = nums[0];
        int currMax=0;

        for (int i=0;i< nums.length;i++){
            currMax=Math.max(currMax,0);
            currMax+=nums[i];
            globalMax=Math.max(currMax,globalMax);
        }

        return globalMax;
    }
}
