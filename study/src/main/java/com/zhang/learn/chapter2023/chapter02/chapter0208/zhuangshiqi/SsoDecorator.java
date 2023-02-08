package com.zhang.learn.chapter2023.chapter02.chapter0208.zhuangshiqi;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-08 17:14
 */
public abstract class SsoDecorator implements HandlerInterceptor {

    private HandlerInterceptor handlerInterceptor;

    private SsoDecorator() {
    }

    public SsoDecorator(HandlerInterceptor handlerInterceptor) {
        this.handlerInterceptor = handlerInterceptor;
    }

    @Override
    public boolean preHandle(String request, String response, Object handler) {
        return handlerInterceptor.preHandle(request, response, handler);
    }
}
