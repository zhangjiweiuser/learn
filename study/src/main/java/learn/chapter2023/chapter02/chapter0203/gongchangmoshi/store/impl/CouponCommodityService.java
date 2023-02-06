package learn.chapter2023.chapter02.chapter0203.gongchangmoshi.store.impl;

import com.alibaba.fastjson2.JSON;
import learn.chapter2023.chapter02.chapter0203.gongchangmoshi.coupon.CouponResult;
import learn.chapter2023.chapter02.chapter0203.gongchangmoshi.coupon.CouponService;
import learn.chapter2023.chapter02.chapter0203.gongchangmoshi.store.ICommodity;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-03 16:48
 */
@Slf4j
public class CouponCommodityService implements ICommodity {

    private CouponService couponService = new CouponService();

    @Override
    public void sendCommodity(String uId, String commodity, String bizId, Map<String, String> extMap) throws Exception {
        CouponResult couponResult = couponService.sendCoupon(uId, commodity, bizId);
        log.info("请求参数[优惠券] => uId：{} commodity：{} bizId：{} extMap：{}", uId, commodity, bizId, JSON.toJSON(extMap));
        log.info("测试结果[优惠券]：{}", JSON.toJSON(couponResult));
        if (!"0000".equals(couponResult.getCode())) {
            throw new RuntimeException(couponResult.getInfo());
        }
    }
}
