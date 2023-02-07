package com.zhang.learn.chapter2023.chapter02.chapter0207.qiaojiemoshi.channel;

import com.zhang.learn.chapter2023.chapter02.chapter0207.qiaojiemoshi.model.IPayMode;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-07 18:17
 */
@Slf4j
public abstract class Pay {
    protected IPayMode payMode;

    public Pay(IPayMode payMode){
        this.payMode = payMode;
    }

    public abstract String transfer(String uid, String tradeId, BigDecimal amount);
}
