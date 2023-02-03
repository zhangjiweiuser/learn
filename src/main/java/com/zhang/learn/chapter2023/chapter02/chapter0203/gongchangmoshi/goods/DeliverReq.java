package com.zhang.learn.chapter2023.chapter02.chapter0203.gongchangmoshi.goods;

import lombok.Data;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-03 11:06
 */
@Data
public class DeliverReq {
    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 用户电话
     */
    private String userPhone;
    /**
     * 商品sku
     */
    private String sku;
    /**
     * 订单id
     */
    private String orderId;
    /**
     * 收货人姓名
     */
    private String consigneeUserName;
    /**
     * 收货人电话
     */
    private String consigneeUserPhone;
    /**
     * 收货人地址
     */
    private String consigneeUserAddress;
}
