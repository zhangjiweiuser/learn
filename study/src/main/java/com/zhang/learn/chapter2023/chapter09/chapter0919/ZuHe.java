package com.zhang.learn.chapter2023.chapter09.chapter0919;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-09-19 9:47
 */
public class ZuHe {
    static List<List<Integer>> result = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        backtracking(arr, 0, 2);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

    public static void backtracking(int[] arr, int startIndex, int targetNum) {
        if (path.size() == targetNum) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < arr.length - (targetNum - path.size()) + 1; i++) {
            path.add(arr[i]);
            backtracking(arr, i + 1, targetNum);
            path.removeLast();
        }
    }
}
