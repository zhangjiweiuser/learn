package com.zhang.learn.chapter2023.chapter09.chapter0927;

import java.util.ArrayList;
import java.util.List;

public class ZhiShu {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 101; i < 200; i++) {
            boolean flag = true;
            for (int j = 2; j <= (int) Math.sqrt(i); j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(i);
            }
        }
        System.out.println(list);
    }
}
