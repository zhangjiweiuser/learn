package com.zhang.learn.chapter2023.chapter02.chapter0206.chouxianggongchang.factorry;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-06 16:19
 */
public class JDKProxy {

    public static <T> T getProxy(Class<T> interfaceClass, ICacheAdapter cacheAdapter) {
        InvocationHandler invocationHandler = new JDKInvocationHandler(cacheAdapter);
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class<?>[] classes = interfaceClass.getInterfaces();
        return (T)Proxy.newProxyInstance(classLoader, new Class[]{classes[0]}, invocationHandler);
    }
}
