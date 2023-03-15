package com.zhang.learn.chapter2023.chapter03.chapter0308;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-03-08 17:24
 */
public class MaxNum {
    public static void main(String[] args) {
        int[] arr = {100,2,45,8,7,5,78,2,5,4,58};
        System.out.println(max(arr,0,arr.length-1));
    }

    private static int max(int[] arr,int left,int right){
        if(left == right){
            return arr[left];
        }
        int mid = left + (right - left) / 2;
        int maxLeft = max(arr,left,mid);
        int maxRight = max(arr,mid+1,right);
        return Math.max(maxLeft,maxRight);
    }
}
