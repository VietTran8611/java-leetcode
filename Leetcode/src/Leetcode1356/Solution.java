package Leetcode1356;

import java.util.*;

public class Solution {
    public static int[] sortByBits(int[] arr) {
        List<Integer> list1= new ArrayList<Integer>();
        List<Integer> list2= new ArrayList<Integer>();
        for (int i=0;i<arr.length;i++){
            if ((arr[i] & -arr[i])!=arr[i]){
                list1.add(arr[i]);
            }else {
                list2.add(arr[i]);
            }
        }

        Collections.sort(list1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1==o2){
                    return 0;
                }else if (Integer.bitCount(o1) > Integer.bitCount(o2)){
                    return 1;
                }else if (Integer.bitCount(o1) == Integer.bitCount(o2) && o1>o2){
                    return 1;
                }else {
                    return -1;
                }
            }
        });
        Collections.sort(list2);
        list2.addAll(list1);
        int[] arr1 = list2.stream().mapToInt(i -> i).toArray();
        return arr1;
    }
}
