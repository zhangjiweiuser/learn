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
@Service("WX")
public class WxPay implements Pay {
    //    public WxPay(IPayMode payMode) {
//        super(payMode);
//    }
    @Autowired
    private Map<String, IPayMode> payModeMap;

    @Override
    public String transfer(String uId, String tradeId, BigDecimal amount, int payModeType) {
        log.info("模拟微信渠道支付划账开始，uId:{},tradeId:{},amount:{}", uId, tradeId, amount);
        PayModeEnum payModeEnum = PayModeEnum.getByCode(payModeType);
        if (null == payModeEnum) {
            log.info("模拟微信不支持该种支付方式，uId:{},tradeId:{},amount:{}，payModeType:{}", uId, tradeId, amount, payModeType);
            return "0001";
        }

        PayBaseMessage baseMessage = null;
        switch (payModeEnum){
            case FACE:
                PayFaceMessage message = new PayFaceMessage();
                message.setUId(uId);
                message.setTradeId(tradeId);
                baseMessage = message;
                break;
            case CYPHER:
                PayCypherMessage message1 = new PayCypherMessage();
                message1.setUId(uId);
                message1.setCypherTradeId(tradeId);
                baseMessage = message1;
                break;
            case FINGERPRINT:
                PayFingerprintMessage message2 = new PayFingerprintMessage();
                message2.setUId(uId);
                message2.setFingerprintTradeId(tradeId);
                baseMessage = message2;
                break;
        }

//        boolean security = payModeMap.get(payModeEnum.name()).security(uId);
        boolean security = payModeMap.get(payModeEnum.name()).security(baseMessage);
        log.info("模拟微信渠道支付风控结果，uId:{},tradeId:{},security:{}", uId, tradeId, security);
        if (!security) {
            log.info("模拟微信渠道支付划账被拦截，uId:{},tradeId:{},amount:{}", uId, tradeId, amount);
            return "0001";
        }

        log.info("模拟微信渠道支付划账成功，uId:{},tradeId:{},amount:{}", uId, tradeId, amount);
        return "0000";
    }
}
