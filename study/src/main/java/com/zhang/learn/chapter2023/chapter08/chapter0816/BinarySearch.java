package com.zhang.learn.chapter2023.chapter08.chapter0816;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-08-16 14:33
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 9, 10, 15, 18, 20, 22};
        System.out.println(search(arr, 1));
        System.out.println(search(arr, 15));
        System.out.println(search(arr, 18));
        System.out.println(search(arr, 20));
        System.out.println(search(arr, 22));
    }

    private static int search(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
