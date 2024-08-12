package Leetcode39;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
      int[] nums = {2,3,6,7};
      int target = 7;
      Solution sol = new Solution();
      System.out.println(sol.combinationSum(nums,target));
    }

    public  List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(ans,0,candidates,target,list);
        return ans;
    }

    public void backtrack(List<List<Integer>> ans,int index, int[] candidates,int target ,  List<Integer> list){
        if (target==0){
            ans.add(new ArrayList<>(list));
        }else if (target<0 || index >=candidates.length){
            return;
        }else {
            list.add(candidates[index]);
            backtrack(ans,index,candidates,target-candidates[index],list);
            list.remove(list.size()-1);
            backtrack(ans,index+1,candidates,target,list);

        }
    }
}
