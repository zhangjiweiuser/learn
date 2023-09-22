package com.zhang.learn.chapter2023.chapter09.chapter0919;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-09-19 16:24
 */
public class KuoHao {
    static List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        gener("", 3, 3);
        for (String s : result) {
            System.out.println(s);
        }
    }

    private static void gener(String str, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(str);
            return;
        }
        if (left == right) {
            // 剩余的左右括号相等，下一个只能用左括号
            gener(str + "(", left - 1, right);
        } else if (left < right) {
            // 剩余左括号小于又括号，下一个可以用左括号也可以用右括号
            if (left > 0) {
                gener(str + "(", left - 1, right);
            }
            gener(str + ")", left, right - 1);
        }
    }
}
