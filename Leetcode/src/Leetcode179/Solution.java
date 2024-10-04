package Leetcode179;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    public String largestNumber(int[] nums) {
        StringBuilder ans = new StringBuilder();
        List<String> strings = new ArrayList<>();
        for (int num : nums) {
            strings.add(Integer.toString(num));
        }
        Collections.sort(strings, (a,b)-> (b+a).compareTo(a+b));
        if (strings.get(0).equals("0")){
            return "0";
        }
        for (String s : strings){
            ans.append(s);
        }

        return ans.toString();
    }
}
