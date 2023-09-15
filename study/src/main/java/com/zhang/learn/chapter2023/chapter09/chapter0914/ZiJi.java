package com.zhang.learn.chapter2023.chapter09.chapter0914;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ZiJi {
    public static void main(String[] args) {
        ZiJi ziJi = new ZiJi();
        int[] arr = {1, 2, 3};
        ziJi.subList(arr, 0);
        for (List<Integer> list : ziJi.result) {
            System.out.println(list);
        }
    }

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    private void subList(int[] nums, int startIndex) {
        result.add(new ArrayList<>(path));
        if (startIndex >= nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            subList(nums, i + 1);
            path.removeLast();
        }
    }
}
