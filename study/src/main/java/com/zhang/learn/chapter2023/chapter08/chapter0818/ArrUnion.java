package com.zhang.learn.chapter2023.chapter08.chapter0818;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-08-18 10:25
 */
public class ArrUnion {
    public static void main(String[] args) {
//        int[] a = {1, 2, 2, 1};
//        int[] b = {2, 2};
        int[] a = {4, 9, 5};
        int[] b = {9, 4, 9, 8, 4};

        System.out.println(Arrays.toString(arr(a, b)));
    }

    private static int[] arr(int[] a, int[] b) {
        // 定义 ans ，用于存放结果集
        HashSet<Integer> ans = new HashSet<>();
        // 用于存放a中的不重复原始
        HashSet<Integer> as = new HashSet<>();
        for (int t : a) {
            as.add(t);
        }
        for (int t : b) {
            if (as.contains(t)) {
                ans.add(t);
            }
        }
        int[] ar = new int[ans.size()];
        int t = 0;
        for (int i : ans) {
            ar[t++] = i;
        }
        return ar;
    }
}
