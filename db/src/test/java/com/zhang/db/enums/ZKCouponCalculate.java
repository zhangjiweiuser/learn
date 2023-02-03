package com.zhang.db.enums;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/9/28 17:37
 */
public class ZKCouponCalculate extends CalculateCouponAbs {
    @Override
    int calculate(int money, Coupon coupon) {
        if (money > coupon.getFullMoney()) {
            return (int) (money * coupon.getRate());
        }
        return money;
    }
}
