package com.zhang.learn.chapter2023.chapter08.chapter0828;

import java.util.Arrays;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-08-28 16:49
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3};
        int t = removeDuplicates(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int removeDuplicates(int[] nums) {
        int t = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                if (nums[i] == nums[i - 2]) {

                } else {
                    nums[t] = nums[i];
                    t++;
                }
            } else {
                nums[t] = nums[i];
                t++;
            }
        }
        return t;
    }
}
