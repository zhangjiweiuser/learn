package com.zhang.learn.chapter2023.chapter07.chapter0708;

public class Add {
    public static void main(String[] args) {
        System.out.println(add(5,6));
    }
    public static int add(int num1,int num2) {
        //突破口^运算相当于不进位的加法
        //使用按位与加左移1位保存进位信息
        while (num2 != 0) {
            int tmp = (num1 & num2) << 1;
            System.out.println(tmp);
            num1 ^= num2;
            //更新num2为进位信息数
            num2 = tmp;
        }
        return num1;
    }
}
