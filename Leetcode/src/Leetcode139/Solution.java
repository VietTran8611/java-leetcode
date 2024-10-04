package Leetcode139;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] arr = new boolean[s.length()+1];
        Arrays.fill(arr,false);
        arr[s.length()]= true;
        for (int i = s.length()-1;i>=0;i--){
            for (String word: wordDict){
                if (i+word.length() <= s.length() && s.startsWith(word,i)){
                    arr[i]=arr[i+word.length()];
                }
                if (arr[i]){
                    break;
                }
            }
        }
        return arr[0];
    }
}
