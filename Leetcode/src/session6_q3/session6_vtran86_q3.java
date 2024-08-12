package session6_q3;

public class session6_vtran86_q3 {
    public static void main(String[] args) {
        //expected 5
        System.out.println(Solution(27));

        //expected 7
        System.out.println(Solution(35));

    }

    private static int MaxDIgit(int n)
    {
        int largest = 0;
        while(n != 0)
        {
            int r = n % 10;

            // Find the largest digit
            largest = Math.max(r, largest);
            n = n / 10;
        }
        return largest;

    }

    public static int Solution(int mark){
        int cycle=0;
        while (mark>0){
            mark-=MaxDIgit(mark);
            cycle++;
        }
        return cycle;
    }

}
