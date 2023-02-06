package com.zhang.learn.chapter2021.chapter06.chapter0630;

import java.util.Arrays;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/6/30 17:29
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] a = {5, 6, 4, 7, 5, 3};
        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 插入排序
     *
     * @param a
     */
    public static void sort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    int tmp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = tmp;
                }
            }
        }
    }

    /**
     * 简单选择排序
     *
     * @param a
     */
    public static void sort2(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            // 选出之后待排序中值最小的位置
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            // 最小值不等于当前值时进行交换
            if (min != i) {
                int tmp = a[i];
                a[i] = a[min];
                a[min] = tmp;
            }
        }
    }

    /**
     * 快速排序
     *
     * @param a
     */
    public static void quickSort(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        int left = low;
        int right = high;
        int pivot = a[left];
        while (left < right) {
            while (left < right && a[right] >= pivot) {
                right--;
            }
            a[left] = a[right];
            while (left < right && a[left] <= pivot) {
                left++;
            }
            a[right] = a[left];
        }
        a[left] = pivot;
        quickSort(a, low, left - 1);
        quickSort(a, left + 1, high);

    }
}
