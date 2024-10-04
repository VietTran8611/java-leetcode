package Leetcode1371;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int findTheLongestSubstring(String s) {
        int max =0;
        int currMask = 0;
        Map<Integer,Integer> prefix= new HashMap<>();
        prefix.put(0,-1);

        for (int i=0;i<s.length();i++){
            if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u') {
                currMask ^= (1 << ((int)(s.charAt(i) - 'a')));
            }
            System.out.println(currMask);
            if (prefix.containsKey(currMask)){
                max=Math.max(max,i-prefix.get(currMask));
            }else {
                prefix.put(currMask,i);
            }
        }

        return max;
    }
}
