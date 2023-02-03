package com.zhang.learn.chapter08.chapter0826;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/8/26 14:20
 */
public class DuplicationNum {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};

        System.out.println(hasDuplicationNum(nums));
    }

    private static boolean hasDuplicationNum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (null == map.get(num)) {
                map.put(num, num);
            } else {
                return true;
            }
        }
        return false;
    }
}
