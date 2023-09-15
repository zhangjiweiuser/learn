package com.zhang.learn.chapter2023.chapter09.chapter0914;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * 示例:
 * 输入: [1,2,2]
 * 输出: [ [2], [1], [1,2,2], [2,2], [1,2], [] ]
 */
public class ZiJi2 {
    static List<List<Integer>> result = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        int[] arr = {1, 2, 2};
        int[] used = new int[3];
        Arrays.fill(used, 0);
        backtracking(arr, 0, used);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

    private static void backtracking(int[] arr, int startIndex, int[] used) {
        result.add(new ArrayList<>(path));
        for (int i = startIndex; i < arr.length; i++) {
            if (i > 0 && arr[i] == arr[i - 1] && used[i - 1] == 0) {
                continue;
            }
            path.add(arr[i]);
            used[i] = 1;
            backtracking(arr, i + 1, used);
            path.removeLast();
            used[i] = 0;
        }
    }
}
