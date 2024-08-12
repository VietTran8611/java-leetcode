package Leetcode875;

public class Solution {
    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        minEatingSpeed(piles,8);
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int left =1;
        int right =1;
        for (int pile : piles){
            right = Math.max(right,pile);
        }

        while (left<right){
            int middle = (right+left)/2;
            int hours =0;

            for (int pile : piles){
                hours+=Math.ceil((double) pile/middle);
            }

            if (hours<=h){
                right=middle;
            }else {
                left=middle+1;
            }
        }

        return right;
    }
}
