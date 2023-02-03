package com.zhang.rocketmq.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/8/6 11:10
 */
public class UrlUtil {
    private static Map<String, String> urlMap = new ConcurrentHashMap<>();

    public static void setUrl(String code, String url) {
        urlMap.put(code, url);
    }

    public static String get(String code) {
        return urlMap.get(code);
    }
}
