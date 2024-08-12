package leetcode2009;

import java.util.Arrays;

public class Solution {
    public static int minOperations(int[] nums) {
        Arrays.sort(nums);
        int left=0,right=0,max=1,curr=1,target=nums.length;
        nums=Arrays.stream(nums).distinct().toArray();
        int target2=nums.length;
        while (right<target2-1){
            right++;
            while (left<right && (nums[right]-nums[left])>=target){
                if (curr>max){
                    max=curr;
                }
                curr--;
                left++;
            }
            curr++;
        }

        if (curr>max){
            max=curr;
        }
        return target- max;
    }

}
