package com.zhang.learn.chapter2023.chapter02.chapter0207.shipeiqi.mqservice;

import com.alibaba.fastjson2.JSON;
import com.zhang.learn.chapter2023.chapter02.chapter0207.shipeiqi.OrderMq;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-07 16:20
 */
public class OrderMqService {
    public void onMessage(String message){
        OrderMq orderMq = JSON.parseObject(message, OrderMq.class);
        String uid = orderMq.getUid();
    }
}
