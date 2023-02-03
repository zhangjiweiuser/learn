package com.zhang.learn.chapter2022.chapter03.chapter0314;

/**
 * @author zhangjiwei1
 * @description
 * @create 2022-03-14 13:54
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 8, 9, 12, 13};
        BinarySearch search = new BinarySearch();
        System.out.println(search.search(nums, 9));
    }

    public int search(int[] nums, int target) {
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
