package Leetcode34;

public class Solution {
    public static int[] searchRange(int[] nums, int target) {
        int[] out= new int[2];
        if (nums.length==1){
            if (nums[0]==target){
                out[0]=0;
                out[1]=0;
                return out;
            }else {
                out[0]=-1;
                out[1]=-1;
                return out;
            }
        }
        int mid=binarySearch(nums,target,0,nums.length-1);

        out[0]=mid;
        out[1]=mid;
        if (mid==-1){
            return out;
        }else {
            if (nums.length==2){
                if (mid==0){
                    if (nums[1]==nums[mid]){
                        out[0]=0;
                        out[1]=1;
                        return out;
                    }else {
                        return out;
                    }
                }else if (mid==1){
                    if (nums[0]==nums[mid]){
                        out[0]=0;
                        out[1]=1;
                        return out;
                    }else {
                        return out;
                    }
                }
            }
            if (mid!=0){
                while (nums[out[0]]==nums[out[0]-1] ){
                    out[0]=binarySearch(nums,target,0,out[0]-1);
                    if (out[0]== 0){
                        break;
                    }
                }
            }
            if (mid!= nums.length-1){
                while (nums[out[1]]==nums[out[1]+1]){
                    out[1]=binarySearch(nums,target,out[1]+1,nums.length-1);
                    if (out[1]== nums.length-1){
                        break;
                    }
                }
            }

        }

        return out;
    }

    public static int binarySearch(int[] list, int key,int low, int high){
        if (low==high && list[low]==key){
            return high;
        }else if (low==high && list[low]!=key){
            return -1;
        }

        while (high>=low){
            int mid=(low+high)/2;
            if (key<list[mid]){
                high=mid-1;
            }else if (key==list[mid]){
                return mid;
            }else {
                low=mid+1;
            }
        }
        return -1;
    }
}
