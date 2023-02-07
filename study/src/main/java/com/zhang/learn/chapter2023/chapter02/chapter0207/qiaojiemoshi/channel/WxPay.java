package com.zhang.learn.chapter2023.chapter02.chapter0207.qiaojiemoshi.channel;

import com.zhang.learn.chapter2023.chapter02.chapter0207.qiaojiemoshi.model.IPayMode;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-07 18:24
 */
@Slf4j
public class WxPay extends Pay {

    public WxPay(IPayMode payMode) {
        super(payMode);
    }

    @Override
    public String transfer(String uid, String tradeId, BigDecimal amount) {
        log.info("模拟微信渠道支付划账开始。uId：{} tradeId：{} amount：{}", uid, tradeId, amount);
        boolean security = payMode.security(uid);
        log.info("模拟微信渠道支付风控校验。uId：{} tradeId：{} security：{}", uid, tradeId, security);
        if (!security) {
            log.info("模拟微信渠道支付划账拦截。uId：{} tradeId：{} amount：{}", uid, tradeId, amount);
            return "0001";
        }
        log.info("模拟微信渠道支付划账成功。uId：{} tradeId：{} amount：{}", uid, tradeId, amount);
        return "0000";
    }
}
