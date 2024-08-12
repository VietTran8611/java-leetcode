package Leetcode153;

public class Solution {
    public static int findMin(int[] nums) {
        int low =0;
        int high=nums.length-1;
        int mid;
        int res=nums[0];

        while(low <= high){
            if (nums[low]<nums[high]){
                res=Math.min(res,nums[low]);
                break;
            }
            mid=(high+low)/2;
            res=Math.min(res,nums[mid]);

            if (nums[mid]>=nums[low]){
                low=mid+1;
            }else {
                high=mid-1;
            }
        }
        return res  ;
    }
}
