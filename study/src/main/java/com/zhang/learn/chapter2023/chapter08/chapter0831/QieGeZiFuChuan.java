package com.zhang.learn.chapter2023.chapter08.chapter0831;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-08-31 11:00
 */
public class QieGeZiFuChuan {
    List<List<String>> result = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();

    public static void main(String[] args) {
        QieGeZiFuChuan qieGe = new QieGeZiFuChuan();
        qieGe.backtracking("aab", 0);
        for (List<String> li : qieGe.result) {
            System.out.println(li);
        }
    }

    public void backtracking(String s, int startIndex) {
        if (startIndex >= s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            // 如果是回文字串，则记录
            if (isPalindrome(s, startIndex, i)) {
                String str = s.substring(startIndex, i + 1);
                path.add(str);
            } else {
                continue;
            }
            backtracking(s, i + 1);
            path.removeLast();
        }
    }

    public boolean isPalindrome(String s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
