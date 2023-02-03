package com.zhang.learn.chapter2022.chapter03.chapter0314;

import java.util.*;

/**
 * @author zhangjiwei1
 * @description
 * @create 2022-03-14 9:43
 */
public class FindRestaurant {
    public static void main(String[] args) {
        FindRestaurant find = new FindRestaurant();
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};

        String[] list2 = {"KFC", "Shogun", "Burger King"};

        System.out.println(Arrays.toString(find.findRestaurant(list1, list2)));

    }

    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> result = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            if (null != map.get(list2[i])) {
                int m = i + map.get(list2[i]);
                if (m < min) {
                    result.clear();
                    result.add(list2[i]);
                    min = m;
                } else if (m == min) {
                    result.add(list2[i]);
                }
            }
        }
        return result.toArray(new String[0]);
    }
}
