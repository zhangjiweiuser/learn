package com.zhang.learn.chapter2023.chapter02.chapter0206.jianzaozhe;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-06 17:45
 */
public class ApiTest {
    public static void main(String[] args) {
        Builder builder = new Builder();

        // 豪华欧式
        System.out.println(builder.levelOne(132.52D).getDetail());

        // 轻奢田园
        System.out.println(builder.levelTwo(98.25D).getDetail());

        // 现代简约
        System.out.println(builder.levelThree(85.43D).getDetail());
    }
}
