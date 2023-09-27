package com.zhang.learn.chapter2023.chapter09.chapter0927;

public class HeQiShui {
    public static void main(String[] args) {
        System.out.println(qishui(2));
        System.out.println(qishui(4));
        System.out.println(qishui(5));
        System.out.println(qishui(20));
    }
    private static int qishui(int money){
        int result = money;
        int yu = 0;
        while(money > 1){
            result += money/2;
            yu = money % 2;
            money = money/2+yu;
        }
        return result;
    }
}
