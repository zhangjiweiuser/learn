package com.zhang.learn.chapter2023.chapter09.chapter0927;

public class CountTime {
    public static void main(String[] args) {
        System.out.println(countTime("?5:00"));
        System.out.println(countTime("0?:0?"));
        System.out.println(countTime("??:??"));
    }

    public static int countTime(String time) {
        int res = 1;
        for (int i = 0; i < time.length(); i++) {
            if (time.charAt(i) == '?') {
                if (i == 0) {
                    if (time.charAt(1) == '?') {
                        res = 24;
                        i++;
                    } else {
                        if (time.charAt(1) < '4') {
                            res *= 3;
                        } else {
                            res *= 2;
                        }
                    }
                } else if (i == 1) {
                    if (time.charAt(0) == '2') {
                        res *= 4;
                    } else {
                        res *= 10;
                    }
                } else if (i == 3) {

                    res *= 6;

                } else if (i == 4) {
                    res *= 10;
                }
            }
        }
        return res;
    }

}
