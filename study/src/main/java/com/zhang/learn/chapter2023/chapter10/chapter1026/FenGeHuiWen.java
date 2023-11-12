package com.zhang.learn.chapter2023.chapter10.chapter1026;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * 返回 s 所有可能的分割方案。
 * 示例: 输入: "aab" 输出: [ ["aa","b"], ["a","a","b"] ]
 * #算法公开课
 */
public class FenGeHuiWen {
    static List<List<String>> lists = new ArrayList<>();
    static Deque<String> deque = new LinkedList<>();

    public static void main(String[] args) {
        List<List<String>> result = paration("aab");
        for (List<String> list : result) {
            System.out.println(list);
        }
    }

    public static List<List<String>> paration(String s) {
        backtracking(s, 0);
        return lists;
    }

    public static void backtracking(String s, int startIndex) {
        // 如果起始位置大于s的大小，说明找到了一组分割方案
        if (startIndex >= s.length()) {
            lists.add(new ArrayList<>(deque));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (isPalindrome(s, startIndex, i)) {
                String str = s.substring(startIndex, i + 1);
                deque.addLast(str);
            } else {
                continue;
            }
            backtracking(s, i + 1);
            deque.removeLast();
        }
    }

    private static boolean isPalindrome(String s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
