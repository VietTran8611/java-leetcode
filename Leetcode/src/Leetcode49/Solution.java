package Leetcode49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public static List<List<String>> groupAnagrams(String[] strs) {
        int index =0;
        HashMap<String,Integer> map= new HashMap<String,Integer>();
        List<List<String>> listOLists = new ArrayList<List<String>>();
        for (int i=0;i<strs.length;i++){
            List<String> singleList = new ArrayList<String>();
            char[] ch1=strs[i].toCharArray();
            Arrays.sort(ch1);
            String str1= new String(ch1);
            if (!map.containsKey(str1)){
                map.put(str1,index);
                index++;
                singleList.add(strs[i]);
                listOLists.add(singleList);
            }else {
                int j=map.get(str1);
                singleList=listOLists.get(j);
                singleList.add(strs[i]);
                listOLists.set(j,singleList);
            }
        }
        return listOLists;
    }
}
