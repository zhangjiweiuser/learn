package com.zhang.learn.chapter2023.chapter10.chapter1031;

public class HuiWenChuan {
    public static void main(String[] args) {
        System.out.println(countSubstrings("aa"));
        System.out.println(countSubstrings("a"));
        System.out.println(countSubstrings("taabaaq"));
    }

    public static String longestPalindrome2(String s) {
        if (s == null || s.equals("")) {
            return s;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        int[] result = new int[2];
        for (int i = 0; i < s.length(); i++) dp[i][i] = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i == 1) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }
                if (dp[i][j]) {
                    if (result[1] - result[0] <= j - i) {
                        result[0] = i;
                        result[1] = j;
                    }
                }
            }
        }
        return s.substring(result[0], result[1] + 1);

    }

    public static int countSubstrings(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        boolean[][] dp = new boolean[len][len];
        int result = 1;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (chars[i] == chars[j]) {
                    if (j - i <= 1) { // 情况一 和 情况二
                        result = Math.max(result, j - i + 1);
                        dp[i][j] = true;
                    } else if (dp[i + 1][j - 1]) { //情况三
                        result = Math.max(result, j - i + 1);
                        dp[i][j] = true;
                    }
                }
            }
        }
        return result;
    }
}
