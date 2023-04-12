package com.zhang.learn.redis;

import com.google.common.collect.Lists;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-04-10 11:25
 */
public class JedisTest {
    static List<Long> list = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
//        jedis.set("hello", "hello");
//        System.out.println(jedis.get("hello"));
//        jedis.del("hello");
//        for (int i = 0; i < 15; i++) {
//            TimeUnit.MILLISECONDS.sleep(1);
//            boolean actionAllowed = isActionAllowedByLua(jedis, "getUser", "export", 60, 5);
//            System.out.println("第" + i + "次操作" + (actionAllowed ? "成功" : "失败"));
//        }

//        List<Double> zmscore = jedis.zmscore(key("getUser", "export"), "1681101808077", "1681101808102");
//        System.out.println(zmscore);

        for (int i = 0; i < 15; i++) {
            TimeUnit.MILLISECONDS.sleep(1);
            boolean actionAllowed = isActionAllowedByList(jedis, "getUser", "export", 60, 5);
            System.out.println("第" + i + "次操作" + (actionAllowed ? "成功" : "失败"));
        }


    }

    public static boolean isActionAllowed(Jedis jedis, String userId, String actionKey, int period, int maxCount) {
        String key = key(userId, actionKey);
        long ts = System.currentTimeMillis();
        System.out.println("ts:" + ts);
        Pipeline pipeline = jedis.pipelined();
        pipeline.multi();
        pipeline.zadd(key, ts, String.valueOf(ts));
        // 移除滑动窗口之外的数据
        pipeline.zremrangeByScore(key, 0, ts - period * 1000);
        Response<Long> zcard = pipeline.zcard(key);
        // 设置行为的过期时间，如果数据为冷数据，zset将会删除以此节省内存空间
        pipeline.expire(key, period);
        pipeline.exec();
        pipeline.close();
        return zcard.get() <= maxCount;
    }

    public static boolean isActionAllowedByLua(Jedis jedis, String userId, String actionKey, int period, int maxCount) {

        String key = key(userId, actionKey);
        long ts = System.currentTimeMillis();
        System.out.println("ts:" + ts);
        if (list.size() >= maxCount) {
            if (list.get(0) < ts - period * 1000) {
                list.remove(0);
                list.add(ts);
                return true;
            } else {
                return false;
            }
        } else {
            list.add(ts);
            return true;
        }
    }

    public static boolean isActionAllowedByList(Jedis jedis, String userId, String actionKey, int period, int maxCount) {
        String lua = buildLuaScript();
        String key = key(userId, actionKey);
        long ts = System.currentTimeMillis();
        System.out.println("ts:" + ts);
        Object eval = jedis.eval(lua, Lists.newArrayList(key), Lists.newArrayList(String.valueOf(ts), String.valueOf(ts - period * 1000), String.valueOf(period)));
        return eval != null && Integer.valueOf(eval.toString()) <= maxCount;
    }

    public static String key(String userId, String actionKey) {
        return String.format("limit:%s:%s", userId, actionKey);
    }

    public static String buildLuaScript() {
        return "redis.call('ZADD',KEYS[1],tonumber(ARGV[1]),ARGV[1])" +
                "\nredis.call('ZREMRANGEBYSCORE',KEYS[1],0,tonumber(ARGV[2]))" +
                "\nlocal c" +
                "\nc = redis.call('ZCARD',KEYS[1])" +
                "\nredis.call('EXPIRE',KEYS[1],tonumber(ARGV[3]))" +
                "\nreturn c;";
    }
}
