package com.zhang.learn.chapter2023.chapter09.chapter0918;

import java.util.Arrays;

public class ChaiFen {
    public static void main(String[] args) {
        System.out.println(chai(10));
    }

    private static int chai(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(Math.max(j * (i - j), j * dp[i - j]), dp[i]);
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}
