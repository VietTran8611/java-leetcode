package Leetcode33;

public class Solution {
    public static int search(int[] nums, int target) {
        int mid;
        int low=0;
        int high = nums.length-1;

        while (low <= high) {
            mid = ((high + low) / 2);

            if (target==nums[mid]){
                return mid;
            }

            //left sorted
            if (nums[low]<=nums[mid]){
                if (target>nums[mid] || target<nums[low]){
                    low=mid+1;
                }else {
                    high=mid-1;
                }
            }
            //right sorted
            else {
                if (target<nums[mid] || target>nums[high]){
                    high = mid -1;
                }else {
                    low = mid+1;
                }
            }
        }
        return -1;
    }
}
