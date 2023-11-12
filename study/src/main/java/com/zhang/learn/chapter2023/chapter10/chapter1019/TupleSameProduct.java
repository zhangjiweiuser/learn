package com.zhang.learn.chapter2023.chapter10.chapter1019;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TupleSameProduct {
    public static int tupleSameProduct(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int a = nums[i] * nums[j];
                if (map.containsKey(a)) {
                    ans += map.get(a) * 8;
                    map.put(a, map.get(a) + 1);
                } else {
                    map.put(a, 1);
                }
            }
        }
        return ans;
    }
}
