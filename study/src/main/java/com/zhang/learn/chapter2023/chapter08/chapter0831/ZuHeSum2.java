package com.zhang.learn.chapter2023.chapter08.chapter0831;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-08-31 9:10
 */
public class ZuHeSum2 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 7};
        ZuHeSum2 zuhe = new ZuHeSum2();
        zuhe.backtracking(arr, 0, 7, 0);
        for (List<Integer> li : zuhe.result) {
            System.out.println(li);
        }
    }

    private void backtracking(int[] arr, int index, int target, int sum) {

        if (target == sum) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            sum += arr[i];
            if(sum > target){
                break;
            }
            path.add(arr[i]);
            backtracking(arr, i, target, sum);
            sum -= arr[i];
            path.removeLast();
        }
    }
}
