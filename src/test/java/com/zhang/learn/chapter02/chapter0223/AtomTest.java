package com.zhang.learn.chapter02.chapter0223;

import com.zhang.learn.chapter2021.chapter02.chapter0223.AtomUtil;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/2/23 9:49
 */
public class AtomTest {
    @Test
    void atomTest() {
        Runnable runnable = () -> {

            for (int i = 0; i < 10; i++) {
                int add = AtomUtil.add();
                System.out.println(add + "--" + Thread.currentThread().getName());
            }

        };

        Thread t1 = new Thread(runnable);
        t1.setName("线程1");
        Thread t2 = new Thread(runnable);
        t2.setName("线程2");
        t1.start();
        t2.start();
    }
    @Test
    void runNian(){
        System.out.println(LocalDate.of(2012,2,29).getDayOfMonth());
        System.out.println(LocalDate.of(2013,2,29).getDayOfMonth());
        System.out.println(LocalDate.of(2000,2,29).getDayOfMonth());
    }
}
