package com.zhang.learn.chapter2023.chapter08.chapter0816;

import java.util.Arrays;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-08-16 15:56
 */
public class BeiBao01 {
    public static void main(String[] args) {
        // 物品的重量
        int[] w = {1, 4, 3};
        // 物品的价值
        int[] v = {1500, 3000, 2000};
        int m = 4;// 背包的容量
        int n = v.length;// 物品的个数
        // r[i][j] 表示，在前i个物品中国能够装入容量为j的背包中的最大价值
        int[][] r = new int[n + 1][m + 1];
        // 初始化第一行和第一列，这里可以不用设置，因为默认都是0
        for (int i = 0; i <= w.length; i++) {
            r[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            r[0][i] = 0;
        }
        for (int[] a : r) {
            System.out.println(Arrays.toString(a));
        }
        System.out.println("=============");
        for (int i = 1; i < r.length; i++) {
            for (int j = 1; j < r[0].length; j++) {
                // 公式
                if (w[i - 1] > j) {
                    r[i][j] = r[i - 1][j];
                } else {
                    r[i][j] = Math.max(r[i - 1][j], v[i - 1] + r[i - 1][j - w[i - 1]]);
                }
            }
        }
        for (int[] a : r) {
            System.out.println(Arrays.toString(a));
        }

    }

}
