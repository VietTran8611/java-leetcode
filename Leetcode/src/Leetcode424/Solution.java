package Leetcode424;

public class Solution {
    public static void main(String[] args) {

    }

    public static int characterReplacement(String s, int k) {
        int[] map = new int[26];
        int max =0;
        int ans =0;
        int left =0;
        for (int right = 0;right<s.length();right++){
            map[s.charAt(right)-'A']++;
            max= Math.max(max,map[s.charAt(right)-'A']);
            if (right-left+1-max>k){
                map[s.charAt(right)-'A']--;
                left++;
            }
            ans=Math.max(ans,left-right+1);
        }

        return ans;
    }
}
