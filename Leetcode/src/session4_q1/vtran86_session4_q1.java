package session4_q1;

import java.util.Arrays;
import java.util.PriorityQueue;

public class vtran86_session4_q1 {
    public static void main(String[] args) {
        int[] nums ={6, 8, 4, 5, 2, 3};
        int[] nums2= {5, 2, 0, 1, 7};
        int[] nums3= {5};
        int[] nums4= {5, 2, 0, 1, 7,6};


        System.out.println(Solution(nums));
        System.out.println(Solution(nums2));
        System.out.println(Solution(nums3));
        System.out.println(Solution(nums4));

    }

    public static int Solution(int[] nums){
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        int num1=0;
        int num2=0;
        for (int i=0;i< nums.length;i++){
            minHeap.add(nums[i]);
        }

        for (int i=0;i< nums.length;i++){
            if (i%2==0){
                num1=num1*10+minHeap.remove();
            }else {
                num2=num2*10+minHeap.remove();
            }
        }
        System.out.printf("1st number: %d , 2nd number: %d%n",num1,num2);
        return num1+num2;
    }
}
