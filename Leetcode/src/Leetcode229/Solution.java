package Leetcode229;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> l1 = new ArrayList<Integer>();
        int count1=0,count2=0,vote1=0,vote2=0,cand1=-1,cand2=-1;
        for (int i=0;i<nums.length;i++){
            if (vote1==0 && nums[i]!= cand2){
                cand1=nums[i];
                vote1=1;
            }else if (vote2==0 && nums[i]!=cand1){
                cand2=nums[i];
                vote2 = 1;
            }else if (cand1==nums[i]){
                vote1++;
            }else if (cand2==nums[i]){
                vote2++;
            }else {
                vote1--;
                vote2--;
            }
        }

        for (int i=0;i<nums.length;i++){
            if (nums[i]==cand1){
                count1++;
            }
            if (nums[i]==cand2){
                count2++;
            }
        }

        if (count1>nums.length/3){
            l1.add(cand1);
        }

        if (count2>nums.length/3 && cand1!= cand2){
            l1.add(cand2);
        }
        return l1;
    }
}
