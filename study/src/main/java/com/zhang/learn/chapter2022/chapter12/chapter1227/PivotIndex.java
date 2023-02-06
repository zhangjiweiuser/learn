package com.zhang.learn.chapter2022.chapter12.chapter1227;

/**
 * @author zhangjiwei1
 * @description 求数组的中心下标，有一个数组arr，如果存在某个下标，使左边的和等于右边的和，
 * 则返回其下标，否则返回-1，如果存在多个中心下标，返回左边的那个
 * @create 2022-12-27 14:30
 */
public class PivotIndex {
    public static void main(String[] args) {
        int[] arr = {1, 7, 3, 6, 5, 6};
        System.out.println(pivotIndex(arr));
    }

    private static int pivotIndex(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        int sumLeft = 0;
        for (int i = 0; i < arr.length; i++) {
            sum -= arr[i];
            if (sumLeft == sum) {
                return i;
            }
            sumLeft += arr[i];
        }
        return -1;
    }
}
