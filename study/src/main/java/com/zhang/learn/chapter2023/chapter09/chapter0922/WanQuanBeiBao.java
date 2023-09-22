package com.zhang.learn.chapter2023.chapter09.chapter0922;

import java.util.Arrays;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-09-22 10:01
 */
public class WanQuanBeiBao {
    public static void main(String[] args) {
        int[] v = {0,1, 2, 3, 4};
        int[] w = {0,2, 4, 4, 5};
        System.out.println(beibao01(v, w, 5));
        System.out.println(beibaowanquan(v, w, 5));
    }

    // v为体积，w为价值，背包总体积为m
    private static int beibaowanquan(int[] v, int[] w, int m) {
        int n = v.length; //
        int[][] dp = new int[n][m + 1];
        for (int i = 1; i < n; i++) { // 物品
            for (int j = 1; j <= m; j++) { // 背包
                if (j >= v[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - v[i]] + w[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        for(int[] d : dp){
            System.out.println(Arrays.toString(d));
        }
        return dp[n-1][m];
    }

    private static int beibao01(int[] v, int[] w, int m) {
        int n = v.length; //
        int[][] dp = new int[n][m+1];
        for (int i = 1; i < n; i++) { // 物品
            for (int j = 1; j <= m; j++) { // 背包
                if (j >= v[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - v[i]] + w[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        for(int[] d : dp){
            System.out.println(Arrays.toString(d));
        }
        return dp[n-1][m];
    }
}
