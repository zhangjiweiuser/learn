package com.zhang.learn.chapter2023.chapter09.chapter0918;

import java.util.Arrays;

/**
 * 有n件物品和一个最多能背重量为w 的背包。
 * 第i件物品的重量是weight[i]，
 * 得到的价值是value[i] 。每件物品只能用一次，求解将哪些物品装入背包里物品价值总和最大。
 */
public class BeiBao01 {
    public static void main(String[] args) {
        int[] w = {1, 3, 4};
        int[] v = {15, 20, 30};
        System.out.println(bao(w, v, 4));
    }

    public static int bao(int[] w, int[] v, int t) {
        int wl = w.length;
        int vl = v.length;
        // dp[i][j] 代表有i个物品可选，在背包容量为j的情况下，最多可以装多少
        int[][] dp = new int[wl][t + 1];
        for (int i = w[0]; i <= t; i++) {
            dp[0][i] = v[0];
        }
        for (int i = 1; i < wl; i++) {
            for (int j = 1; j <= t; j++) {
                if (j < w[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
                }
            }
        }
        for (int[] d : dp) {
            System.out.println(Arrays.toString(d));
        }
        return dp[wl-1][t];
    }
}
