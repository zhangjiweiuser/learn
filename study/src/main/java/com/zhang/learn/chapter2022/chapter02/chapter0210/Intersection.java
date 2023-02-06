package com.zhang.learn.chapter2022.chapter02.chapter0210;

import java.util.*;

/**
 * @author zhangjiwei1
 * @description
 * @create 2022-02-10 15:25
 */
public class Intersection {
    public static void main(String[] args) {
        Intersection intersection = new Intersection();
        int[] nums1 = {1,2,3,3,4};
        int[] nums2 = {3,3,4};
        System.out.println(Arrays.toString(intersection.intersection(nums1,nums2)));
    }
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int n : nums1) {
            map1.put(n, n);
        }
        List<Integer> result = new ArrayList<>();
        for (int n : nums2) {
            if (map1.get(n) != null && !result.contains(n)) {
                result.add(n);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
