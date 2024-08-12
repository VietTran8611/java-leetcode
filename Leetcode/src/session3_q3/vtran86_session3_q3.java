package session3_q3;

import java.util.HashMap;
import java.util.Map;

public class vtran86_session3_q3 {
    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k=2;
        System.out.println(subarraySum(nums,k));

        int[] nums2 = {1,2,3};
        int k2=3;
        System.out.println(subarraySum(nums2,k2));

        int[] nums3 = {1};
        int k3=0;
        System.out.println(subarraySum(nums3,k3));

        int[] nums4 = {-1,-1,1};
        int k4=0;
        System.out.println(subarraySum(nums4,k4));
    }

    public static int subarraySum(int[] nums, int k) {
        int out =0;
        int currSum=0;
        int remove=0;
        Map<Integer,Integer> prefixSum=new HashMap<>();
        prefixSum.put(0,1);
        for (int i=0;i<nums.length;i++){
            currSum+=nums[i];
            remove= currSum-k;
            if (prefixSum.containsKey(remove)){
                out+=prefixSum.get(remove);
            }

            prefixSum.put(currSum,prefixSum.getOrDefault(currSum,0)+1);
        }

        return out;
    }
}
