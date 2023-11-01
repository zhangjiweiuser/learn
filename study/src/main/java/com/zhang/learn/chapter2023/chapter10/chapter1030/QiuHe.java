package com.zhang.learn.chapter2023.chapter10.chapter1030;

public class QiuHe {
    public static void main(String[] args) {
        System.out.println(add(5,7));
    }
    private static int add(int a,int b){
        while (b > 0){
            int m = (a & b) << 1;
            a = a ^ b;
            b = m;
        }
        return a;
    }
}
