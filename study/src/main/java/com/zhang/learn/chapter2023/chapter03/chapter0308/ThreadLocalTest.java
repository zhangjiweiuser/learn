package com.zhang.learn.chapter2023.chapter03.chapter0308;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-03-08 14:38
 */
public class ThreadLocalTest {
    public static void main(String[] args) {
        test1();
    }

    private static void test1(){
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("aaa");
        String s = threadLocal.get();
        System.out.println(s);
    }
}

