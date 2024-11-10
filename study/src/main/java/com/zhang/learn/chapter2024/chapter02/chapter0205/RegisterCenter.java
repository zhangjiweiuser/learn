package com.zhang.learn.chapter2024.chapter02.chapter0205;

import java.util.HashMap;
import java.util.Map;

public class RegisterCenter {
    private static Map<String,OrderHandler> chainHandler = new HashMap<>();

    public static OrderHandler getHandler(String type){
        return chainHandler.get(type);
    }
    public static void  register(String type,OrderHandler orderHandler){
        chainHandler.put(type,orderHandler);
    }
}
