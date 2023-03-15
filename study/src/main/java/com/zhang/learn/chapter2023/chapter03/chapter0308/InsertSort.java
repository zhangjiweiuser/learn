package com.zhang.learn.chapter2023.chapter03.chapter0308;

import java.util.Arrays;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-03-08 17:00
 */
public class InsertSort extends Swap {
    public static void main(String[] args) {
        int[] arr = {2, 5, 6, 7, 41, 2, 5, 1, 4};
        insertSort(arr);
    }

    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
