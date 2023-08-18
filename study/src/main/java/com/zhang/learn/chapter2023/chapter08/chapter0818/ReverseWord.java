package com.zhang.learn.chapter2023.chapter08.chapter0818;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-08-18 16:28
 */
public class ReverseWord {
    public static void main(String[] args) {
        System.out.println(reverse2("   sdff aa    bb cc    "));
    }

    private static String reverse(String str) {
        String[] split = str.trim().split("\\s+");
        StringBuffer sb = new StringBuffer();
        for (int i = split.length - 1; i >= 0; i--) {
            sb.append(split[i]);
            if (i != 0) {
                sb.append(" ");

            }
        }
        return sb.toString();
    }

    private static String reverse2(String str) {
        String[] split = str.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = split.length - 1; i >= 0; i--) {
            if (!" ".equals(split[i]) && split[i].length() != 0) {
                sb.append(split[i]).append(" ");
            }
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }
}
