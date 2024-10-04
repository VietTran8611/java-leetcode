package Leetcode1894;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {3,4,1,2};
        System.out.println(chalkReplacer(nums,25));
    }

    public static int chalkReplacer(int[] chalk, int k) {
        if (k<chalk[0]) return 0;
        for (int i=1;i<chalk.length;i++){
            if (k-chalk[i-1] < chalk[i]){
                return i;
            }
            chalk[i]+=chalk[i-1];
        }

        k %= chalk[chalk.length-1];
        int lo  =0;
        int high = chalk.length-1;
        while (lo<high){
            int mid = (lo+high)/2;
            if (chalk[mid]<=k){
                lo=mid+1;
            }else {
                high=mid+1;
            }
        }
        return lo;
    }
}
