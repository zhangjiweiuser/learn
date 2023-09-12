package com.zhang.learn.chapter2023.chapter09.chapter0912;

import java.util.Arrays;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-09-12 16:29
 */
public class GenerateMatrix {
    public static void main(String[] args) {
        GenerateMatrix matrix = new GenerateMatrix();
        int[][] arr = matrix.generateMatrix(5);
        for (int[] a : arr) {
            System.out.println(Arrays.toString(a));
        }
    }

    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int count = n * n;
        int num = 1;
        int l = 0, r = n - 1, t = 0, b = n - 1;
        while (num <= count) {
            for (int i = l; i <= r; i++) {
                arr[t][i] = num++;
            }
            t++;
            for (int i = t; i <= b; i++) {
                arr[i][r] = num++;
            }
            r--;
            for (int i = r; i >= l; i--) {
                arr[b][i] = num++;
            }
            b--;
            for (int i = b; i >= t; i--) {
                arr[i][l] = num++;
            }
            l++;
        }
        return arr;
    }
}
