package com.zhang.learn.chapter2023.chapter04.chapter0409;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class CompleteFutureTest {
    private static ExecutorService service = new ThreadPoolExecutor(10, 10, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1000));


    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        System.out.println("主线程开始");
        List<CompletableFuture<Integer>> futures = new ArrayList<>();
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("任务1 start:" + Thread.currentThread().getName());
            try {
                TimeUnit.MILLISECONDS.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("任务1 end:" + Thread.currentThread().getName());
            return 1;
        }, service);
        futures.add(future1);

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("任务2  start:" + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("任务2  end:" + Thread.currentThread().getName());
            return 2;
        }, service);
        futures.add(future2);
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
//        voidCompletableFuture.join();
//        future1.handleAsync((t,u)->{
//            System.out.println("t:"+t);
//            System.out.println("u:"+u);
//            return 100;
//        },service);
        long start = System.currentTimeMillis();
        Set<Integer> exists = new HashSet<>();
        while (System.currentTimeMillis() - start <= 4000) {
            for (int i = 0; i < futures.size(); i++) {
                try {
                    if (exists.contains(i)) {
                        continue;
                    }
                    System.out.println("获取结果 start：" + i + "--" + System.currentTimeMillis());
                    Object o = futures.get(i).get(100, TimeUnit.MILLISECONDS);
                    if (null != o) {
                        exists.add(i);
                    }
                    System.out.println("获得结果:" + o);
                    System.out.println("获取结果 end：" + System.currentTimeMillis());
                } catch (Exception e) {
                    System.out.println("获取结果 异常：" + System.currentTimeMillis());
                    System.out.println(e.getMessage());
                }
            }
        }

//        for (int i = 0; i < futures.size(); i++) {
//            try {
//                System.out.println("获取结果 start："+System.currentTimeMillis());
//                Object o = futures.get(i).get(2, TimeUnit.SECONDS);
//                System.out.println("获得结果:" + o);
//                System.out.println("获取结果 end："+System.currentTimeMillis());
//            } catch (Exception e) {
//                System.out.println("获取结果 异常："+System.currentTimeMillis());
//                System.out.println(e.getMessage());
//            }
//        }

//        future1.thenApplyAsync((f1)->{
//            System.out.println("f1:"+f1);
//            return f1;
//        },service);
//        future2.thenApplyAsync((f2)->{
//            System.out.println("f2:"+f2);
//            return f2;
//        },service);
        System.out.println("主线程结束");
    }

    private static String test1(int i) {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "aa";
    }

    private static String test2(int i) {
        return "bb";
    }
}
