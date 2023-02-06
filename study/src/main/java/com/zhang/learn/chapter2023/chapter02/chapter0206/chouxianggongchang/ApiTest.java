package com.zhang.learn.chapter2023.chapter02.chapter0206.chouxianggongchang;

import com.zhang.learn.chapter2023.chapter02.chapter0206.chouxianggongchang.cuisine.impl.CacheServiceImpl;
import com.zhang.learn.chapter2023.chapter02.chapter0206.chouxianggongchang.factorry.JDKProxy;
import com.zhang.learn.chapter2023.chapter02.chapter0206.chouxianggongchang.factorry.impl.EGMCacheAdapter;
import com.zhang.learn.chapter2023.chapter02.chapter0206.chouxianggongchang.factorry.impl.IIRCacheAdapter;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-06 16:22
 */
public class ApiTest {
    public static void main(String[] args) {
        CacheService proxy_EGM = JDKProxy.getProxy(CacheServiceImpl.class, new EGMCacheAdapter());
        proxy_EGM.set("username", "xiaozhang");
        System.out.println("测试结果：" + proxy_EGM.get("username"));

        CacheService proxy_IIR = JDKProxy.getProxy(CacheServiceImpl.class, new IIRCacheAdapter());
        proxy_IIR.set("age", "15");
        System.out.println("测试结果：" + proxy_IIR.get("age"));
    }
}
