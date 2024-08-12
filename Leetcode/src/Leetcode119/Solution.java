package Leetcode119;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static List<Integer> getRow(int rowIndex) {
        int index=1;
        int[][] pascal =new int[rowIndex+1][rowIndex+1];
        for (int i=0;i<rowIndex+1;i++){
            for (int j=0;j<index;j++){
                if (j==0 || j ==index-1){
                    pascal[i][j]=1;
                }else {
                    pascal[i][j]=pascal[i-1][j-1]+ pascal[i-1][j];
                }
            }
            index++;
        }

        List<Integer> list22  = Arrays.stream( pascal[rowIndex] ).boxed().collect( Collectors.toList() );
        return list22;
    }
}
