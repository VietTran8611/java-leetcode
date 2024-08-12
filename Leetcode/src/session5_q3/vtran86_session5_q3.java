package session5_q3;

import java.util.*;

public class vtran86_session5_q3 {
    Map<Character, Set<Character>> children ;
    Map<Character, Set<Character>> parents ;
    List<Character> revDictionary ;

    public static void main(String[] args) {
        String[] str ={"baa", "abcd", "abca", "cab", "cad"};
        vtran86_session5_q3 vt = new vtran86_session5_q3();
        System.out.println(vt.dictionary(str));

        String[] str2 ={ "wrt", "wrf", "er", "ett", "rftt"};
        System.out.println(vt.dictionary(str2));

    }

    public String dictionary(String[] str){
         children = new HashMap<>();
         parents = new HashMap<>();
        revDictionary = new ArrayList<>();

        for (int i=0;i<str.length;i++){
            for (int j=0;j<str[i].length();j++){
                this.children.put(str[i].charAt(j),new HashSet<>());
                this.parents.put(str[i].charAt(j),new HashSet<>());
            }
        }

        for (int i=0;i<str.length-1;i++){
            if (!populateGraph(str[i], str[i + 1])){
                return "";
            }
        }

        for (char c : this.children.keySet()) {
            topology(c);
        }

        StringBuilder sb=new StringBuilder();
        for (char c: revDictionary){
            sb.append(c);
        }

        return sb.reverse().toString();
    }

    private boolean populateGraph(String str1,String str2){
        int length = Math.min(str1.length(),str2.length());
        for (int i=0;i<length;i++){
            char char1 = str1.charAt(i);
            char char2= str2.charAt(i);
            if (char1!=char2){
                Set<Character> edge = this.children.get(char1);
                edge.add(char2);
                this.children.put(char1,edge);

                Set<Character> pEdge = this.parents.get(char2);
                pEdge.add(char1);
                this.parents.put(char2,pEdge);

                return true;
            }
        }

        return (str1.length()<=str2.length());
    }


    private void  topology(Character cha){
        List<Character> dictionaryReverse= new ArrayList<>();
        Set<Character> child = children.get(cha);
        Set<Character> pare=parents.get(cha);
        pare.remove(cha);
        parents.put(cha,pare);

        if (revDictionary.contains(cha)){
            return;
        }
        while (!child.isEmpty()){
            Character ch2 = child.iterator().next();
            Set<Character> ch =   children.get(cha);
            ch.remove(ch2);
            parents.put(cha,ch);
            topology(ch2);

        }
        if (child.isEmpty()){
            revDictionary.add(cha);
        }

    }
}
