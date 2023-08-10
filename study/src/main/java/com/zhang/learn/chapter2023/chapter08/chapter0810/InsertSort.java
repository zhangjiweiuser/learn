package com.zhang.learn.chapter2023.chapter08.chapter0810;

import java.util.Arrays;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-08-10 14:51
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {119,34,15,2,-1,18};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    private static void sort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int val = arr[i];
            int index = i -1;

            while(index >= 0 && val < arr[index]){
                arr[index+1] = arr[index];
                index--;
            }
            arr[index+1] = val;
        }
    }
}
