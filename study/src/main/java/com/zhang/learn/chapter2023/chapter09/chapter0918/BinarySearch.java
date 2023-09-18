package com.zhang.learn.chapter2023.chapter09.chapter0918;

/**
 * 寻找峰值
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 5, 6, 8, 15, 9, 8, 2, 1};
        System.out.println(find(arr));

        int[] arr2 = {1, 5, 6, 8, 15, 0};
        System.out.println(find(arr2));

        int[] arr3 = {15, 9, 8, 2, 1};
        System.out.println(find(arr3));
    }

    private static int find(int[] arr) {
        if (arr.length == 1) {
            return 0;
        }
        if (arr[0] > arr[1]) {
            return 0;
        }
        int n = arr.length;
        if (arr[n - 1] > arr[n - 2]) {
            return n - 1;
        }
        int l = 1, r = n - 2, mid = 0, ans = -1;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (arr[mid - 1] > arr[mid]) {
                r = mid - 1;
            } else if (arr[mid + 1] > arr[mid]) {
                l = mid + 1;
            } else {
                ans = mid;
                break;
            }
        }
        return ans;
    }
}
