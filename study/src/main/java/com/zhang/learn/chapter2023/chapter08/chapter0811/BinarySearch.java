package com.zhang.learn.chapter2023.chapter08.chapter0811;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-08-11 10:39
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 3, 8, 10, 10,10,10,10,10,10, 10, 10, 15, 23};
//        System.out.println(search(arr, 0, arr.length - 1, 99));
        System.out.println(search2(arr, 0, arr.length - 1, 10));
    }

    /**
     * 查找一个符合目标数的下标
     *
     * @param arr
     * @param left
     * @param right
     * @param target
     * @return
     */
    private static int search(int[] arr, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (arr[mid] > target) {
            return search(arr, left, mid - 1, target);
        } else if (arr[mid] < target) {
            return search(arr, mid + 1, right, target);
        } else {
            return mid;
        }
    }

    /**
     * 查找所有和target目标一样的
     *
     * @param arr
     * @param left
     * @param right
     * @param target
     * @return
     */
    private static List<Integer> search2(int[] arr, int left, int right, int target) {
        if (left > right) {
            return new ArrayList<>();
        }
        int mid = left + (right - left) / 2;
        if (arr[mid] > target) {
            return search2(arr, left, mid - 1, target);
        } else if (arr[mid] < target) {
            return search2(arr, mid + 1, right, target);
        } else {
            List<Integer> list = new ArrayList<>();
            int tmp = mid - 1;
            while (tmp > 0 && arr[tmp] == arr[mid]) {
                list.add(tmp--);
            }
            list.add(mid);
            tmp = mid + 1;
            while (tmp < arr.length && arr[tmp] == arr[mid]) {
                list.add(tmp++);
            }
            return list;
        }
    }
}
