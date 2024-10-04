package Leetcode647;

public class SOlution {
    public static void main(String[] args) {
        String s ="aaa";
        System.out.println(countSubstrings(s));
    }
    public static int countSubstrings(String s) {
        if (s.length()==1){
            return 1;
        }
        int res =0;
        for (int i=0;i<s.length();i++){
            res+=helper(s,i,i);
            res+=helper(s,i,i+1);
        }
        return res;
    }

    private static int helper(String s,int left,int right){
        int res =0;
        while (left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
            res++;
            left--;
            right++;
        }

        return res;
    }
}
