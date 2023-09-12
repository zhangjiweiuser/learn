package com.zhang.learn.chapter2023.chapter08.chapter0831;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明： 所有数字（包括目标数）都是正整数。解集不能包含重复的组合
 *
 * @author zhangjiwei1
 * @description
 * @create 2023-08-31 9:10
 */
public class ZuHeSum3 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        int[] arr = {10, 1, 2, 7, 6, 1, 5};
        Arrays.sort(arr);
        ZuHeSum3 zuhe = new ZuHeSum3();
        boolean[] used = new boolean[arr.length];
        zuhe.backtracking(arr, 0, 8, 0, used);
        for (List<Integer> li : zuhe.result) {
            System.out.println(li);
        }
    }

    private void backtracking(int[] arr, int index, int target, int sum, boolean[] used) {

        if (target == sum) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            // 出现重复节点，同层的第一个节点已经被访问过，所以直接跳过
            if (i > 0 && arr[i] == arr[i - 1] && !used[i - 1]) {
                continue;
            }
            sum += arr[i];
            if (sum > target) {
                break;
            }
            path.add(arr[i]);
            used[i] = true;
            backtracking(arr, i + 1, target, sum, used);
            sum -= arr[i];
            used[i] = false;
            path.removeLast();
        }
    }
}
