package com.zhang.learn.chapter2022.chapter03.chapter0314;

/**
 * @author zhangjiwei1
 * @description
 * @create 2022-03-14 16:04
 */
public class MinSubArrayLen {
    public static void main(String[] args) {
        int s = 7;
        int[] nums = {2, 3, 1, 2, 4, 3,7};
        MinSubArrayLen minSubArrayLen = new MinSubArrayLen();
        System.out.println(minSubArrayLen.minSubArrayLen(nums, s));
    }

    public int minSubArrayLen(int[] nums, int target) {
        int left = 0, sum = 0, result = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
