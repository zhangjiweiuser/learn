package com.zhang.db;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/10/15 15:04
 */
public class VariableTest {
    public static void main(String[] args) {
        Integer a = 1;
        System.out.println(add(a));
        System.out.println(a);
        String s = "a";
        System.out.println(append(s));
        System.out.println(s);
    }

    private static int add(Integer a) {
        a = a + 1;
        return a;
    }

    private static String append(String s) {
        s = s + "b";
        return s;
    }
}
