package com.zhang.learn.chapter2023.chapter11.chapter1101;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1：
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为： [ [7], [2,2,3] ]
 * 示例 2：
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为： [ [2,2,2,2], [2,3,3], [3,5] ]
 */
public class ZuHeZongHe {
    static List<List<Integer>> result = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        int[] nums = {2, 3, 5};
        Arrays.sort(nums);
        backstacking(nums, 8, 0, 0);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

    private static void backstacking(int[] nums, int target, int sum, int index) {
        if (target == sum) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (sum + nums[i] > target) {
                break;
            }
            path.add(nums[i]);
            backstacking(nums, target, sum + nums[i], i);
            path.removeLast();
        }
    }
}
