package com.zhang.learn.chapter2024.chapter10.chapter1023;

import java.util.concurrent.*;

/**
 * @Name ：ExecutorTest
 * @Description ：TODO
 * @Author ：zhangjiwei
 * @Date ：2024/10/23 9:26
 * @Version ：1.0.0
 */
public class ExecutorTest {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 3, 10L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10), new MyAbortPolicy());
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 100; i++) {
            int finalI = i;

//

            executor.submit(() -> {
                try {
                    System.out.println("可用令牌1:" + Thread.currentThread().getName() + "====" + semaphore.availablePermits());
                    semaphore.acquire();
                    System.out.println("可用令牌2:" + Thread.currentThread().getName() + "====" + semaphore.availablePermits());
                    System.out.println(Thread.currentThread().getName() + "开始处理--" + finalI);
                    String result = handle(String.valueOf(finalI));

                    System.out.println(Thread.currentThread().getName() + result + "--" + finalI);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    semaphore.release();
                }
            });

        }
        try {
            Thread.sleep(300000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        executor.shutdown();
    }

    public static String handle(String order) {
        try {
            Thread.sleep(100);
            int i = ThreadLocalRandom.current().nextInt(10);
            if (i < 3) {
                throw new RuntimeException("处理失败");
            }
            return order + "-处理成功";
        } catch (Exception e) {
            return order + "-处理失败";
        }
    }

    public static class MyAbortPolicy implements RejectedExecutionHandler{

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println("进拒绝了");
        }
    }
}
