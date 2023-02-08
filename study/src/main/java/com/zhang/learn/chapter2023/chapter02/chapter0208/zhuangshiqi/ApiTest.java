package com.zhang.learn.chapter2023.chapter02.chapter0208.zhuangshiqi;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-08 17:17
 */
public class ApiTest {
    public static void main(String[] args) {
        LoginSsoDecorator ssoDecorator = new LoginSsoDecorator(new SsoInterceptor());
        String request = "1successhuahua";
        boolean success = ssoDecorator.preHandle(request, "sdfsdf", "a");
        System.out.println("登录校验:" + request + (success ? " 放行" : "拦截"));
    }
}
