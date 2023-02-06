package com.zhang.learn.chapter08.chapter0826;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/8/26 16:54
 */
public class FirstUniqChar {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("loveleetcode"));
    }

    private static int firstUniqChar(String s) {
        Map<String, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            map.put(String.valueOf(ch), map.getOrDefault(String.valueOf(ch), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(String.valueOf(s.charAt(i))) == 1) {
                return i;
            }
        }
        return -1;
    }
}
