package session6_q2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class session6_vtran86_q2 {
    public static void main(String[] args) {
        //expected 17
        int[][] book= {{4,5},{8,8},{5,12},{3,1}};
        System.out.println(Solution(10,book));

        //expected 180
        int[][] book2 = {{20,100}, {10,60}, {30,120},{21,89},{20,20}};
        System.out.println(Solution(50,book2));
    }

    public static int Solution(int budget, int[][] bookPricesandPages){
        int currPg=0;
        Arrays.sort(bookPricesandPages, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                double rate1= (double) o1[1]/(double) o1[0];
                double rate2= (double) o2[1]/(double) o2[0];

                if (rate1<rate2){
                    return 1;
                }else return -1;
            }
        });

        for (int i=0;i<bookPricesandPages.length;i++){
            if (bookPricesandPages[i][0]<=budget){
                currPg+=bookPricesandPages[i][1];
                budget-=bookPricesandPages[i][0];
            }
            if (budget==0){
                break;
            }
        }

        System.out.println(Arrays.deepToString(bookPricesandPages));
        return currPg;
    }
}
