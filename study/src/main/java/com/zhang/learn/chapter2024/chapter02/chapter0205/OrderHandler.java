package com.zhang.learn.chapter2024.chapter02.chapter0205;

import java.util.HashMap;
import java.util.Map;

public abstract class OrderHandler {

    protected OrderHandler orderHandler;

    protected static Map<Integer, Map<String,String>> chain = new HashMap<>();




    static {
        Map<String,String> map1 = new HashMap<>();
        map1.put("stock","coupon");
        map1.put("coupon","payment");
        chain.put(1,map1);


        Map<String,String> map2 = new HashMap<>();
        map2.put("stock","payment");
        chain.put(2,map2);
    }
    public void setSuccessor(OrderHandler orderHandler){
        this.orderHandler = orderHandler;
    }

    abstract void handleOrder(OrderRequest orderRequest);

    abstract String type();
}
