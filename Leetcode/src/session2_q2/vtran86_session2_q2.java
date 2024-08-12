package session2_q2;

import Leetcode153.Solution;

import java.util.Arrays;

public class vtran86_session2_q2 {
    public static void main(String[] args) {
        int[] in={20,10,8,6,4,2};
        int[] in2={10,5,6,2,20,3,100,80};

        System.out.println(Arrays.toString(Solution(in)));
        //out [20, 8, 10, 4, 6, 2]
        System.out.println(Arrays.toString(Solution(in2)));
        //[10, 5, 6, 2, 20, 3, 100, 80]

    }

    public static int[] Solution(int[] arr){
        int tail=0;
        int temp=0;

        //mode 0 is >= compare and mode 1 is <= compare
        int mode =0;

        for (int i=1;i<arr.length;i++){
            switch (mode){
                case 0:
                    if (!(arr[tail]>=arr[i])){
                        temp=arr[tail];
                        arr[tail]=arr[i];
                        arr[i]=temp;
                    }
                    mode =1;
                    break;
                case 1:
                    if (!(arr[tail]<=arr[i])){
                        temp=arr[tail];
                        arr[tail]=arr[i];
                        arr[i]=temp;
                    }
                    mode =0;
                    break;
                default:
            }
            tail++;
        }
        return arr;
    }
}
