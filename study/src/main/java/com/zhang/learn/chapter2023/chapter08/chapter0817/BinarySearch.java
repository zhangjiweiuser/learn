package com.zhang.learn.chapter2023.chapter08.chapter0817;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-08-17 10:26
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,3,5,6,7,8,9,10,122,155,166};
        System.out.println(search(arr,9));
    }
    private static int search(int[] arr,int target){
        int left = 0;
        int right = arr.length -1;
        while(left <= right){
            int mid = left + (right - left) /2;
            if(target == arr[mid]){
                return mid;
            }else if(arr[mid] < target){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return -1;
    }
}
