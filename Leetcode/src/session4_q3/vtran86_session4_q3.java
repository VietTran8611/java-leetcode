package session4_q3;

import java.util.*;

public class vtran86_session4_q3 {
    public static void main(String[] args) {
        int[][] in= {{2,1,1},{1,1,0},{0,1,1}};
        int[][] in2= {
        {2, 1, 0, 2, 1},
        {1, 0, 1, 2, 1},
        {1, 0, 0, 2, 1}};
        System.out.println(Solution(in));
        System.out.println(Solution(in2));

    }

    public static int Solution(int[][] matrix){
        int[][]  newMatrix= new  int[matrix.length+2][matrix[0].length+2];
        int numOf1=0;
        int infest=-1;
        Deque<List<Integer>> queue = new ArrayDeque<>();

        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                newMatrix[i+1][j+1]=matrix[i][j];
                if (matrix[i][j]==2){
                    List<Integer> pos=new ArrayList<>();
                    pos.add(0,i+1);
                    pos.add(1,j+1);
                    queue.addFirst(pos);
                }else if (matrix[i][j]==1){
                    numOf1++;
                }
            }
        }

        if (queue.isEmpty()){
            infest=0;
        }
        while (!queue.isEmpty() ){
            int curr2= queue.size();
            for (int i=0;i<curr2;i++){
                List<Integer> pos=new ArrayList<>();
                pos=queue.removeFirst();
                if (newMatrix[pos.get(0)-1][pos.get(1)]==1){
                    List<Integer> newQueue=new ArrayList<>();
                    numOf1--;
                    newMatrix[pos.get(0)-1][pos.get(1)]=2;
                    newQueue.add(pos.get(0)-1);
                    newQueue.add(pos.get(1));
                    queue.addLast(newQueue);
                }
                if (newMatrix[pos.get(0)+1][pos.get(1)]==1){
                    List<Integer> newQueue=new ArrayList<>();

                    numOf1--;
                    newMatrix[pos.get(0)+1][pos.get(1)]=2;
                    newQueue.add(0,pos.get(0)+1);
                    newQueue.add(1,pos.get(1));
                    queue.addLast(newQueue);
                }
                if (newMatrix[pos.get(0)][pos.get(1)-1]==1){
                    numOf1--;
                    List<Integer> newQueue=new ArrayList<>();
                    newMatrix[pos.get(0)][pos.get(1)-1]=2;
                    newQueue.add(0,pos.get(0));
                    newQueue.add(1,pos.get(1)-1);
                    queue.addLast(newQueue);
                }
                if (newMatrix[pos.get(0)][pos.get(1)+1]==1){
                    List<Integer> newQueue=new ArrayList<>();
                    numOf1--;
                    newMatrix[pos.get(0)][pos.get(1)+1]=2;
                    newQueue.add(0,pos.get(0));
                    newQueue.add(1,pos.get(1)+1);
                    queue.addLast(newQueue);

                }
            }

            infest++;
        }
        if (numOf1!=0){
            return -1;
        }else {
            return infest;
        }
    }
}
