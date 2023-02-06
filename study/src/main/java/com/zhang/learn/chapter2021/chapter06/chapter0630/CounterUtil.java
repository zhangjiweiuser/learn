package com.zhang.learn.chapter2021.chapter06.chapter0630;

import java.util.concurrent.CountDownLatch;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/6/30 14:25
 */
public class CounterUtil {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        CountDownLatch latch = new CountDownLatch(3);
        Thread t1 = new Thread(new CountRun(counter, latch));
        Thread t2 = new Thread(new CountRun(counter, latch));
        Thread t3 = new Thread(new CountRun(counter, latch));

        t1.start();
        t2.start();
        t3.start();
        latch.await();
        System.out.println("执行完毕");

        System.out.println(counter.getCount());
    }

    static class CountRun implements Runnable {
        private Counter counter;
        private CountDownLatch latch;

        public CountRun(Counter counter, CountDownLatch latch) {
            this.counter = counter;
            this.latch = latch;
        }

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                counter.incr();
            }
            latch.countDown();
            System.out.println(Thread.currentThread().getName() + "执行完毕");
        }
    }
}
