package com.zhang.learn.chapter2023.chapter02.chapter0206.chouxianggongchang.matter;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-06 9:39
 */
@Slf4j
public class EGM {
    private Map<String,String> data = new ConcurrentHashMap<>();

    public String gain(String key){
        log.info("EGM获取数据:{}",key);
        return data.get(key);
    }

    public void set(String key,String value){
        log.info("EGM写入数据 key:{},value:{}",key,value);
        data.put(key, value);
    }

    public void setEx(String key, String value, long timeout, TimeUnit timeUnit){
        log.info("EGM写入数据key:{},value:{},timeout:{},timeUnit:{}",key,value,timeout,timeUnit.toString());
        data.put(key, value);
    }
    public void delete(String key){
        log.info("EGM删除数据 key:{}",key);
        data.remove(key);
    }
}
