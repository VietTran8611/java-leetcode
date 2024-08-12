package session5_q2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class vtran86_session5_q2 {
    int[][] Tibet;
    int[][] Nepal;
    int[][] mount;
    int row;
    int col;
    public static void main(String[] args) {


        int[][] everest = {
        {1, 2, 2, 3, 5},
        {3, 2, 3, 4, 4},
        {2, 4, 5, 3, 1},
        {6, 7, 1, 4, 5},
        {5, 1, 1, 2, 4}};

        vtran86_session5_q2 trest = new vtran86_session5_q2();
        System.out.println(trest.Solution(everest));
    }

    public int Solution(int[][] everest){
        row = everest.length;
        col = everest[0].length;
        Tibet = new int[row][col];
        Nepal=new int[row][col];
        mount=everest;

        int count = 0;
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                isNepal(i,j);
                isTibet(i,j);
            }
        }

        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                if (Nepal[i][j]==1 && Tibet[i][j]==1){
                    count++;
                }
            }
        }

        return count;
    }

    private boolean isNepal(int rpos,int cpos){
        boolean check = false;
        Nepal[rpos][cpos]=3;

        if (Nepal[rpos][cpos]==1){
            return true;
        }else if (Nepal[rpos][cpos]==2){
            return false;
        }
        else if (rpos==this.row-1 || cpos == this.col -1 ){
            Nepal[rpos][cpos]=1;
            return true;
        }else if (rpos==0){
            if (cpos!=0){
                if (this.mount[rpos][cpos-1] <= this.mount[rpos][cpos] && Nepal[rpos][cpos-1] !=3){
                    if (isNepal(rpos,cpos-1)){
                        check=true;
                    }
                }
            }
        }else if(cpos==0){
            if (this.mount[rpos-1][cpos] <= this.mount[rpos][cpos] && Nepal[rpos-1][cpos] !=3){
                if (isNepal(rpos-1,cpos)){
                    check=true;
                }
            }
        } else {
            if (this.mount[rpos-1][cpos] <= this.mount[rpos][cpos] && Nepal[rpos-1][cpos] !=3){
                if (isNepal(rpos-1,cpos)){
                    check=true;
                }
            }
            if (this.mount[rpos][cpos-1] <= this.mount[rpos][cpos] && Nepal[rpos][cpos-1] !=3){
                if (isNepal(rpos,cpos-1)){
                    check=true;
                }
            }
        }


        if (this.mount[rpos][cpos+1] <= this.mount[rpos][cpos] && Nepal[rpos][cpos+1] !=3){
            if (isNepal(rpos,cpos+1)){
                check=true;
            }
        }

        if (this.mount[rpos+1][cpos] <= this.mount[rpos][cpos] && Nepal[rpos+1][cpos] !=3){
            if (isNepal(rpos+1,cpos)){
                check=true;
            }
        }

        if (check){
            Nepal[rpos][cpos]=1;
        }else {
            Nepal[rpos][cpos]=2;
        }
        return check;
    }

    private boolean isTibet(int rpos,int cpos){
        boolean check = false;
        Tibet[rpos][cpos]=3;

        if (Tibet[rpos][cpos]==1){
            return true;
        }else if (Tibet[rpos][cpos]==2){
            return false;
        }
        else if (rpos==0 || cpos == 0){
            Tibet[rpos][cpos]=1;
            return true;
        }

        if (rpos==this.row-1){
            if (cpos!=this.col-1){
                if (this.mount[rpos][cpos+1] <= this.mount[rpos][cpos] && Tibet[rpos][cpos+1]!=3){
                    if (isTibet(rpos,cpos+1)){
                        check=true;
                    }
                }
            }
        }else if(cpos==this.col-1){
            if (this.mount[rpos+1][cpos] <= this.mount[rpos][cpos] && Tibet[rpos+1][cpos]!=3){
                if (isTibet(rpos+1,cpos)){
                    check=true;
                }
            }
        } else {
            if (this.mount[rpos+1][cpos] <= this.mount[rpos][cpos] && Tibet[rpos+1][cpos]!=3){
                if (isTibet(rpos+1,cpos)){
                    check=true;
                }
            }
            if (this.mount[rpos][cpos+1] <= this.mount[rpos][cpos] && Tibet[rpos][cpos+1]!=3){
                if (isTibet(rpos,cpos+1)){
                    check=true;
                }
            }
        }


        if (this.mount[rpos][cpos-1] <= this.mount[rpos][cpos] && Tibet[rpos][cpos-1]!=3){
            if (isTibet(rpos,cpos-1)){
                check=true;
            }
        }

        if (this.mount[rpos-1][cpos] <= this.mount[rpos][cpos] && Tibet[rpos-1][cpos]!=3){
            if (isTibet(rpos-1,cpos)){
                check=true;
            }
        }

        if (check){
            Tibet[rpos][cpos]=1;
        }else {
            Tibet[rpos][cpos]=2;
        }


        return check;
    }

}
