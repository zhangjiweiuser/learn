package com.zhang.learn.chapter2023.chapter09.chapter0927;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MumPairsDivisibleBy60 {
    public static void main(String[] args) {
        int[] nums = {30, 20, 150, 100, 40};
        System.out.println(numPairsDivisibleBy60(nums));
        int[] nums2 = {60, 60, 60};
        System.out.println(numPairsDivisibleBy60(nums2));
    }

    public static int numPairsDivisibleBy60(int[] time) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < time.length; i++) {
            int t = time[i];
            List<Integer> list = map.getOrDefault(t, new ArrayList<>());
            list.add(i);
            map.put(t, list);
        }
        int res = 0;
        for (int i = 0; i < time.length; i++) {
            int t = time[i];
            int start = 60 - (t % 60);
            for (int j = start; j <= 1000; j += 60) {
                if (map.get(j) != null) {
                    List<Integer> list = map.get(j);
                    for (int k : list) {
                        if (k > i) {
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }

    public static int numPairsDivisibleBy602(int[] time) {
        int[] second = new int[60];
        int res = 0;
        for (int t : time) {
            int i = 60 - t % 60;
            res += second[i == 60 ? 0 : i];
            second[t % 60] += 1;
        }
        return res;
    }
}
