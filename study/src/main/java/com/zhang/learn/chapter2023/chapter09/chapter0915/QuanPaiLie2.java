package com.zhang.learn.chapter2023.chapter09.chapter0915;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2]
 * 输出： [[1,1,2], [1,2,1], [2,1,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * @author zhangjiwei1
 * @description
 * @create 2023-09-15 10:14
 */
public class QuanPaiLie2 {
    static List<List<Integer>> result = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        int[] arr = {1, 1, 2};
        int[] used = new int[arr.length];
        Arrays.fill(used, 0);
        backtracking(arr, used);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

    private static void backtracking(int[] arr, int[] used) {
        if (path.size() == arr.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            // 树层去重
            if (i > 0 && arr[i] == arr[i - 1] && used[i - 1] == 0) {
                continue;
            }
            // 跳过已选择的元素，不再重复选取
            if (used[i] == 1) {
                continue;
            }
            path.add(arr[i]);
            used[i] = 1;
            backtracking(arr, used);
            path.removeLast();
            used[i] = 0;
        }
    }
}
