package com.zhang.learn.chapter2023.chapter09.chapter0922;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-09-22 17:16
 */
public class BeiBao01 {
    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagSize = 4;
        System.out.println(beibao01(weight, value, bagSize));
    }

    private static int beibao01(int[] weight, int[] value, int bagSize) {
        int goods = weight.length;// 物品个数
        int[][] dp = new int[goods][bagSize + 1];
        for (int j = weight[0]; j <= bagSize; j++) {
            dp[0][j] = value[0];
        }

        for (int i = 1; i < weight.length; i++) {
            for (int j = 1; j <= bagSize; j++) {
                if (j < weight[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
        return dp[goods - 1][bagSize];
    }
}
