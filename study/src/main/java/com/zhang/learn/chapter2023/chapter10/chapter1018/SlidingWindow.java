package com.zhang.learn.chapter2023.chapter10.chapter1018;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

public class SlidingWindow {
    private Jedis jedis;

    public SlidingWindow(Jedis jedis) {
        this.jedis = jedis;
    }

    public boolean isActiveAllowed(String userId, String actionKey, int period, int maxCount) {
        String key = this.key(userId, actionKey);
        long ts = System.currentTimeMillis();

        Pipeline pipe = jedis.pipelined();

        pipe.multi();
        // 每个用户一个zset，这里是user+key组合
        pipe.zadd(key, ts, String.valueOf(ts));
        // 移除滑动窗口之外的数据
        pipe.zremrangeByScore(key, 0, ts - (period * 1000));
        // 获取窗口内的数量
        Response<Long> count = pipe.zcard(key);
        // 设置行为的过期时间，如果数据为冷数据，zset将会删除以此节省内存空间
        pipe.expire(key, period);

        pipe.exec();
        pipe.close();
        return count.get() <= maxCount;
    }

    private String key(String userId, String actionKey) {
        return String.format("limit:%s:%s", userId, actionKey);
    }
}
