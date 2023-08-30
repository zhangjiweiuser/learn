package com.zhang.learn.chapter2023.chapter08.chapter0830;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-08-30 18:09
 */
public class ZuHeZiMu {
    List<String> result = new ArrayList<>();
    String[] arr = {
            "", "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };

    public static void main(String[] args) {
        ZuHeZiMu zuHe = new ZuHeZiMu();
        zuHe.backtracking("23", 0);
        for (String li : zuHe.result) {
            System.out.print(li + "\t");
        }
    }

    StringBuilder temp = new StringBuilder();

    // digits = "23",num = 0 代表2 对应的abc
    public void backtracking(String digits, int num) {

        if (digits.length() == num) {
            result.add(temp.toString());
            return;
        }
        // str 代表当前num对应的字符串
        String str = arr[digits.charAt(num) - '0'];
        for (int i = 0; i < str.length(); i++) {
            temp.append(str.charAt(i));
            backtracking(digits, num + 1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
