package com.zhang.learn.chapter2023.chapter07.chapter0713;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-07-13 18:56
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {-1,0,3,4,6,10,13,14};
        int target = 13;
        System.out.println(search(arr,target));
    }
    public static int search (int[] nums, int target) {
        // write code here
        return search2(nums,0,nums.length-1,target);
    }

    private static int search2(int[] nums,int left,int right,int target){
        if(left > right){
            return -1;
        }
        int mid = (left + right) / 2;
        if(nums[mid] == target){
            return mid;
        }else if(nums[mid] < target){
            return search2(nums,mid + 1,right,target);
        }else{
            return search2(nums,left,mid - 1,target);
        }
    }

}
