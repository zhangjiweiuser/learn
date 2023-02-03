package com.zhang.db.enums;

import lombok.Builder;
import lombok.Data;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/9/28 17:23
 */
@Data
@Builder
public class Coupon {
    private CouponType couponType;
    /**
     * 总金额
     */
    private Integer money;
    /**
     * 折扣率
     */
    private double rate;
    /**
     * 满多少金额折扣
     */
    private Integer fullMoney;
    /**
     * 折扣金额
     */
    private Integer discountMoney;

}
