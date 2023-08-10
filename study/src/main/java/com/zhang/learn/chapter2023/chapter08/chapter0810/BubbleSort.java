package com.zhang.learn.chapter2023.chapter08.chapter0810;

import java.util.Arrays;

/**
 * @author zhangjiwei1
 * @description 冒泡排序
 * @create 2023-08-10 12:31
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {3, -1, 9, 2, 10,0};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i -1; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
            if(!flag){
                break;
            }else{
                flag = false;
            }
        }
    }
}
