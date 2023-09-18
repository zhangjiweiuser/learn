package com.zhang.learn.chapter2023.chapter09.chapter0918;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-09-18 14:14
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("acdbbdaa"));
    }

    public static String longestPalindrome(String s) {
        int strlen = s.length();
        int left = 0;
        int right = 0;
        int maxLen = 0;
        int maxStart = 0;
        int len = 1;
        for (int i = 0; i < strlen; i++) {
            left = i - 1;
            right = i + 1;
            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                left--;
                len++;
            }
            while (right < strlen && s.charAt(right) == s.charAt(i)) {
                right++;
                len++;
            }
            while (left >= 0 && right < strlen && s.charAt(left) == s.charAt(right)) {
                len += 2;
                left--;
                right++;
            }
            if (len > maxLen) {
                maxLen = len;
                maxStart = left;
            }
            len = 1;
        }
        return s.substring(maxStart + 1, maxStart + maxLen + 1);
    }
}
