package com.zhang.learn.chapter11.chapter1116;

import org.springframework.util.StopWatch;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/11/16 14:48
 */
public class StopWatchTest {
    public static void main(String[] args) {
        try {
            test1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void test1() throws InterruptedException {
        StopWatch sw = new StopWatch("test");
        sw.start("task1");
        Thread.sleep(100);
        sw.stop();
        sw.start("task2");
        Thread.sleep(200);
        sw.stop();
        System.out.println(sw.prettyPrint());
        System.out.println(sw.getTotalTimeNanos());
    }
}
