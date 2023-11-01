package com.zhang.learn.chapter2023.chapter10.chapter1027;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class CompleteFutureTest {
    public static void main(String[] args) {
        // 1. 异步执行
        Runnable runnable = ()->{
            System.out.println("执行无返回结果的异步任务-开始");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("执行无返回结果的异步任务-结束");
        };
        CompletableFuture.runAsync(runnable);

        LockSupport.park();
    }
}
