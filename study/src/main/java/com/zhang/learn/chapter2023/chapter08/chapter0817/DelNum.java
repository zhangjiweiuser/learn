package com.zhang.learn.chapter2023.chapter08.chapter0817;

import java.util.Arrays;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-08-17 10:31
 */
public class DelNum {
    public static void main(String[] args) {
        int[] arr = {0,1,2,2,3,0,4,2};
        System.out.println(del(arr,2));
        System.out.println(Arrays.toString(arr));
    }
    private static int del(int[] arr,int target){
        int i=0,j=0;
        for(int a : arr){
            if(a == target){
                j++;
            }else{
                arr[i++] = arr[j++];
            }
        }
        return i;
    }
}
