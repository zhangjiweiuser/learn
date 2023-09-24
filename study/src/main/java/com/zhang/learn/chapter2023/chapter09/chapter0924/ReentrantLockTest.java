package com.zhang.learn.chapter2023.chapter09.chapter0924;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j(topic = "r")
public class ReentrantLockTest {
    static List<Thread> list = new ArrayList<>();
    static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(() -> {
                lock.lock();
                log.info("thread executed");
                try {
                    TimeUnit.MILLISECONDS.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
            }, "t" + i);
            list.add(t);
        }
        log.info("---启动顺序，调度顺序或者说获取锁的顺序");
        lock.lock();
        for (Thread thread : list) {
            log.info("{}--启动顺序，正序0-9", thread.getName());
            thread.start();
            TimeUnit.MILLISECONDS.sleep(1);
        }
        log.info("----执行顺序，正序0-9");
        lock.unlock();
    }
}
