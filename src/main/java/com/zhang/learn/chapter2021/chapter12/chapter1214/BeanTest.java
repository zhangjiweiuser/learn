package com.zhang.learn.chapter2021.chapter12.chapter1214;

import org.springframework.beans.BeanUtils;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/12/14 11:09
 */
public class BeanTest {
    public static void main(String[] args) {
        C c = new C(40, "管理员");
        A a = new A(100, "zhangsan", c);
        B b = new B();
        BeanUtils.copyProperties(a, b);
        System.out.println(b);
        c.setId(200);
        System.out.println(a);
        System.out.println(b);
    }
}
