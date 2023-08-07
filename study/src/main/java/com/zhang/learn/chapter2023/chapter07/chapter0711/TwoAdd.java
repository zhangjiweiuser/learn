package com.zhang.learn.chapter2023.chapter07.chapter0711;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-07-11 15:15
 */
public class TwoAdd {
    public static void main(String[] args) {
        System.out.println(add(90,10));
        System.out.println(add(9,8));
        System.out.println(add(8,3));
    }

    public static int add(int num1,int num2){
        return num2 == 0 ? num1 : add(num1^num2,(num1&num2)<<1);
    }

}
