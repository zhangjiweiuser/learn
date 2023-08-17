package com.zhang.learn.chapter2023.chapter08.chapter0817;

import java.util.Arrays;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-08-17 14:22
 */
public class LuoXuanJuZhen {
    public static void main(String[] args) {
        int[][] arr = juZhen(5);
        for (int[] a : arr) {
            System.out.println(Arrays.toString(a));
        }
    }

    private static int[][] juZhen(int n) {

        // 1. 声明变量t，代表个数
        int t = 1;
        int loop = 0; // 控制循环次数
        int[][] arr = new int[n][n];
        int start = 0;// 每次循环起始点，start,start
        int i, j;
        while (loop++ < n / 2) {
            // 模拟从上侧 从左到右
            for (j = start; j < n - loop; j++) {
                arr[start][j] = t++;
            }
            // 模拟右侧从上到下
            for (i = start; i < n - loop; i++) {
                arr[i][j] = t++;
            }
            // 模拟下侧 从右向左
            for (; j >= loop; j--) {
                arr[i][j] = t++;
            }
            // 模拟左侧 从下到上
            for (; i >= loop; i--) {
                arr[i][j] = t++;
            }
            start++;
        }
        if (n % 2 == 1) {
            arr[start][start] = t;
        }
        return arr;
    }
}
