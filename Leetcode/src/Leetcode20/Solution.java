package Leetcode20;

import java.util.Stack;

public class Solution {
    public static boolean isValid(String s) {
        if (s.length()%2==1){
            return false;
        }
        Stack<Character> stack = new Stack<>();

        for (int i=0;i<s.length();i++){
            char c= s.charAt(i);
            switch (c){
                case '(':
                    stack.push(')');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case '[':
                    stack.push(']');
                    break;
                default:
                    if (stack.isEmpty() || c!=stack.peek()){
                        return false;
                    }else {
                        stack.pop();
                    }
            }

        }

        if (stack.empty()){
            return true;
        }else {
            return false;
        }
    }
}
