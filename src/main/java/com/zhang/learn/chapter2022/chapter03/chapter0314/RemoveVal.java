package com.zhang.learn.chapter2022.chapter03.chapter0314;

import java.util.Arrays;

/**
 * @author zhangjiwei1
 * @description
 * @create 2022-03-14 14:02
 */
public class RemoveVal {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        RemoveVal remove = new RemoveVal();
        int index = remove.remove2(nums, val);
        System.out.println(index + 1);
        for (int i = 0; i <= index; i++) {
            System.out.println(nums[i]);
        }
        System.out.println(Arrays.toString(nums));
    }

    public int remove(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] == target) {
                while (left < right) {
                    if (nums[right] == target) {
                        right--;
                    } else {
                        int tmp = nums[left];
                        nums[left] = nums[right];
                        nums[right] = tmp;
                        left++;
                        right--;
                    }
                }
            } else {
                left++;
            }
        }
        return left;
    }

    /**
     * 通过快慢指针
     *
     * @param nums
     * @param target
     * @return
     */
    public int remove2(int[] nums, int target) {
        int fastIndex = 0;
        int slowIndex;
        for (slowIndex = 0; fastIndex < nums.length; fastIndex++) {
            if(nums[fastIndex] != target){
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }
}
