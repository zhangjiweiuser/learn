package com.zhang.learn.chapter2023.chapter07.chapter0712;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-07-12 18:41
 */
public class DaYin {
    private volatile static int num = 1;
    static Object lock = new Object();
    public static void main(String[] args) {

        Thread t1 = new Thread(()->{
            while(num <= 100){
                synchronized (lock){
                    if((num & 1) == 1){
                        System.out.println(Thread.currentThread().getName()+"--"+ num++);
                    }
                }
            }
        });
        Thread t2 = new Thread(()->{
            while(num <= 100){
                synchronized (lock){
                    if((num & 1) == 0){
                        System.out.println(Thread.currentThread().getName()+"--"+ num++);
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }
}
