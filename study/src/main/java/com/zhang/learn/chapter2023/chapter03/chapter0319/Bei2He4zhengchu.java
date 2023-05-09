package com.zhang.learn.chapter2023.chapter03.chapter0319;

public class Bei2He4zhengchu {
    public static void main(String[] args) {
        System.out.println(bei2(4));
        System.out.println(bei4(4));
        System.out.println(bei2(3));
        System.out.println(bei4(3));
    }
    private static boolean bei2(int n){
        return (n & (n - 1)) == 0;
    }

    private static boolean bei4(int n){
        return (n & (n - 1)) == 0 && (n & 0x55555555) != 0;
    }
}
