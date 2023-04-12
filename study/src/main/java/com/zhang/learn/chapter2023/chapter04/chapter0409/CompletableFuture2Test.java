package com.zhang.learn.chapter2023.chapter04.chapter0409;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class CompletableFuture2Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        futureTest3();
    }

    private static final ThreadPoolExecutor exportExecutor = new ThreadPoolExecutor(5, 5, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>(1000));

    /**
     * 所有的任务都必须执行完成，不设置总超时时间，写法感觉有点怪异
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    private static void futureTest() {

        List<CompletableFuture<Map<Integer, List<Integer>>>> tasks = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int finali = i;
            CompletableFuture<Map<Integer, List<Integer>>> submit = CompletableFuture.supplyAsync(() -> {
                Map<Integer, List<Integer>> verifyBillDetailRes = generate(finali);
                return verifyBillDetailRes;
            }, exportExecutor);
            tasks.add(submit);
        }
        System.out.println("111111111");
        CompletableFuture<Void> allFuture = CompletableFuture.allOf(tasks.toArray(new CompletableFuture[0]));
        System.out.println("2222222");
        CompletableFuture<List<Map<Integer, List<Integer>>>> listCompletableFuture = allFuture.thenApply(v -> tasks.stream().map(CompletableFuture::join).collect(Collectors.toList()));
        System.out.println("333333333");
        List<Map<Integer, List<Integer>>> result = listCompletableFuture.join();
        System.out.println("444444444");
        Map<Integer, List<Integer>> mapResult = result.stream().map(Map::entrySet).flatMap(Set::stream).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println("555555555555");
        System.out.println(mapResult);
    }

    /**
     * 所有的任务都必须执行完成，不设置总超时时间
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    private static void futureTest2() throws ExecutionException, InterruptedException {

        List<CompletableFuture<Map<Integer, List<Integer>>>> tasks = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int finali = i;
            CompletableFuture<Map<Integer, List<Integer>>> submit = CompletableFuture.supplyAsync(() -> {
                Map<Integer, List<Integer>> verifyBillDetailRes = generate(finali);
                return verifyBillDetailRes;
            }, exportExecutor);
            tasks.add(submit);
        }
        System.out.println("111111111");
        CompletableFuture<Void> future = CompletableFuture.allOf(tasks.toArray(new CompletableFuture[0]));
        future.join();
        Map<Integer, List<Integer>> result = new HashMap<>();
        for (int i = 0; i < tasks.size(); i++) {
            Map<Integer, List<Integer>> integerListMap = tasks.get(i).get();
            result.putAll(integerListMap);
        }
        System.out.println("2222222");
        System.out.println(result);
        exportExecutor.shutdown();
    }

    /**
     * 指定了接口的总超时时间，
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    private static void futureTest3() throws ExecutionException, InterruptedException {

        List<CompletableFuture<Map<Integer, List<Integer>>>> tasks = new ArrayList<>();
        Map<Integer, List<Integer>> result = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            int finali = i;
            CompletableFuture<Map<Integer, List<Integer>>> submit = CompletableFuture.supplyAsync(() -> {
                Map<Integer, List<Integer>> verifyBillDetailRes = generate(finali);
                return verifyBillDetailRes;
            }, exportExecutor).whenCompleteAsync((r, except) -> {
                if (r != null) {
                    System.out.println(r);
                    result.putAll(r);
                }
                if (except != null) {
                    except.printStackTrace();
                }
            }, exportExecutor);
            tasks.add(submit);
        }
        System.out.println("111111111");

        try {
            CompletableFuture.allOf(tasks.toArray(new CompletableFuture[0])).get(3, TimeUnit.SECONDS);
        } catch (TimeoutException e) {

        }
        System.out.println("2222222");
        System.out.println("总结果:" + result);
        exportExecutor.shutdown();
    }

    private static Map<Integer, List<Integer>> generate(int id) {
        System.out.println("开始第" + id + "个");
        if (id == 2) {
            double t = 1 / 0;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int i1 = ThreadLocalRandom.current().nextInt(100, 666);
            result.add(i1);
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(id, result);
        try {
            TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(1, 10));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("结束第" + id + "个");
        return map;
    }
}
