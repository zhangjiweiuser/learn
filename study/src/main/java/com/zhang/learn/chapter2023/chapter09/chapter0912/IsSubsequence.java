package com.zhang.learn.chapter2023.chapter09.chapter0912;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-09-12 16:13
 */
public class IsSubsequence {
    // 判断s是否是t的子序列
    public boolean isSubsequence(String s, String t) {
        int lens = s.length();
        int lent = t.length();
        int i = 0, j = 0;
        while (i < lens && j < lent) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == lens;
    }
}
