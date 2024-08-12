package Leetcode880;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SOlution {
    public static String decodeAtIndex(String s, int k) {
        String out ="";
        int count=0;
        int mul=1;
        boolean found=false;
        String temp="";
        Stack<String> stringStack = new Stack<>();
        Stack<Integer> integerStack= new Stack<>();
        StringBuilder inStack= new StringBuilder();
        StringBuilder dup= new StringBuilder();
        boolean breakFlag=false;
        for (int i=0;i<s.length();i++){
            char c= s.charAt(i);
            if (Character.isLetter(c)){
                if (mul!=1){
                    count += count*(mul-1);
                    integerStack.add(mul);
                    mul=1;
                }
                inStack.append(c);
                count++;
                if (count==k){
                    out+=c;
                    found=true;
                }


            }else if (Character.isDigit(c)){
                if (!inStack.isEmpty()){
                    stringStack.add(inStack.toString());
                    inStack.setLength(0);
                }

                mul*=(c-'0');
                if (k< count+ count*(mul-1)){
                    count=count+ count*(mul-1);
                    integerStack.add(mul);
                    breakFlag=true;
                }
            }

            if (breakFlag){
                break;
            }
        }

        System.out.println(stringStack.toString());
        System.out.println(integerStack.toString());
        while (!found){
            String tempStr= stringStack.pop();
            int tempInt=integerStack.pop();
            System.out.println(count);
            found=true;
        }
        return out;
    }
}
