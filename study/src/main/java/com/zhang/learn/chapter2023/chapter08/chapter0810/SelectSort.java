package com.zhang.learn.chapter2023.chapter08.chapter0810;

import java.util.Arrays;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-08-10 14:26
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        // 使用逐步推导的方式，
        // 原始数组 101，34，119，1
        // 第一轮： 1，34，119，101
        // 第二轮： 1，34，119，101
        // 第三轮： 1，34，101，119
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int t = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = t;
            }
        }
    }
}
