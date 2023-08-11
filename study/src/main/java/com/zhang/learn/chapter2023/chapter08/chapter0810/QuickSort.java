package com.zhang.learn.chapter2023.chapter08.chapter0810;

import java.util.Arrays;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-08-10 17:07
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1, 89, 15, 4, 3, -1, 4, 8, 12, 56, 4, 1};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int l = left;
        int r = right;
        int pivot = arr[l];
        while (l < r) {
            // 假定从右边开始查找，先找到小于 pivot 的数
            while (l < r && arr[r] >= pivot) {
                r--;
            }
            // 再从左边找，找到 大于 pivot 的数
            while (l < r && arr[l] <= pivot) {
                l++;
            }
            // 如果这两个位置不相同，再进行交换，然后再次进行寻找
            if (l < r) {
                int t = arr[l];
                arr[l] = arr[r];
                arr[r] = t;
            }
        }
        // 这个时候，l == r
        System.out.println("l=" + l + ",r=" + r);
        // 将基准数转移到 l 位置，则 l 左边的全部小于 l ， l右边的全部大于 l
        if (l != left) {
            arr[left] = arr[l];
            arr[l] = pivot;
        }

        sort(arr, left, l - 1);
        sort(arr, l + 1, right);
    }
}
