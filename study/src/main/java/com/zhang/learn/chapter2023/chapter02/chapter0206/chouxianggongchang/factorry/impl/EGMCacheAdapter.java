package com.zhang.learn.chapter2023.chapter02.chapter0206.chouxianggongchang.factorry.impl;

import com.zhang.learn.chapter2023.chapter02.chapter0206.chouxianggongchang.factorry.ICacheAdapter;
import com.zhang.learn.chapter2023.chapter02.chapter0206.chouxianggongchang.matter.EGM;

import java.util.concurrent.TimeUnit;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-06 16:00
 */
public class EGMCacheAdapter implements ICacheAdapter {

    private EGM egm = new EGM();

    @Override
    public String get(String key) {
        return egm.gain(key);
    }

    @Override
    public void set(String key, String value) {
        egm.set(key,value);
    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        egm.setEx(key, value, timeout, timeUnit);
    }

    @Override
    public void del(String key) {
        egm.delete(key);
    }
}
