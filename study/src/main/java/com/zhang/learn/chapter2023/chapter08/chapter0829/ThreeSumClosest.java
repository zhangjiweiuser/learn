package com.zhang.learn.chapter2023.chapter08.chapter0829;

import java.util.Arrays;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-08-29 14:32
 */
public class ThreeSumClosest {
    public static void main(String[] args) {

    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
                if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }
}
