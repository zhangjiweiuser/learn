package com.zhang.learn.chapter2023.chapter09.chapter0915;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * 说明：
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1: 输入: k = 3, n = 7 输出: [[1,2,4]]
 * <p>
 * 示例 2: 输入: k = 3, n = 9 输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class QiuHe {
    static List<List<Integer>> result = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        int[] arr = {4, 6, 7, 7};
        backtracking(3, 9, 0, 1);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

    private static void backtracking(int k, int target, int sum, int startIndex) {
        if (sum > target) {
            return;
        }
        if (path.size() == k) {
            if (target == sum) {
                result.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            path.add(i);
            sum += i;
            backtracking(k, target, sum, i + 1);
            path.removeLast();
            sum -= i;
        }
    }
}
