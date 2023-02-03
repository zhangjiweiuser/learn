package com.zhang.db.enums;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/9/28 17:26
 */
public class CouponTest {
    private final static Map<CouponType, CalculateCouponAbs> map = new HashMap<>();

    static {
        map.put(CouponType.MJ, new MJCouponCalculate());
        map.put(CouponType.ZK, new ZKCouponCalculate());
    }

    @Test
    public void mjTest() {
        Coupon coupon = Coupon.builder().money(500).fullMoney(1000).couponType(CouponType.MJ).build();
        assert 700 == calculate(1200, coupon);
        assert 700 == calculate(700, coupon);
    }

    @Test
    public void zkTest() {
        Coupon coupon = Coupon.builder().rate(0.8).fullMoney(1000).couponType(CouponType.ZK).build();
        assert 960 == calculate(1200, coupon);
        assert 980 == calculate(980, coupon);
    }

    private static int mj(int money, Coupon coupon) {
        if (money > coupon.getFullMoney()) {
            return money - coupon.getMoney() > 0 ? money - coupon.getMoney() : 0;
        }
        return money;
    }

    private static int zk(int money, Coupon coupon) {
        if (money > coupon.getFullMoney()) {
            return (int) (money * coupon.getRate());
        }
        return money;
    }

    private static int calculate(int money, Coupon coupon) {
        CalculateCouponAbs abs = map.get(coupon.getCouponType());
        if (null == abs) {
            return money;
        }
        return abs.calculate(money, coupon);
    }
}
