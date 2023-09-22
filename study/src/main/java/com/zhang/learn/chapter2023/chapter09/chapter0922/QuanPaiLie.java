package com.zhang.learn.chapter2023.chapter09.chapter0922;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-09-22 14:20
 */
public class QuanPaiLie {
    static List<List<Integer>> result = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int[] used = new int[arr.length];
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
