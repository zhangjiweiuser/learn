package com.zhang.learn.chapter2021.chapter11.chapter11;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/11/11 10:20
 */
public class ContainsNearbyDuplicate {
    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] == nums[j] && i + k >= j) {
                    return true;
                }
                if (i + k == j) {
                    break;
                }
            }
        }
        return false;
    }
}
