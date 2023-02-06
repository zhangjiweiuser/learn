package com.zhang.learn.chapter2023.chapter02.chapter0206.chouxianggongchang;

import java.util.concurrent.TimeUnit;

public interface CacheService {
    String get(String key);

    void set(String key,String value);

    void set(String key, String value, long timeout, TimeUnit timeUnit);

    void del(String key);
}
