package session6_q1;

import java.util.Arrays;
import java.util.Comparator;

public class vtran86_session6_q1 {
    public static void main(String[] args) {
        //expected 2
        int[][] schedule = {{1,3}, {2,5}, {3,9}, {6,8}};
        System.out.println(Solution(schedule));

        //expected 4
        int[][] schedule2 = {{1,2}, {3,4}, {0,6}, {5,7},{8,9},{5,9}};
        System.out.println(Solution(schedule2));

    }

    public static int Solution(int[][] schedule){
        int event =1;
        int[] currEvent=schedule[0];

        Arrays.sort(schedule, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                if (o1[1]>o2[1]){
                    return 1;
                }else return -1;
            }
        });

        for (int i=1;i<schedule.length;i++){
            if (schedule[i][0]>=currEvent[1]){
                currEvent=schedule[i];
                event++;
            }
        }
        return event;
    }
}
