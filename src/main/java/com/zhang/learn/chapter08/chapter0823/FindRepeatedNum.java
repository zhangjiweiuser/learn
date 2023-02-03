package com.zhang.learn.chapter08.chapter0823;

/**
 * @author zhangjiwei
 * @Description 寻找重复的数
 * @Date 2021/8/23 14:54
 */
public class FindRepeatedNum {

    public static void main(String[] args) {
        int[] nums = {9, 2, 2, 5, 6, 4, 8, 7, 1, 3};
        System.out.println(findRepeatedNum(nums));
    }

    private static int findRepeatedNum(int[] nums) {
        int len = nums.length;
        int start = 1;
        int end = len - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            int counter = 0;
            for (int num : nums) {
                if (num <= mid) {
                    counter++;
                }
            }
            if (counter > mid) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
