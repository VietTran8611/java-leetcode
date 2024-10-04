package Leetcode1046;

import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {2,2};
        System.out.println(lastStoneWeight(arr));
    }

    public static int lastStoneWeight(int[] stones) {
        if (stones.length==1){
            return stones[0];
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for (int stone : stones){
            pq.add(stone);
        }
        while (pq.size()>1){
            int i1= pq.poll();
            int i2=pq.poll();
            if (i1!=i2){
                pq.add(Math.abs(i1-i2));
            }
        }

        return pq.size()!=0 ? pq.poll() : 0;
    }
}
