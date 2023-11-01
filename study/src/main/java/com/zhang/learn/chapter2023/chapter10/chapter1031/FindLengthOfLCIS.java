package com.zhang.learn.chapter2023.chapter10.chapter1031;

import java.util.Arrays;

/**
 * 连续递增子序列
 */
public class FindLengthOfLCIS {
    public static void main(String[] args) {
        int[] nums = {1,3,5,4,7};
        System.out.println(findLengthOfLCIS(nums));
    }
    /**
     * 1. dp[i] 代表当前下标最大连续值
     * 2. 递推公式 if(nums[i+1] > nums[i]) dp[i+1] = dp[i] + 1
     * 3. 初始化都为1
     * 4. 遍历方向，从其那往后
     * 5. 结果推导
     *
     * @param nums
     * @return
     */
    public static int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                dp[i + 1] = dp[i] + 1;
            }
            res = Math.max(res, dp[i + 1]);
        }
        return res;
    }
}
