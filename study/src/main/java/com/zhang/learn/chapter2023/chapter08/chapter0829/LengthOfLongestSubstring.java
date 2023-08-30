package com.zhang.learn.chapter2023.chapter08.chapter0829;

import java.util.HashMap;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-08-29 12:19
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcda"));
    }

    private static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
