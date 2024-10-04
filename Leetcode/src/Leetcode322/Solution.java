package Leetcode322;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {

    }
    public int coinChange(int[] coins, int amount) {
        if (coins==null || amount<0 || coins.length==0){
            return -1;
        }
        int[] arr = new int[amount+1];
        Arrays.fill(arr,amount+1);
        arr[0] =0;
        for (int i=0;i<=amount;i++){
            for (int coint : coins){
                if (1-coint>=0){
                    arr[i] = Math.min(arr[i],1+arr[i-coint]);
                }
            }
        }
        return arr[amount]!= amount+1 ? arr[amount] : -1;
    }
}
