package session3_q2;

import java.util.Arrays;

public class vtran86_session3_q2 {
    public static void main(String[] args) {
        int[] house = {1,5};
        int[] heater = {2};
        System.out.println(findRadius(house,heater));

    }

    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        Arrays.sort(houses);
        int max = -1;
        for (int i=0;i<houses.length;i++){
            max = Math.max(max,binarySearch(houses[i],heaters));
        }
        return max;
    }

    public static int binarySearch(int house, int[] heater){

        int low =0;
        int high = heater.length-1;
        int min = Integer.MAX_VALUE;
        while (low<=high){
            int mid = low+(high-low)/2;
            if (heater[mid] == house){
                return 0;
            }else if (heater[mid]<house){
                min=Math.min(min,Math.abs(heater[mid]-house));
                low=mid+1;
            }else {
                min=Math.min(min,Math.abs(heater[mid]-house));
                high=mid-1;
            }

        }
        return min;
    }
}
