package Leetcode150;

import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        String[] tokens= {"2","1","+","3","*"};
        System.out.println(evalRPN(tokens));

    }
    static int num=0;

    public static boolean isInt(String str){
        try {
            num = Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static int evalRPN(String[] tokens) {
        if (tokens.length==1){
            isInt(tokens[0]);
            return num;
        }
        int num1,num2;
        int curr=0;
        boolean check=false;
        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<tokens.length;i++){
            if (isInt(tokens[i])){
                stack.push(num);
            }else {
                num1=stack.pop();
                num2=stack.pop();
                switch (tokens[i]){
                    case "+":
                        curr=num1+num2;
                        break;
                    case "-":
                        curr=num2-num1;
                        break;
                    case "*":
                        curr=num1*num2;
                        break;
                    case "/":
                        curr=num2/num1;
                        break;
                }
                stack.push(curr);
            }

        }

        return curr;
    }
}
