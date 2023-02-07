package com.zhang.learn.chapter2023.chapter02.chapter0207.qiaojiemoshi.model;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-07 18:18
 */
@Slf4j
public class PayCypher implements IPayMode{
    @Override
    public boolean security(String uid) {
        log.info("密码支付，风控校验环境安全");
        return true;
    }
}
