package com.zhang.learn.chapter2023.chapter09.chapter0915;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

        for (int i = startIndex; i <= 9 - k; i++) {
            path.add(i);
            sum += i;
            backtracking(k, target, sum, i + 1);
            path.removeLast();
            sum -= i;
        }
    }
}
