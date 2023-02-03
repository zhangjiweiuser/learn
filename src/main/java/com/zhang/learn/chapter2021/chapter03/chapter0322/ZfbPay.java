package com.zhang.learn.chapter2021.chapter03.chapter0322;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/3/22 15:01
 */
@Slf4j
@Service("ZFB")
public class ZfbPay implements Pay {
//    public ZfbPay(IPayMode payMode) {
//        super(payMode);
//    }

    @Autowired
    private Map<String, IPayMode> payModeMap;

    @Override
    public String transfer(String uId, String tradeId, BigDecimal amount,int payModeType) {
        log.info("模拟支付宝渠道支付划账开始，uId:{},tradeId:{},amount:{}", uId, tradeId, amount);

        PayModeEnum payModeEnum = PayModeEnum.getByCode(payModeType);
        if (null == payModeEnum) {
            log.info("模拟支付宝不支持该种支付方式，uId:{},tradeId:{},amount:{}，payModeType:{}", uId, tradeId, amount, payModeType);
            return "0001";
        }

        boolean security = payModeMap.get(payModeEnum.name()).security(uId);
        log.info("模拟支付宝渠道支付风控结果，uId:{},tradeId:{},security:{}", uId, tradeId, security);
        if (!security) {
            log.info("模拟支付宝渠道支付划账被拦截，uId:{},tradeId:{},amount:{}", uId, tradeId, amount);
            return "0001";
        }
        log.info("模拟支付宝渠道支付划账成功，uId:{},tradeId:{},amount:{}", uId, tradeId, amount);
        return "0000";
    }
}
