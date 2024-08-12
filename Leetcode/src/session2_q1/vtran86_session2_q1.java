package session2_q1;

import java.util.ArrayList;
import java.util.List;

public class vtran86_session2_q1 {
    public static void main(String[] args) {
        int[][] input = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] input2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int[][] input3 ={{1}};
        int[][] input4 ={{3},{2}};
        int[][] input5 = {{1, 2, 3, 4, 5},{6, 7, 8, 9, 10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};

        int[][] input6={{2,3,4},{5,6,7},{8,9,10},{11,12,13}};

        System.out.println(vtran86_session2_q1.spiralOrder(input));
        //out [1, 2, 3, 6, 9, 8, 7, 4, 5]

        System.out.println(vtran86_session2_q1.spiralOrder(input2));
        //out [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]

        System.out.println(vtran86_session2_q1.spiralOrder(input3));
        //out [1]

        System.out.println(vtran86_session2_q1.spiralOrder(input4));
        //out [3,2]

        System.out.println(vtran86_session2_q1.spiralOrder(input5));
        //out [1, 2, 3, 4, 5, 10, 15, 20, 25, 24, 23, 22, 21, 16, 11, 6, 7, 8, 9, 14, 19, 18, 17, 12, 13]

        System.out.println(vtran86_session2_q1.spiralOrder(input6));
        //out:  [2,3,4,7,10,13,12,11,8,5,6,9]
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();

        //edge case 1D array
        if (matrix.length==1){
            for (int i=0;i<matrix[0].length;i++){
                list.add(matrix[0][i]);
            }
            return list;
        }
        if (matrix[0].length==1){
            for (int i=0;i<matrix.length;i++){
                list.add(matrix[i][0]);
            }
            return list;
        }
        int length = matrix.length*matrix[0].length;
        int i=0,j=-0;

        //boundary to test when to change traverse direction
        int upLeft=0,upRight=matrix[0].length-1,downLeft=0,downRight=matrix.length-1;

        //traverse direction 0=right,1=down,2=left,3=up
        int mode =0;

        for(int x=0;x<length;x++){
            switch (mode){
                case 0:
                    list.add(matrix[i][j]);
                    if (j==upRight){
                        mode =1;
                        i++;
                    }else {
                        j++;
                    }
                    break;
                case 1:
                    list.add(matrix[i][j]);

                    if (i==downRight){
                        mode=2;
                        j--;
                    }else {
                        i++;
                    }
                    break;
                case 2:
                    list.add(matrix[i][j]);

                    if (j==downLeft){
                        mode=3;
                        i--;
                    }else {
                        j--;
                    }
                    break;
                case 3:
                    if (i==upLeft){
                        mode=0;
                        upLeft++;
                        upRight--;
                        downLeft++;
                        downRight--;
                        i++;
                        j++;
                        list.add(matrix[i][j]);
                        if (j!=upRight){
                            j++;
                        }else {
                        //when cant go right or mode 0 test input 6
                         i++;
                         mode =1;
                        }
                    }else {
                        list.add(matrix[i][j]);
                        i--;
                    }
                    break;
                default:
            }
        }

        return list;
    }
}
