package com.zhang.learn.chapter2022.chapter12.chapter1227;

/**
 * @author zhangjiwei1
 * @description 一个有序数组啊让人，原地删除重复出现的元素，使每个元素只出现一次，返回删除后数组的新长度
 * @create 2022-12-27 14:12
 */
public class DelSortArr {
    public static void main(String[] args) {
        int[] arr = {0, 0, 0, 0, 1, 1, 1, 2, 2, 3, 3};
        int t = del(arr);
        System.out.println(t);
        for (int i = 0; i <= t; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static int del(int[] arr) {
        int j = 0;
        int t = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != t) {
                t = arr[i];
                arr[++j] = t;
            }
        }
        return j;
    }
}
