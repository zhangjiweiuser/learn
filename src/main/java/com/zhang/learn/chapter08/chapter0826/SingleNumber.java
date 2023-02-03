package com.zhang.learn.chapter08.chapter0826;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/8/26 14:42
 */
public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 4, 4, 1};
        System.out.println(singleNumber(nums));
    }

    private static int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }
}
