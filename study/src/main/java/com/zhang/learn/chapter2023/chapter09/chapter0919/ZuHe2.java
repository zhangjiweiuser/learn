package com.zhang.learn.chapter2023.chapter09.chapter0919;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-09-19 9:47
 */
public class ZuHe2 {
    static List<List<Integer>> result = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        backtracking(arr, 0, 9, 0, 3);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

    public static void backtracking(int[] arr, int startIndex, int targetNum, int sum, int k) {
        if (sum > targetNum) {
            return;
        }
        if (path.size() == k) {
            if (sum == targetNum) {
                result.add(new ArrayList<>(path));

            }
            return;
        }

        for (int i = startIndex; i < arr.length - (k - path.size()) + 1; i++) {
            path.add(arr[i]);
            sum += arr[i];
            backtracking(arr, i + 1, targetNum, sum, 3);
            path.removeLast();
            sum -= arr[i];
        }
    }
}
