package com.zhang.learn.chapter2021.chapter03.chapter0322;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/3/22 15:41
 */
@Slf4j
@Service
public class PayBizServiceImpl implements PayBizService {
    @Autowired
    private Map<String, Pay> payMap;

    @Override
    public boolean doPay(String uId, String tradeId, BigDecimal amount, int channelType, int modeType) {
        PayEum payEnum = PayEum.getByCode(channelType);
        if (null == payEnum) {
            log.info("模拟不支持该种支付方式，uId:{},tradeId:{},amount:{}，channelType:{}", uId, tradeId, amount, channelType);
            return false;
        }
        String code = payMap.get(payEnum.name()).transfer(uId, tradeId, amount, modeType);
        log.info("模拟支付结果：uId:{},tradeId:{},amount:{}，channelType:{},modeType:{},code:{}", uId, tradeId, amount, channelType, modeType, code);
        return "0000".equals(code);
    }
}
