package Leetcode46;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1,2,3};
        System.out.println(sol.permute(nums));
    }

    public List<List<Integer>>  permute(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans,nums,0);

        return ans;
    }

    private void backtrack(List<List<Integer>> ans,int[] nums,int start){
        if (start== nums.length){
            List<Integer> list = new ArrayList<>();
            for (int num : nums){
                list.add(num);
            }
            ans.add(list);
            return;
        }

        for (int i=start;i< nums.length;i++){
            swap(nums,start,i);
            backtrack(ans,nums,start+1);
            swap(nums,start,i);
        }
    }

    private void swap(int[] list,int a, int b){
        int temp = list[a];
        list[a]=list[b];
        list[b] = temp;
    }
}
