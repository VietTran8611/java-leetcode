package Leetcode78;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Solution sol = new Solution();
        System.out.println(sol.subsets(nums));
    }

    public  List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(ans,0,nums,list);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, int start,int[] nums, List<Integer> list){
        if (start>= nums.length){
            ans.add(new ArrayList<>(list));
        }else {
            list.add(nums[start]);
            backtrack(ans,start+1,nums,list);
            list.remove(list.size()-1);
            backtrack(ans,start+1,nums,list);

        }
    }
}
