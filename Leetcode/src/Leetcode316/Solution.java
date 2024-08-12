package Leetcode316;

import java.util.*;

public class Solution {
    public static String removeDuplicateLetters(String s) {
        String out = "";
        int index = 0;
        for (int i=0;i<s.length();i++){
            if (out.indexOf(s.charAt(i)) == -1){
                out+=s.charAt(i);
                if (s.charAt(i)<out.charAt(index)){
                    index=i;
                }
            } else if (out.indexOf(s.charAt(i)) != -1 ){
                out=out.replace(String.valueOf(s.charAt(i)),"");
                out+=s.charAt(i);
                index--;
            }
        }
        System.out.println(out);
        return out;
    }


    public static String getStringRepresentation(ArrayList<Character> list)
    {
        StringBuilder builder = new StringBuilder(list.size());
        for(Character ch: list)
        {
            builder.append(ch);
        }
        return builder.toString();
    }

}
