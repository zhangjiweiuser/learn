package com.zhang.learn.chapter2023.chapter02.chapter0207.shipeiqi.service;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-07 14:48
 */
@Slf4j
public class POPOrderService {
    public boolean isFirstOrder(String uId) {
        log.info("POP商家，查询用户的订单是否为首单:{}", uId);
        return true;
    }
}
