package com.zhang.learn.chapter2023.chapter03.chapter0315;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class QueueTest2 {
    private static volatile boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        Queue<Integer> queue = new ArrayBlockingQueue<>(1000);
        Queue<Integer> queue2 = new ArrayBlockingQueue<>(1000);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
//        while(!queue.isEmpty()){
//            queue2.add(queue.poll());
//        }
        new Thread(()->{
            while(!queue.isEmpty()){
                synchronized (o){
                    if(flag){
                        System.out.println("我是线程1:"+queue.peek());
                        queue2.add(queue.poll());
                    }
                    try{
                        flag = !flag;
                        o.notifyAll();
                        o.wait(1000);
                    }catch (Exception e){

                    }

                }
            }

        }).start();
        new Thread(()->{
            while(!queue.isEmpty()){
                synchronized (o){
                    if(!flag){
                        System.out.println("我是线程2:"+queue.peek());
                        queue2.add(queue.poll());
                    }
                    try{
                        flag = !flag;
                        o.notifyAll();
                        o.wait(1000);
                    }catch (Exception e){

                    }

                }
            }
        }).start();
        TimeUnit.SECONDS.sleep(2);
        while(!queue2.isEmpty()){
            System.out.println(queue2.poll());
        }
    }
}
