package com.zhang.learn.chapter2023.chapter08.chapter0830;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-08-30 18:09
 */
public class ZuHe {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        ZuHe zuHe = new ZuHe();
        zuHe.backtracking(4, 2, 1);
        for (List<Integer> li : zuHe.result) {
            System.out.println(li);
        }
    }

    public void backtracking(int n, int k, int startIndex) {
        System.out.println(path + "-->" + n + "-->" + k + "-->" + startIndex);
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            path.add(i);

            backtracking(n, k, i + 1);
            path.removeLast();
        }
    }

    public void backtracking2(int n, int k, int startIndex) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backtracking2(n, k, i + 1);
            path.removeLast();
        }
    }
}
