package com.zhang.learn.chapter2021.chapter03.chapter0302.store.impl;

import com.alibaba.fastjson2.JSON;
import com.zhang.learn.chapter2021.chapter03.chapter0302.coupon.CouponResult;
import com.zhang.learn.chapter2021.chapter03.chapter0302.coupon.CouponService;
import com.zhang.learn.chapter2021.chapter03.chapter0302.store.ICommodity;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/3/2 17:36
 */
@Slf4j
public class CouponCommodityService implements ICommodity {

    private CouponService couponService = new CouponService();

    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        CouponResult couponResult = couponService.sendCoupon(uId, commodityId, bizId);
        log.info("请求参数[优惠券] => uId：{} commodityId：{} bizId：{} extMap：{}", uId, commodityId, bizId, JSON.toJSON(extMap));
        log.info("测试结果[优惠券]：{}", JSON.toJSON(couponResult));
        if (!"0000".equals(couponResult.getCode())) {
            throw new RuntimeException(couponResult.getInfo());
        }
    }
}
