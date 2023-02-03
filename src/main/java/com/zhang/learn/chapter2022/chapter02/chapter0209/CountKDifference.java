package com.zhang.learn.chapter2022.chapter02.chapter0209;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangjiwei1
 * @description
 * @create 2022-02-09 13:59
 */
public class CountKDifference {
    public static void main(String[] args) {
        CountKDifference difference = new CountKDifference();

    }

    public int countKDifference(int[] nums, int k) {
        int n = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    n++;
                }
            }
        }
        return n;
    }

    /**
     * 创建一个哈希表 count，keykey 表示 nums_j, valuevalue 表示 nums_j出现的次数。
     * 对于 nums_j，我们需要找到，满足 i < j 且 |nums[i] - nums[j]| == k 。
     * |nums[i] - nums[j]| == k 等价于 nums[i] = nums[j] + k，或者 nums[i] = nums[j] - k。
     * 因此，从左到右遍历数组，对于 nums_j，统计前面 i < j，哈希表中 nums[j] + k 和nums[j] - k的次数。
     * 然后将 nums_j插入到哈希表中。
     */
    public int countKDifference2(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        int ans = 0;
        for (int j = 0; j < nums.length; j++) {
            ans += count.getOrDefault(k + nums[j], 0);
            ans += count.getOrDefault(nums[j] - k, 0);
            count.put(nums[j], count.getOrDefault(nums[j], 0) + 1);
        }
        return ans;

    }
}
