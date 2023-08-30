package com.zhang.learn.chapter2023.chapter08.chapter0830;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-08-30 18:09
 */
public class ZuHeSum {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        ZuHeSum zuHe = new ZuHeSum();
        zuHe.backtracking(9, 3, 1,0);
        for (List<Integer> li : zuHe.result) {
            System.out.println(li);
        }
    }


    public void backtracking(int targetSum, int k, int startIndex, int sum) {
        if (sum > targetSum) {
            return;
        }
        if (path.size() == k) {
            if (sum == targetSum) {
                result.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            path.add(i);
            sum += i;
            backtracking(targetSum, k, i + 1, sum);
            path.removeLast();
            sum -= i;
        }
    }
}
