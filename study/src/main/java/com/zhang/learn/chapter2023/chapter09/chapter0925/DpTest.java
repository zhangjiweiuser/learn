package com.zhang.learn.chapter2023.chapter09.chapter0925;

import java.util.Arrays;

public class DpTest {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 2};
        System.out.println(lengthOfLts(nums));
    }

    private static int lengthOfLts(int[] nums) {
        int[] dp = new int[nums.length];
        int res = 1;
        Arrays.fill(dp, 1);
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                res = Math.max(res, dp[j]);
            }
        }
        return res;
    }
}
