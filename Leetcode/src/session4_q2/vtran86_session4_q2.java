package session4_q2;

import java.util.*;

public class vtran86_session4_q2 {
    public static void main(String[] args) {
        String in = "A*C/B-D+E";
        String in2= "A+B*C+D";
        String in3 = "C*A+B";
        String in4 = "A+B+C*D";
        String in5 = "A+B+C+D";

        System.out.println(Solution(in));
        System.out.println(Solution(in2));
        System.out.println(Solution(in3));
        System.out.println(Solution(in4));
        System.out.println(Solution(in5));



    }

    public static String Solution(String str){
        Deque<Character> operation = new ArrayDeque<>();
        Map<Character,Integer> map=new HashMap<>();
        map.put('+',0);
        map.put('-',0);
        map.put('*',1);
        map.put('/',1);

        String postfix ="";

        for(int i=0;i<str.length();i++){
            if (!map.containsKey(str.charAt(i))){
                postfix+=str.charAt(i);
            }else {
                if (operation.isEmpty()){
                    operation.addLast(str.charAt(i));
                }else {
                    while (map.get(operation.peekLast())>=map.get(str.charAt(i))){
                        postfix+=operation.removeLast();
                        if (operation.isEmpty()){
                            break;
                        }
                    }
                    operation.addLast(str.charAt(i));
                }
            }
        }

        while (!operation.isEmpty()){
            postfix+=operation.removeLast();
        }
        return postfix;
    }
}
