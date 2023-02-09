package com.zhang.learn.chapter2023.chapter02.chapter0209.hengyuanmoshi;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-09 9:27
 */
public class RedisUtil {
    private ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

    private AtomicInteger stock = new AtomicInteger(0);

    public RedisUtil(){
        executorService.scheduleAtFixedRate(()->{
            stock.addAndGet(1);
        },0,1000, TimeUnit.MILLISECONDS);
    }
    public int getStockUsed(){
        return stock.get();
    }
}
