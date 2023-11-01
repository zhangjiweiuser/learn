package com.zhang.learn.chapter2023.chapter10.chapter1031;

import java.util.Arrays;

/**
 * 递增子序列
 */
public class LengthOfLIS {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 2};
        System.out.println(lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);
        // 0, 1, 0, 3, 2

        // [1, 2, 1, 1, 1]
        // [1, 2, 1, 1, 1]
        // [1, 2, 1, 3, 1]
        // [1, 2, 1, 3, 3]
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }

            }
            System.out.println(Arrays.toString(dp));
            if (dp[i] > res) {
                res = dp[i];
            }
        }
        return res;
    }
}
