package com.zhang.learn.chapter11.chapter1119;

import com.google.common.util.concurrent.RateLimiter;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/11/19 11:12
 */
public class RateLimit {
    public static void main(String[] args) {
        RateLimiter limiter = RateLimiter.create(6);
        for (int i = 0; i < 10; i++) {
            boolean acquire = limiter.tryAcquire();
            if(acquire){
                System.out.println(String.format("我是第%d个，我获取到了凭证",i));
            }else{
                System.out.println(String.format("我是第%d个，我没有获取到了凭证",i));
            }
        }


    }
}
