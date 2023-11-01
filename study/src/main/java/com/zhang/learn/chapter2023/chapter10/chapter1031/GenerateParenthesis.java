package com.zhang.learn.chapter2023.chapter10.chapter1031;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static void main(String[] args) {
        List<String> result = generateParenthesis(3);
        System.out.println(result);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis(n, result, 0, 0, "");
        return result;
    }

    public static void generateParenthesis(int n, List<String> result, int left, int right, String str) {
        if (right > left) {
            return;
        }
        if (left == n && right == n) {
            result.add(str);
            return;
        }
        if (left < n) {
            generateParenthesis(n, result, left + 1, right, str + "(");
        }
        if (right < n) {
            generateParenthesis(n, result, left, right + 1, str + ")");
        }
    }
}
