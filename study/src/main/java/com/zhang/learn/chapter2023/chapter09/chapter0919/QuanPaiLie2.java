package com.zhang.learn.chapter2023.chapter09.chapter0919;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-09-19 9:34
 */
public class QuanPaiLie2 {
    static List<List<Integer>> result = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        int[] arr = {1, 2,3};
        int[] used = new int[arr.length];
        backtracking(arr, used);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

    public static void backtracking(int[] nums, int[] used) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == 0) {
                continue;
            }
            if (used[i] == 1) {
                continue;
            }
            path.add(nums[i]);
            used[i] = 1;
            backtracking(nums, used);
            path.removeLast();
            used[i] = 0;
        }
    }
}
