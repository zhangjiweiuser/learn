package com.zhang.learn.chapter2023.chapter03.chapter0317;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-03-17 11:07
 */
public class Kmp2 {
    public static void main(String[] args) {
        String s = "abcabcz";
        String m = "abcz";
        System.out.println(getIndex(s, m));
    }

    private static int getIndex(String s, String m) {
        if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
            return -1;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = m.toCharArray();
        int i1 = 0;
        int i2 = 0;
        int[] next = getNextArr(str2);
        while (i1 < s.length() && i2 < m.length()) {
            if (str1[i1] == str2[i2]) {
                i1++;
                i2++;
            } else if (next[i2] == -1) {
                i1++;
            } else {
                i2 = next[i2];
            }
        }
        return i2 == str2.length ? i1 - i2 : -1;
    }

    private static int[] getNextArr(char[] ms) {
        if (ms.length < 1) {
            return new int[]{-1};
        }
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int cn = 0;
        int i = 2;
        while (i < next.length) {
            if (ms[i-1] == ms[cn]) {
                next[i++] = ++cn;
            } else if (next[cn] != -1) {
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }
}
