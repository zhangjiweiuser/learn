package com.zhang.learn.chapter2023.chapter02.chapter0209.celuemoshi;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-09 11:16
 */
public class CouponDiscountService {
    public double discount(int type, double typeContent, double skuPrice, double typeExt) {
        if (1 == type) {
            return skuPrice - typeContent;
        }
        if (2 == type) {
            if (skuPrice < typeExt) {
                return skuPrice;
            }
            return skuPrice - typeContent;
        }
        if (3 == type) {
            return skuPrice * typeContent;
        }
        if (4 == type) {
            return typeContent;
        }
        return 0d;
    }
}
