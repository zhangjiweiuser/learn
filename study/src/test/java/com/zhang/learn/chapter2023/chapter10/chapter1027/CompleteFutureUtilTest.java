package com.zhang.learn.chapter2023.chapter10.chapter1027;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class CompleteFutureUtilTest {
    @Test
    public void runAsyncTest() {
        // 1. 异步执行
        Runnable runnable = () -> {
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

    @Test
    public void supplyAsyncTest() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("执行有返回值的异步任务");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hello World";
        });
//        String result = future.get();
//        System.out.println(result);

        // step3:异步执行 阻塞获取结果后对结果进行运算处理 不改变最终结果
        String result2 = future.whenComplete(new BiConsumer<String, Throwable>() {
            @Override
            public void accept(String t, Throwable action) {
                t = t + " test";
                System.out.println("任务执行后结果处理" + t);
            }
        }).exceptionally(new Function<Throwable, String>() {
            @Override
            public String apply(Throwable t) {
                System.out.println("任务执行后结果额外处理-如果有异常进入此处");
                return "异常结果";
            }
        }).get();

        System.out.println("最终结果" + result2);
    }
}
