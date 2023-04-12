package com.zhang.learn.chapter2023.chapter04.chapter0411;

import redis.clients.jedis.JedisPool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-04-11 17:22
 */
public class OrderUtil {
    public static void main(String[] args) throws InterruptedException {
        JedisPool jedis = new JedisPool("127.0.0.1", 6379);
        jedis.getResource().set("orderno", "100");
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>(1000));
        for (int i = 0; i < 50; i++) {
            System.out.println("i:\t\t\t"+i);
            int finali = i;
            executor.execute(() -> {
                int nextInt = ThreadLocalRandom.current().nextInt(1, 10);
                System.out.println("第" + finali + "个线程:" + Thread.currentThread().getName() + "\t" + nextInt);
                Long orderno = jedis.getResource().decrBy("orderno", nextInt);
                if (orderno > 0) {
                    System.out.println("第" + finali + "个线程:" + Thread.currentThread().getName() + "成功了");
                } else {
                    System.out.println("第" + finali + "个线程:" + Thread.currentThread().getName() + "失败了");
                }
            });
        }
        TimeUnit.SECONDS.sleep(10);
//        Long orderno = jedis.getResource().decrBy("orderno", 4);
//        System.out.println(orderno);
//        orderno = jedis.getResource().decrBy("orderno", 500);
//        System.out.println(orderno);
//        orderno = jedis.getResource().decrBy("orderno", 10);
//        System.out.println(orderno);
//        jedis.getResource().del("orderno");
    }
}
