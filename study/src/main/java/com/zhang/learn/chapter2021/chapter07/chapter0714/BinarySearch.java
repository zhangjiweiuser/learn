package com.zhang.learn.chapter2021.chapter07.chapter0714;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/7/14 17:41
 */
public class BinarySearch {
    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 2;
        System.out.println(binarySearch.search(nums, target));
    }

    public int search(int[] nums, int target) {
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int from = 0;
        int end = nums.length - 1;
        while (from <= end) {
            int mid = from + (end - from) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {

                end = mid - 1;
            } else {
                from = mid + 1;
            }
        }
        return -1;

    }

    public int search(int[] nums, int target, int from, int end) {
        if (from > end) {
            return -1;
        }
        int mid = from + (end - from) / 2;
        if (target == nums[mid]) {
            return mid;
        } else if (target < nums[mid]) {

            return search(nums, target, from, mid - 1);
        } else {
            return search(nums, target, mid + 1, end);
        }

    }
}
