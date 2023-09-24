package com.zhang.learn.chapter2023.chapter09.chapter0924;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j(topic = "w")
public class WaitTest {
    static List<Thread> list = new ArrayList<>();
    static final Object lock = new Object();
    static boolean isWoman = false;

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            synchronized (lock) {
                while (!isWoman) {
                    log.info("没有女人，我去休息去了");
                    try {
//                        TimeUnit.SECONDS.sleep(600);
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            log.info("thread executed");
            try {
                TimeUnit.MILLISECONDS.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "jack").start();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                synchronized (lock) {
                    log.info("那些默默无闻的程序员coding");
                }
            }, "程序员" + i).start();

        }
    }
}
