package com.zhang.learn.chapter2023.chapter09.chapter0915;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-09-15 14:01
 */
public class ZuHeSum {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        ZuHeSum zuHeSum = new ZuHeSum();
        zuHeSum.combinationSum(candidates, 7);
        for (List<Integer> list : zuHeSum.result) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backstacking(candidates, target, 0,0);
        return result;
    }

    public void backstacking(int[] candidates, int target, int sum,int startIndex) {
        if (target == sum) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (target < sum) {
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            path.add(candidates[i]);
            sum += candidates[i];
            backstacking(candidates, target, sum,i);
            sum -= candidates[i];
            path.removeLast();
        }
    }
}
