package com.zhang.learn.chapter2023.chapter09.chapter0915;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 说明： 所有数字（包括目标数）都是正整数。解集不能包含重复的组合。
 * 示例 1:
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 *
 * @author zhangjiwei1
 * @description
 * @create 2023-09-15 9:54
 */
public class QiuHe2 {
    static List<List<Integer>> result = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 5, 6, 7, 10};
        int[] used = new int[arr.length];
        Arrays.fill(used, 0);
        backtracking(arr, 8, 0, 0, used);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

    private static void backtracking(int[] arr, int targetSum, int sum, int startIndex, int[] used) {
        if (targetSum == sum) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (targetSum < sum) {
            return;
        }
        for (int i = startIndex; i < arr.length; i++) {
            if (i > 0 && arr[i] == arr[i - 1] && used[i - 1] == 0) {
                continue;
            }
            sum += arr[i];
            path.add(arr[i]);
            used[i] = 1;
            backtracking(arr, targetSum, sum, i + 1, used);
            path.removeLast();
            sum -= arr[i];
            used[i] = 0;
        }
    }
}
