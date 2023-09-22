package com.zhang.learn.chapter2023.chapter09.chapter0919;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-09-19 10:23
 */
public class MinCapability {
    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 9};
        System.out.println(minCapability(nums,2));
    }

    public static int minCapability(int[] nums, int k) {
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 2; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                max = Math.min(max,sum);
            }
        }
        return max;
    }
}
