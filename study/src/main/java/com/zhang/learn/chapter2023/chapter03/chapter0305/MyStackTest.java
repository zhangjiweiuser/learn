package com.zhang.learn.chapter2023.chapter03.chapter0305;

public class MyStackTest {
    public static void main(String[] args) {
        test1();
    }
    private static void test1(){
        MyStack<String> stack = new MyStack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
