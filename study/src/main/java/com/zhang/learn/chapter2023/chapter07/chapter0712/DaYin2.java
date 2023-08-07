package com.zhang.learn.chapter2023.chapter07.chapter0712;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-07-12 18:41
 */
public class DaYin2 {
    private volatile static int num = 1;
    static Object lock = new Object();

    public static void main(String[] args) {

        Thread t1 = new Thread(new Printer());
        Thread t2 = new Thread(new Printer());
        t1.start();
        t2.start();
    }

    static class Printer implements Runnable {

        @Override
        public void run() {
            while (num <= 100) {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + "--" + num++);
                    lock.notify();
                    if (num <= 100) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }
}
