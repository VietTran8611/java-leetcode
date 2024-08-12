package session3_q4;

import java.sql.Array;
import java.util.Arrays;

public class vtran86_session3_q4 {
    static class NumMatrix {
        private int[][] prefixSum;
        public NumMatrix(int[][] matrix) {
            prefixSum = new int[matrix.length+1][matrix[0].length+1];
            for(int i=1;i<=matrix.length;i++){
                for(int j=1;j<=matrix[0].length;j++){
                    prefixSum[i][j]=prefixSum[i][j-1]+prefixSum[i-1][j]-prefixSum[i-1][j-1]+matrix[i-1][j-1];
                }
            }
            System.out.println("prefixSum array:");
            System.out.println(Arrays.deepToString(prefixSum));
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            row1++;row2++;col1++;col2++;
            return prefixSum[row2][col2]-prefixSum[row1-1][col2]-prefixSum[row2][col1-1]+prefixSum[row1-1][col1-1];
        }
    }

    public static void main(String[] args) {
        int[][] nums= {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        NumMatrix numMatrix = new NumMatrix(nums);
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2));
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4));
    }
}
