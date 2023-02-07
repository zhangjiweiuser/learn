package com.zhang.learn.chapter2023.chapter02.chapter0207.shipeiqi;

import lombok.Data;

import java.util.Date;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-07 14:08
 */
@Data
public class OrderMq {
    /**
     * 用户id
     */
    private String uid;
    /**
     * 商品
     */
    private String sku;
    /**
     * 订单id
     */
    private String orderId;
    /**
     * 下单时间
     */
    private Date createOrderTime;
}
