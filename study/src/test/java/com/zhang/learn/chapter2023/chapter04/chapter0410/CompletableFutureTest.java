package com.zhang.learn.chapter2023.chapter04.chapter0410;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-04-10 10:04
 */
public class CompletableFutureTest {
    private static final ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>(1000));

    @Test
    public void combineTest() throws ExecutionException, InterruptedException, TimeoutException {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                TimeUnit.MILLISECONDS.sleep(600);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 10;
        }, executor);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                TimeUnit.MILLISECONDS.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 20;
        }, executor);
        CompletableFuture<Integer> combineAsync = future1.thenCombineAsync(future2, (x, y) -> x * y, executor);
        System.out.println(combineAsync.get(5, TimeUnit.SECONDS));

    }

    @Test
    public void composeTest() throws ExecutionException, InterruptedException, TimeoutException {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                TimeUnit.MILLISECONDS.sleep(600);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 10;
        }, executor);
        CompletableFuture<Integer> future3 = future1.thenComposeAsync(t -> CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "\t" + t);
            try {
                TimeUnit.MILLISECONDS.sleep(600);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return t + 30;
        }, executor), executor);
        System.out.println(future3.get(5, TimeUnit.SECONDS));

    }

    @Test
    public void test3() throws ExecutionException, InterruptedException, TimeoutException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                TimeUnit.MILLISECONDS.sleep(600);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 10;
        }, executor).thenApply(t -> t + 30);

        System.out.println(future.get(5, TimeUnit.SECONDS));

    }

    @Test
    public void test4(){
        List<Integer> result = new ArrayList<>();
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                double t = 1 / 0;
                TimeUnit.MILLISECONDS.sleep(600);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 10;
        }, executor).whenCompleteAsync((res, except) -> {
            if (res != null) {
                result.add(res);
            }
            if (except != null) {
                System.out.println("tttttttttt");
            }
        }, executor);
        try {
            System.out.println(future.get(5, TimeUnit.SECONDS));
        } catch (Exception e) {
            System.out.println("----------");
        }
        System.out.println(result);
    }
}
