package Leetcode2038;

public class Solution {
    public static boolean winnerOfGame(String colors) {
        int countA=0;
        int countB=0;
        int curr=1;
        int left=0;
        int right =0;
        char currChar=colors.charAt(0);
        for (int i=1;i<colors.length();i++){
            right=i;
            if (colors.charAt(left)==colors.charAt(i)){
                curr++;
            }else {

                if (curr>2){
                    if (colors.charAt(left) == 'A'){
                        countA+=curr-2;
                    }else {
                        countB+=curr-2;
                    }
                }

                left=right;
                curr=1;
            }
        }

        if (curr>2){
            if (colors.charAt(left) == 'A'){
                countA+=curr-2;
            }else {
                countB+=curr-2;
            }
        }

        return countA>countB;
    }
}
