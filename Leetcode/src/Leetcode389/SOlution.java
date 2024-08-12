package Leetcode389;

public class SOlution {
    public static char findTheDifference(String s, String t) {
        String alphabet ="abcdefghijklmnopqrstuvwxyz";
        int xorNum=1;
        int binaryAlphabet1=0;
        int binaryAlphabet2=0;
        for (int i=0;i<t.length();i++){
            if (i!= t.length()-1){
                binaryAlphabet1=binaryAlphabet1 ^ (xorNum<< (s.charAt(i)-'a'));
            }
            binaryAlphabet2=binaryAlphabet2 ^ (xorNum<< (t.charAt(i)-'a'));
        }
        int index= (int) (Math.log(Math.abs(binaryAlphabet2-binaryAlphabet1)) / Math.log(2));

        return alphabet.charAt(index);
    }
}
