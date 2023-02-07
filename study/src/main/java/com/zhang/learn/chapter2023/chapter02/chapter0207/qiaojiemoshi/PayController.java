package com.zhang.learn.chapter2023.chapter02.chapter0207.qiaojiemoshi;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-07 18:10
 */
@Slf4j
public class PayController {

    public boolean doPay(String uid, String tradeId, BigDecimal amount, int channelType, int modelType) {
        // 微信支付
        if (1 == channelType) {
            log.info("模拟微信渠道支付，划账开始，uid:{},tradeId:{},amount:{}", uid, tradeId, amount);
            if (1 == modelType) {
                log.info("密码支付，风控校验环境安全");
            } else if (2 == modelType) {
                log.info("人脸支付，风控校验脸部识别");
            } else if (3 == modelType) {
                log.info("指纹支付，风控校验指纹信息");
            }
        }// 支付宝支付
        else if (2 == channelType) {
            log.info("模拟支付宝渠道支付划账开始。uId：{} tradeId：{} amount：{}", uid, tradeId, amount);
            if (1 == modelType) {
                log.info("密码支付，风控校验环境安全");
            } else if (2 == modelType) {
                log.info("人脸支付，风控校验脸部识别");
            } else if (3 == modelType) {
                log.info("指纹支付，风控校验指纹信息");
            }
        }
        return true;
    }
}
