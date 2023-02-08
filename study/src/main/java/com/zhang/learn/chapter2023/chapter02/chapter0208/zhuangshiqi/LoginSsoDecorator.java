package com.zhang.learn.chapter2023.chapter02.chapter0208.zhuangshiqi;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-08 17:10
 */
public class LoginSsoDecorator extends SsoDecorator {
    private static Map<String, String> authMap = new ConcurrentHashMap<>();

    static {
        authMap.put("huahua", "queryUserInfo");
        authMap.put("doudou", "queryUserInfo");
    }
    public LoginSsoDecorator(HandlerInterceptor handlerInterceptor){
        super(handlerInterceptor);
    }
    @Override
    public boolean preHandle(String request, String response, Object handler) {
        boolean success = super.preHandle(request, response, handler);
        if (!success) {
            return false;
        }

        String userId = request.substring(8);
        String method = authMap.get(userId);

        // 模拟方法校验
        return "queryUserInfo".equals(method);
    }
}
