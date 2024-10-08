package Leetcode11;

public class Solution {
    public static void main(String[] args) {

    }

    public int maxArea(int[] height) {
        int left =0;
        int right = height.length-1;
        int max = Math.min(height[left],height[right])*(right-left);
        while (left<right){
            max=Math.max(max,Math.min(height[left],height[right])*(right-left));
            if (height[left]<=height[right]){
                left++;
            }else {
                right--;
            }
        }
        return max;
    }
}
