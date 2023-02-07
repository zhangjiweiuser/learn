package com.zhang.learn.chapter2023.chapter02.chapter0207.qiaojiemoshi.model;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-07 18:19
 */
@Slf4j
public class PayFaceMode implements IPayMode {
    @Override
    public boolean security(String uid) {
        log.info("人脸支付，风控校验脸部识别");
        return true;
    }
}
