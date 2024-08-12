package Leetcode238;

import java.util.Arrays;

public class Solution {
    public static int[] productExceptSelf(int[] nums) {
        int[] prefixPower=new int[nums.length];
        int numZero=0;
        int[] ret=new int[nums.length];
        if (nums[0]==0){
            prefixPower[0]=1;
            numZero++;
        }else{
            prefixPower[0]=nums[0];
        }

        int index=0;

        for (int i=1;i<nums.length;i++){
            if (nums[i]==0){
                if (numZero==1){
                    numZero++;
                    break;
                }
                numZero++;
                index=i;
                prefixPower[i]=prefixPower[i-1];
            }else {
                prefixPower[i]=prefixPower[i-1]*nums[i];
            }
        }
        int max = prefixPower[prefixPower.length-1];
        if (numZero==0){
            for (int i=0;i<prefixPower.length;i++){
                ret[i]=max/nums[i];
            }
        }else {
            Arrays.fill(ret,0);
            if (numZero==1){
                ret[index]=max;
            }
        }

        return ret;
    }
}
