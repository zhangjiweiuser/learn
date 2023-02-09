package com.zhang.learn.chapter2023.chapter02.chapter0209.celuemoshi;

import java.math.BigDecimal;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-09 16:49
 */
public interface ICouponDiscount<T> {
    BigDecimal discountAmount(T couponInfo, BigDecimal skuPrice);
}
