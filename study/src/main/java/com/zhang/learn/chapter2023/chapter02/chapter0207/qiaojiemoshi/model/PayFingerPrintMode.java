package com.zhang.learn.chapter2023.chapter02.chapter0207.qiaojiemoshi.model;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-07 18:20
 */
@Slf4j
public class PayFingerPrintMode implements IPayMode {
    @Override
    public boolean security(String uid) {
        log.info("指纹支付，风控校验指纹信息");
        return true;
    }
}
