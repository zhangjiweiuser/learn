package com.zhang.learn.chapter2023.chapter02.chapter0207.shipeiqi;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-07 14:11
 */
@Data
public class POPOrderDelivered {
    /**
     * 用户id
     */
    private String uId;
    /**
     * 订单号
     */
    private String orderId;
    /**
     * 下单时间
     */
    private Date orderTime;
    /**
     * 商品
     */
    private Date sku;
    /**
     * 商品名称
     */
    private Date skuName;
    /**
     * 金额
     */
    private BigDecimal decimal;
}
