package com.zhang.learn.chapter2023.chapter02.chapter0206.chouxianggongchang.factorry.impl;

import com.zhang.learn.chapter2023.chapter02.chapter0206.chouxianggongchang.factorry.ICacheAdapter;
import com.zhang.learn.chapter2023.chapter02.chapter0206.chouxianggongchang.matter.IIR;

import java.util.concurrent.TimeUnit;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-06 16:01
 */
public class IIRCacheAdapter implements ICacheAdapter {
    private IIR iir = new IIR();

    @Override
    public String get(String key) {
        return iir.get(key);
    }

    @Override
    public void set(String key, String value) {
        iir.set(key, value);
    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        iir.setExpire(key, value, timeout, timeUnit);
    }

    @Override
    public void del(String key) {
        iir.del(key);
    }
}
