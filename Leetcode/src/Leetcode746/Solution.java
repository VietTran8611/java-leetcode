package Leetcode746;

public class Solution {
    public static void main(String[] args) {
        int[] cost = {10,15,20};
        System.out.println(minCostClimbingStairs(cost));
    }

    public static int minCostClimbingStairs(int[] cost) {
        int i1=0;
        int i2 = 0;
        for (int i=cost.length-1;i>=0;i--){
            cost[i] += Math.min(i1,i2);
            i1= i2;
            i2 = cost[i];
        }

        return Math.min(cost[0],cost[1]);
    }
}
