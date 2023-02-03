package com.zhang.learn.chapter2021.chapter09.chapter0914;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/9/14 14:46
 */
public interface HandlerInterceptor {

    boolean preHandle(String request, String response, Object handler);
}
