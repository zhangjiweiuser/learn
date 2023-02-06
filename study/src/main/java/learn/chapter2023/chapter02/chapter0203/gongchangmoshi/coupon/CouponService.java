package learn.chapter2023.chapter02.chapter0203.gongchangmoshi.coupon;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-03 11:00
 */
@Slf4j
public class CouponService {
    public CouponResult sendCoupon(String uId, String couponNumber, String uuid) {
        log.info("模拟发送优惠券一张{},{},{}", uId, couponNumber, uuid);
        return new CouponResult("0000", "发送成功");
    }
}
