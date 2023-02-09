package com.zhang.learn.chapter2023.chapter02.chapter0209.zerenlianmoshi;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-09 9:50
 */
public class AuthService {
    private static Map<String, LocalDateTime> authMap = new ConcurrentHashMap<>();

    public static LocalDateTime queryAuthInfo(String uid, String orderId) {
        return authMap.get(uid.concat(orderId));
    }

    public static void auth(String uid, String orderId) {
        authMap.put(uid.concat(orderId), LocalDateTime.now());
    }
}
