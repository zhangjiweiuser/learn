package com.zhang.learn;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/10/20 10:28
 */
@Slf4j
@Service
public class SlidingWindowService {

    private static final String SLIDING_WINDOW = "sliding_window_";

    private Object obj = new Object();

    @Resource
    private RedisTemplate redisTemplate;

    public boolean overMaxCount(String key, int windowInSecond, long maxCount) {
        key = SLIDING_WINDOW + key;
        long current = System.currentTimeMillis();
        // 窗口开始时间
        long windowStart = current - windowInSecond * 1000L;
        Long count = redisTemplate.opsForZSet().count(key, windowStart, current);
        return count >= maxCount;
    }

    public boolean canAccess(String key, int windowInSecond, long maxCount) {
        key = SLIDING_WINDOW + key;
        Long count = redisTemplate.opsForZSet().zCard(key);
        if (count < maxCount) {
            increment(key, windowInSecond);
            return true;
        }
        return false;
    }

    public boolean canAccess2(String key, int windowInSecond, long maxCount) {
        key = SLIDING_WINDOW + key;
        synchronized (this) {
            long current = System.currentTimeMillis() / 1000;
            // 窗口开始时间
            long windowStart = current - windowInSecond;
            Long count = redisTemplate.opsForZSet().count(key, windowStart, current);
            if (count < maxCount) {
                increment(key, windowInSecond);
                return true;
            }
            return false;
        }
    }

    public void increment(String key, int windowInSecond) {
        long current = System.currentTimeMillis() / 1000;
        long windowStart = current - windowInSecond;
        System.out.println("increment windowStart:" + windowStart);
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();
        zSetOperations.removeRangeByScore(key, 0, windowStart);
        zSetOperations.add(key, String.valueOf(current) + ThreadLocalRandom.current().nextInt(10000, 99999), current);
        redisTemplate.expire(key, windowInSecond, TimeUnit.SECONDS);
    }
}
