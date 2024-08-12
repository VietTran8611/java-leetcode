package Leetcode125;

import java.util.Locale;

public class Solution {
    public static boolean isPalindrome(String s) {
        String extract = s.toLowerCase().replaceAll("[^a-z0-9]+", "");
        int low =0;
        int high = extract.length()-1;
        while (low<high){
            if (extract.charAt(low)!=extract.charAt(high)){
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}
