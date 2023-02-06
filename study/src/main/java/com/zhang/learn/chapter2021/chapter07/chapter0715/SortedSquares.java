package com.zhang.learn.chapter2021.chapter07.chapter0715;

import java.util.Arrays;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/7/15 10:32
 */
public class SortedSquares {
    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        SortedSquares sort = new SortedSquares();
        System.out.println(Arrays.toString(sort.sortedSquares(nums)));
    }

    public int[] sortedSquares(int[] nums) {
        for(int i=0;i<nums.length;i++){
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}
