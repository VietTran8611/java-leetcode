import java.util.Arrays;

public class Leetcode1310 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] res = new int[queries.length];
        int[] prefix = new int[arr.length];
        prefix[0]= arr[0];
        for (int i=1;i<arr.length;i++){
            prefix[i]= prefix[i-1]^arr[i];
        }
        System.out.println(Arrays.toString(prefix));

        for (int i=0;i<queries.length;i++){
            if (queries[i][0]==0){
                res[i] = prefix[queries[i][1]];
            }else if (queries[i][0]==queries[i][1]){
                res[i]=arr[queries[i][0]];
            }else {
                res[i] = prefix[queries[i][0]] ^ prefix[queries[i][0]-1];
            }
        }

        return res;
    }
}
