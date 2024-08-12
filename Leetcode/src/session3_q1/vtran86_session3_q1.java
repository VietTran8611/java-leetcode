package session3_q1;

import java.util.*;

public class vtran86_session3_q1 {
    public static void main(String[] args) {
        int[] entry= {1, 2, 9, 5, 5};
        int[] exit = {4, 5, 12, 9, 12};

        int[] entry2= {3, 5, 8, 10, 12};
        int[] exit2 = {4, 6, 9, 15, 20};

        int[] entry3= {1, 2, 9, 5, 5};
        int[] exit3 = {4, 5, 12, 9, 12};

        int[] entry4= {3, 3, 9, 10, 8, 12};
        int[] exit4 = {4, 6, 20, 15, 12, 16};

        System.out.println(MaxGuestsTime(entry,exit));
        //{1=1, 2=2, 3=2, 4=2, 5=3, 6=2, 7=2, 8=2, 9=3, 10=2, 11=2, 12=2}
        //5

        System.out.println(MaxGuestsTime(entry2,exit2));
        //{3=1, 4=1, 5=1, 6=1, 7=0, 8=1, 9=1, 10=1, 11=1, 12=2, 13=2, 14=2, 15=2, 16=1, 17=1, 18=1, 19=1, 20=1}
        //12

        System.out.println(MaxGuestsTime(entry3,exit3));
        //{1=1, 2=2, 3=2, 4=2, 5=3, 6=2, 7=2, 8=2, 9=3, 10=2, 11=2, 12=2}
        //5

        System.out.println(MaxGuestsTime(entry4,exit4));
        //{3=2, 4=2, 5=1, 6=1, 7=0, 8=1, 9=2, 10=3, 11=3, 12=4, 13=3, 14=3, 15=3, 16=2, 17=1, 18=1, 19=1, 20=1}
        //12

    }

    public static int MaxGuestsTime(int[] entry,int[] exit){
        Map<Integer,Integer> dictionary = new HashMap<>();
        int[] sortedEntry = entry;
        int[] sortedExit = exit;

        Arrays.sort(sortedEntry);
        Arrays.sort(sortedExit);
        for (int i = sortedEntry[0];i<=sortedExit[sortedExit.length-1];i++){
            dictionary.put(i,0);
        }

        for (int i=0;i<entry.length;i++){
            int stayTIme=exit[i]-entry[i];
            for (int j=0;j<=stayTIme;j++){
                dictionary.put(entry[i]+j,dictionary.get(entry[i]+j)+1);
            }
        }
        System.out.println(dictionary);
        int time= Collections.max(dictionary.entrySet(), Map.Entry.comparingByValue()).getKey();;

        return time;
    }
}
