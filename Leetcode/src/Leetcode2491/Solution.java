package Leetcode2491;

import java.util.Arrays;

public class Solution {
    public long dividePlayers(int[] skill) {
        long res =0;


        if (skill.length%2!=0){
            return -1;
        }
        Arrays.sort(skill);
        int tot= skill[0]+skill[skill.length-1];
        for (int i=0;i<skill.length/2;i++){
            int sum = skill[i]+skill[skill.length-1-i];
            if (sum!=tot){
                return -1;
            }else {
                res += (long) skill[i] *skill[skill.length-1-i];
            }
        }

        return res;
    }
}
