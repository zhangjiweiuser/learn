package com.zhang.learn.chapter2023.chapter02.chapter0209.celuemoshi;

import com.zhang.learn.chapter2023.chapter02.chapter0209.celuemoshi.impl.MJCouponDiscount;
import com.zhang.learn.chapter2023.chapter02.chapter0209.celuemoshi.impl.ZJCouponDiscount;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-09 16:57
 */
public class ApiTest {
    public static void main(String[] args) {
        zj();
        mj();
    }

    private static void zj() {
        Context<Double> context = new Context<>(new ZJCouponDiscount());
        BigDecimal bigDecimal = context.discountAmount(10D, new BigDecimal("100"));
        System.out.println("测试直减:" + bigDecimal);
    }

    private static void mj() {
        // 满100减10，商品100元
        Context<Map<String, String>> context = new Context<Map<String, String>>(new MJCouponDiscount());
        Map<String, String> mapReq = new HashMap<String, String>();
        mapReq.put("x", "100");
        mapReq.put("n", "10");
        BigDecimal discountAmount = context.discountAmount(mapReq, new BigDecimal(100));
        System.out.println("测试结果：满减优惠后金额：" + discountAmount);
    }
}
