package com.zhang.learn.chapter2023.chapter08.chapter0810;

import java.util.Arrays;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-08-10 16:38
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8, 5, 7, 4, 3, 1, 6};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int tmp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && tmp < arr[j - gap]) {
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = tmp;
                }
            }
        }
    }
}
