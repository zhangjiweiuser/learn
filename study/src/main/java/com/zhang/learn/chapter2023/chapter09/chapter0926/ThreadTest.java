package com.zhang.learn.chapter2023.chapter09.chapter0926;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 300, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        for (int i = 0; i < 5000; i++) {
            System.out.println("到这里了，准备获取lock");
            lock.lock();

            if (executor.getQueue().size() == 10 && executor.getPoolSize() == 10) {
                TimeUnit.MILLISECONDS.sleep(10);
            }
            System.out.println("-----到这里1");
            executor.submit(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(1000,3000));
                    System.out.println("-----到这里2");
//                    condition.signalAll();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            int corePoolSize = executor.getCorePoolSize();
            int largestPoolSize = executor.getLargestPoolSize();
            int poolSize = executor.getPoolSize();
            long taskCount = executor.getTaskCount();
            int queueSize = executor.getQueue().size();
            System.out.println("corePoolSize:" + corePoolSize + ",poolSize:" + poolSize + ",largestPoolSize:" + largestPoolSize + ",taskCount:" + taskCount + ",queueSize:" + queueSize);
            TimeUnit.MILLISECONDS.sleep(10);
            lock.unlock();
        }


    }
}
