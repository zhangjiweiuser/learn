package com.zhang.learn.chapter2023.chapter10.chapter1030;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {2,5,1,89,48,78,45,898};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int l = left;
        int r = right;
        int pivot = arr[left];
        while (l < r) {
            while (l < r && arr[r] >= pivot) {
                r--;
            }
            while (l < r && arr[l] <= pivot) {
                l++;
            }
            if (l != r) {
                int t = arr[l];
                arr[l] = arr[r];
                arr[r] = t;
            }
        }
        arr[left] = arr[l];
        arr[l] = pivot;
        sort(arr, left, l - 1);
        sort(arr, l + 1, right);
    }
}
