package com.zhang.learn.chapter2022.chapter02.chapter0216;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangjiwei1
 * @description
 * @create 2022-02-16 13:54
 */
public class CreateTargetArray {
    public static void main(String[] args) {
        CreateTargetArray create = new CreateTargetArray();
        int[] nums = {0, 1, 2, 3, 4};
        int[] index = {0, 1, 2, 2, 1};
        System.out.println(Arrays.toString(create.createTargetArray(nums, index)));
    }

    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            result.add(index[i], nums[i]);
        }
        return result.stream().mapToInt(t -> t).toArray();
    }
}
