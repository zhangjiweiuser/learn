package com.zhang.learn.chapter2023.chapter09.chapter0926;

import java.util.ArrayList;
import java.util.List;

public class KuoHao {
    static List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        generate("", 3, 3);
        for (String s : result) {
            System.out.println(s);
        }
    }

    private static void generate(String str, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(str);
            return;
        }
        if (left == right) {
            generate(str + "(", left - 1, right);
        } else if (left < right) {
            if (left > 0) {
                generate(str + "(", left - 1, right);
            }
            generate(str + ")", left, right - 1);
        }
    }
}
