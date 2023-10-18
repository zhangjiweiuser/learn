package com.zhang.learn.chapter2023.chapter10.chapter1018;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.concurrent.TimeUnit;

public class SlidingWindowTest {
    static JedisPool pool;

    static {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(8);
        config.setMaxTotal(18);
        pool = new JedisPool(config, "127.0.0.1", 6379, 2000);
    }

    public static void main(String[] args) throws InterruptedException {
        Jedis jedis = pool.getResource();
        SlidingWindow window = new SlidingWindow(jedis);
        for (int i = 0; i < 15; i++) {
            boolean allowed = window.isActiveAllowed("jack", "view", 60, 5);
            System.out.println("第" + (i + 1) + "次操作" + (allowed ? "成功" : "失败"));
            TimeUnit.MILLISECONDS.sleep(1);
        }
        jedis.close();
    }
}
