package com.zhang.learn.chapter2023.chapter10.chapter1026;

public class PrintUtil {
    private static volatile int t = 0;

    private static final Object obj = new Object();

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {

                synchronized (obj) {

                    while (t < 100) {

                        obj.notifyAll();

                        System.out.println(Thread.currentThread().getName() + "输出的是" + (++t));
                        try {
                            Thread.sleep(500);
                            obj.wait();

                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }, "线程1").start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj) {
                    while (t < 100) {
                        obj.notifyAll();
                        System.out.println(Thread.currentThread().getName() + "输出的是" + (++t));
                        try {
                            Thread.sleep(500);
                            obj.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }, "线程2").start();
    }
}
