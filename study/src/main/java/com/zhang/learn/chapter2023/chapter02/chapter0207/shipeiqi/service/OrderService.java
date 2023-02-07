package com.zhang.learn.chapter2023.chapter02.chapter0207.shipeiqi.service;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-07 14:44
 */
@Slf4j
public class OrderService {
    public long queryUserOrderCount(String userId) {
        log.info("自营商家，查询用户的订单是否发为首单:{}", userId);
        return 10L;
    }
}
