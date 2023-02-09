package com.zhang.learn.chapter2023.chapter02.chapter0209.celuemoshi.impl;

import com.zhang.learn.chapter2023.chapter02.chapter0209.celuemoshi.ICouponDiscount;

import java.math.BigDecimal;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-09 16:53
 */
public class NYGCouponDiscount implements ICouponDiscount<Double> {
    /**
     * n元购购买
     * 1. 无论原价多少钱都固定金额购买
     */
    @Override
    public BigDecimal discountAmount(Double couponInfo, BigDecimal skuPrice) {
        return new BigDecimal(couponInfo);
    }
}
