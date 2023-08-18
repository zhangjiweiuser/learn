package com.zhang.learn.chapter2023.chapter08.chapter0818;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-08-18 10:16
 */
public class YiWeiCi {
    public static void main(String[] args) {
        System.out.println(yiwei("abc", "cba"));
        System.out.println(yiwei("adbc", "cbaa"));
    }

    private static boolean yiwei(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer count = map.getOrDefault(s.charAt(i) - 'a', 0);
            map.put(s.charAt(i) - 'a', count + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            if (map.getOrDefault(t.charAt(i) - 'a', 0) == 0) {
                return false;
            }
            map.put(t.charAt(i) - 'a', map.get(t.charAt(i) - 'a') - 1);
        }
        return true;
    }
}
