package com.zhang.learn.chapter2023.chapter08.chapter0818;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-08-18 11:13
 */
public class ShuJinXin {
    public static void main(String[] args) {
        System.out.println(shuJinXin("a","b"));
        System.out.println(shuJinXin("aa","ab"));
        System.out.println(shuJinXin("aa","aab"));
    }

    private static boolean shuJinXin(String a, String b) {
        if (b == null || b.length() < a.length()) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < b.length(); i++) {
            map.put(b.charAt(i) - 'a', map.getOrDefault(b.charAt(i) - 'a', 0) + 1);
        }
        for (int i = 0; i < a.length(); i++) {
            Integer count = map.get(a.charAt(i) - 'a');
            if (count == null || count == 0) {
                return false;
            } else {
                map.put(a.charAt(i) - 'a', count - 1);
            }
        }
        return true;
    }
}
