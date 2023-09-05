package com.zhang.learn.chapter2023.chapter09.chapter0904;

import java.util.ArrayList;
import java.util.List;

public class ZiJi {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        ZiJi ziJi = new ZiJi();
        ziJi.backtracking(arr,0);
        for(List<Integer> li : ziJi.result){
            System.out.println(li);
        }
    }

    public void backtracking(int[] nums, int startIndex) {
        if (startIndex == nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            result.add(new ArrayList<>(path));
            backtracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
