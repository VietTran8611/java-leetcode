package Leetcode739;

import java.util.Arrays;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        int[] temp = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(temp)));

    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();

        for (int i=0;i<temperatures.length;i++){
            if (stack.isEmpty() || temperatures[i]<=stack.peek()[0]){
                int[] pos = {temperatures[i],i};
                stack.push(pos);
            }else {
                while (!stack.isEmpty() && temperatures[i]>stack.peek()[0]){
                    int[] temp = stack.pop();
                    res[temp[1]] = i - temp[1];
                }
                int[] pos = {temperatures[i],i};
                stack.push(pos);
            }
        }

        return res;
    }
}
