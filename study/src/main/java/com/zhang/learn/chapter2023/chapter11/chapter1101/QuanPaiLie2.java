package com.zhang.learn.chapter2023.chapter11.chapter1101;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 示例 1：
 * 输入：nums = [1,1,2]
 * 输出： [[1,1,2], [1,2,1], [2,1,1]]
 * 示例 2：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class QuanPaiLie2 {
    static List<List<Integer>> result = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        boolean[] used = new boolean[nums.length];
        backstacking(nums, used);

        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

    private static void backstacking(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // used[i - 1] == true，说明同一树枝used[i - 1] 使用过
            // used[i - 1] == false，说明同一树层used[i - 1] 使用过
            // 这里写 used[i - 1] 和 !used[i - 1] 都是可以的
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                backstacking(nums, used);
                path.removeLast();
                used[i] = false;
            }
        }
    }
}
