package com.zhang.learn.chapter2023.chapter07.chapter0713;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-07-13 17:08
 */
public class AorB {
    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            System.out.println(ab());
        }
    }

    private static String ab() {
        String r = "";
        boolean a = true;
        while ("".equals(r)) {
            if (a) {
                if (ThreadLocalRandom.current().nextInt(100) < 30) {
                    r = "a";
                } else {
                    a = false;
                }
            } else {
                if (ThreadLocalRandom.current().nextInt(100) < 50) {
                    r = "b";
                } else {
                    a = true;
                }
            }
        }
        return r;
    }

}
