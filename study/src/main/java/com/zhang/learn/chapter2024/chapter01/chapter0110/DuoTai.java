package com.zhang.learn.chapter2024.chapter01.chapter0110;

public class DuoTai {
    public static void main(String[] args) {
        TestInterface test = new YuWenImpl();
        System.out.println("yuwen:"+test.cal());
        TestInterface test2 = new MathImpl();
        System.out.println("math:"+test2.cal());
    }
}
