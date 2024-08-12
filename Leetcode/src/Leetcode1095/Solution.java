package Leetcode1095;

public class Solution {
    public static int findInMountainArray(int target, int[] mountainArr) {
        int length = mountainArr.length;
        int index = peakMountain(mountainArr);
        int out = binarySearch(mountainArr,target,0,index);

        if (out!= -1){
            return out;
        }else{
            return binarySearchReverse(mountainArr,target,index,length-1);
        }
    }

    public static int peakMountain(int[] nums){
        int low =0;
        int high = nums.length-1;

        while (low<high){
            int mid = low+(high-low)/2;
            if (nums[mid] >= nums[mid+1]){
                high=mid;
            }else {
                low=mid+1;
            }
        }
        return low;
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

    public static int binarySearchReverse(int[] list, int key,int low, int high){
        if (low==high && list[low]==key){
            return high;
        }else if (low==high && list[low]!=key){
            return -1;
        }

        while (low<=high){
            int mid=(low+high)/2;
            if (key>list[mid]){
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
