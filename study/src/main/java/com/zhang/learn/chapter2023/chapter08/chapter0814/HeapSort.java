package com.zhang.learn.chapter2023.chapter08.chapter0814;

import java.util.Arrays;

/**
 * @author zhangjiwei1
 * @description 堆排序
 * @create 2023-08-14 10:05
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9};

        sort(arr);


    }

    private static void sort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjust(arr, i, arr.length);
        }

        for (int i = arr.length - 1; i > 0; i--) {
            int tmp = arr[i];
            arr[i] = arr[0];
            arr[0] = tmp;
            adjust(arr, 0, i);
        }

        System.out.println(Arrays.toString(arr));
    }

    /**
     * @param arr    要调整的数组
     * @param i      从第几个开始调整
     * @param length 要调整的数组长度
     */
    private static void adjust(int[] arr, int i, int length) {
        int tmp = arr[i];
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
            // 说明左子结点 小于 右子结点，
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++; // 指向右节点
            }
            if (tmp < arr[k]) {
                arr[i] = arr[k]; // 把较大的值赋值给当前节点
                i = k; // i 指向k，继续循环比较
            } else {
                break;
            }
        }
        arr[i] = tmp;
    }
}
