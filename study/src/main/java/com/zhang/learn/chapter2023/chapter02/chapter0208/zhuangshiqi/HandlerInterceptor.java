package com.zhang.learn.chapter2023.chapter02.chapter0208.zhuangshiqi;

public interface HandlerInterceptor {
    boolean preHandle(String request,String response,Object handler);
}
