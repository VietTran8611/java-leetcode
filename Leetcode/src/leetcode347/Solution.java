package leetcode347;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public  class Solution {
    public static int[] topKFrequent(int[] nums, int k) {
        int[] ret = new int[k];
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i=0;i<nums.length;i++){
            if (!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else {
                map.put(nums[i],map.get(nums[i])+1);
            }
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (a,b) -> a.getValue()==b.getValue() ? b.getKey().compareTo(a.getKey()) : b.getValue()-a.getValue()
        );
        for(Map.Entry<Integer, Integer> entry: map.entrySet())
        {
            pq.offer(entry);
        }
        for (int i=0;i<k;i++){
            ret[i]=pq.poll().getKey();
        }

        return ret;
    }
}
