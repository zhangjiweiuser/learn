package com.zhang.learn.chapter2023.chapter03.chapter0315;

public class ThreadPrintTest {
    private int i = 1;
    public static void main(String[] args) {
        ThreadPrintTest obj = new ThreadPrintTest();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while(obj.i < 1000){
                    synchronized (this){
                        notifyAll();
                        System.out.println("Thead:"+Thread.currentThread().getName()+"  "+ obj.i++);
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        };
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}
