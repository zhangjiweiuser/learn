package com.zhang.learn.chapter2023.chapter02.chapter0206.chouxianggongchang.cuisine.impl;

import com.zhang.learn.chapter2023.chapter02.chapter0206.chouxianggongchang.CacheService;
import com.zhang.learn.chapter2023.chapter02.chapter0206.chouxianggongchang.RedisUtil;
import com.zhang.learn.chapter2023.chapter02.chapter0206.chouxianggongchang.matter.EGM;
import com.zhang.learn.chapter2023.chapter02.chapter0206.chouxianggongchang.matter.IIR;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-06 9:37
 */
@Slf4j
public class CacheServiceImpl implements CacheService {

    private RedisUtil redisUtil = new RedisUtil();


    @Override
    public String get(String key) {

        return redisUtil.get(key);
    }

    @Override
    public void set(String key, String value) {

        redisUtil.set(key, value);
    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit) {

        redisUtil.set(key, value, timeout, timeUnit);
    }

    @Override
    public void del(String key) {

        redisUtil.del(key);
    }
}
