package com.zhang.learn.chapter2023.chapter02.chapter0203.gongchangmoshi.coupon;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-03 10:59
 */
@Data
@AllArgsConstructor
public class CouponResult {
    /**
     * 编码
     */
    private String code;
    /**
     * 描述
     */
    private String info;
}
