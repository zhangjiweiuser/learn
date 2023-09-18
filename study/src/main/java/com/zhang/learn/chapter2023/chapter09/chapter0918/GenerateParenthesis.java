package com.zhang.learn.chapter2023.chapter09.chapter0918;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-09-18 16:08
 */
public class GenerateParenthesis {
    static List<String> res = new ArrayList<>();

    public static void main(String[] args) {
        List<String> ans = generateParenthesis(3);
        for(String s : ans){
            System.out.println(s);
        }
    }

    public static List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return res;
        }
        getParenthesis("", n, n);
        return res;
    }

    private static void getParenthesis(String str, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(str);
            return;
        }
        if (left == right) {
            // 剩余的左右括号相等，下一个只能用左括号
            getParenthesis(str + "(", left - 1, right);
        } else if (left < right) {
            // 剩余左括号小于又括号，下一个可以用左括号也可以用右括号
            if (left > 0) {
                getParenthesis(str + "(", left - 1, right);
            }
            getParenthesis(str + ")", left, right - 1);
        }
    }
}
