package com.zhang.learn.chapter2023.chapter02.chapter0206.chouxianggongchang.matter;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-06 10:14
 */
@Slf4j
public class IIR {
    private Map<String, String> data = new ConcurrentHashMap<>();

    public String get(String key) {
        log.info("IIR 获取数据 key:{}", key);
        return data.get(key);
    }

    public void set(String key, String value) {
        log.info("IIR 写入数据 key:{},value:{}", key, value);
        data.put(key, value);
    }

    public void setExpire(String key, String value, long timeout, TimeUnit timeUnit) {
        log.info("IIR 写入数据key:{},value:{},timeout:{},timeUnit:{}", key, value, timeout, timeUnit.toString());
        data.put(key, value);
    }

    public void del(String key) {
        log.info("IIR删除数据 key:{}", key);
        data.remove(key);
    }
}
