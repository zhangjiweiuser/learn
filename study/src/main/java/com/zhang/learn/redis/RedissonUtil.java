package com.zhang.learn.redis;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class RedissonUtil {
    private static RedissonClient client;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            try {
                lock();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "线程1").start();
        new Thread(() -> {
            try {
                lock();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "线程2").start();
        TimeUnit.SECONDS.sleep(100);
    }

    private static RedissonClient getRedis() {
        synchronized (RedissonUtil.class) {
            if (client == null) {
                synchronized (RedissonUtil.class) {
                    client = Redisson.create();
                }
            }
        }
        return client;
    }

    private static String format() {
        LocalDateTime time = LocalDateTime.now();
        String format = time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return format;
    }

    private static void lock() throws InterruptedException {
        RedissonClient client = getRedis();
        RLock lock = client.getLock("test-watch-dog");
        try {
            lock.lock(10, TimeUnit.SECONDS);

            System.out.println(Thread.currentThread().getId() + "==" + Thread.currentThread().getName() + "=" + format() + ":我要在这里干活");
            TimeUnit.SECONDS.sleep(45);
            System.out.println(Thread.currentThread().getId() + "==" + Thread.currentThread().getName() + "=" + format() + ":我干完了");
        } finally {
            if (null != lock && lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
    }
}
