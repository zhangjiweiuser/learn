package com.zhang.learn.chapter2023.chapter02.chapter0207.shipeiqi.mqservice;

import com.alibaba.fastjson2.JSON;
import com.zhang.learn.chapter2023.chapter02.chapter0207.shipeiqi.POPOrderDelivered;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-07 16:21
 */
public class POPOrderDeliveredService {
    public void onMessage(String message){
        POPOrderDelivered popOrderDelivered = JSON.parseObject(message, POPOrderDelivered.class);
        String uId = popOrderDelivered.getUId();
    }
}
