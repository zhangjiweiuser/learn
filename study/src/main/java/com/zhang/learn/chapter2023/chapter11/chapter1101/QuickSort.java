package com.zhang.learn.chapter2023.chapter11.chapter1101;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {6, 8, 5, 1, 4, 9};
        sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private static void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int l = left, r = right, pivot = nums[left];
        while (l < r) {
            while (l < r && nums[r] >= pivot) {
                r--;
            }
            while (l < r && nums[l] <= pivot) {
                l++;
            }
            if (l != r) {
                int t = nums[l];
                nums[l] = nums[r];
                nums[r] = t;
            }
        }
        nums[left] = nums[l];
        nums[l] = pivot;
        sort(nums, left, l - 1);
        sort(nums, l + 1, right);
    }
}
