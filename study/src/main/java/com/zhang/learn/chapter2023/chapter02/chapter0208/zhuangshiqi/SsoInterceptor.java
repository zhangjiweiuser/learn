package com.zhang.learn.chapter2023.chapter02.chapter0208.zhuangshiqi;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-08 17:09
 */
public class SsoInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(String request, String response, Object handler) {
        // 模拟获取cookie
        String ticket = request.substring(1, 8);
        return "success".equals(ticket);
    }
}
