package Leetcode287;

import java.util.Arrays;

public class Solution {
    public static int findDuplicate(int[] nums) {
        int out =0;
        int slow =0;
        int fast =0;
        do {
            slow=nums[slow];
            fast=nums[nums[fast]];
        }
        while (fast!=slow);
        fast=0;
        while (fast!=slow){
            fast=nums[fast];
            slow=nums[slow];
        }
        return slow;
    }
}
