package Leetcode167;

public class Solution {
    public static int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length-1;
        int[] ret = new int[2];
        int curr = numbers[low]+numbers[high];
        while (curr!=target){
            if (curr>target){
                high--;
            }else {
                low++;
            }
            curr = numbers[low]+numbers[high];
        }
        ret[0]=low+1;
        ret[1]=high+1;
        return ret;
    }
}
