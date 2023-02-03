package com.zhang.learn.chapter08.chapter0827;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/8/27 13:57
 */
public class IsAnagram {

    public static void main(String[] args) {
        System.out.println(isAnagram("rar", "car"));
        System.out.println(isAnagram("abcd", "bdca"));
    }

    private static boolean isAnagram(String s, String t) {
        Map<String, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            map.put(String.valueOf(ch), map.getOrDefault(String.valueOf(ch), 0) + 1);
        }
        char[] chars2 = t.toCharArray();
        for (char ch : chars2) {
            if (map.get(String.valueOf(ch)) == null) {
                return false;
            }
            int num = map.get(String.valueOf(ch));
            if (num == 1) {
                map.remove(String.valueOf(ch));
            } else {
                map.put(String.valueOf(ch), num - 1);
            }
        }
        return map.size() <= 0;
    }
}
