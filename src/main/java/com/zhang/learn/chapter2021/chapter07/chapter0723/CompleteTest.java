package com.zhang.learn.chapter2021.chapter07.chapter0723;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/7/23 18:01
 */
public class CompleteTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return "f1";
        });
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return "f2";
        });
        CompletableFuture<Object> orderResultCompletable =  CompletableFuture.anyOf(f1,f2);
        Object orderResult = orderResultCompletable.get(1, TimeUnit.SECONDS);
        System.out.println(orderResult);
    }
}
