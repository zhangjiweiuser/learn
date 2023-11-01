package com.zhang.learn.chapter2023.chapter10.chapter1031;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * 示例:
 * 输入: [1,2,3]
 * 输出: [ [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1] ]
 */
public class QuanPaiLie {
    static List<List<Integer>> result = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        boolean[] used = new boolean[nums.length];
        backstacking(nums,used);

        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

    private static void backstacking(int[] nums,boolean[] used) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(used[i]){
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backstacking(nums,used);
            path.removeLast();
            used[i] = false;
        }
    }
}
