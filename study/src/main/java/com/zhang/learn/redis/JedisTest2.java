package com.zhang.learn.redis;

import redis.clients.jedis.Jedis;

public class JedisTest2 {
    public static void main(String[] args) throws InterruptedException {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
//        Transaction multi = jedis.multi();
//        multi.set("k1","v1");
//        multi.set("k2","v2");
////        int t = 1/0;
//        multi.set("k3","v3");
//        multi.exec();
        jedis.del("k1","k2","k3");
        System.out.println(jedis.get("k1"));
        System.out.println(jedis.get("k2"));
        System.out.println(jedis.get("k3"));
    }
}
