package com.zhang.learn.chapter2021.chapter03.chapter0322;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/3/22 14:48
 */
@Slf4j
@Service("FINGERPRINT")
public class PayFingerprintMode implements IPayMode {
    @Override
    public boolean security(String uId) {
        log.info("指纹支付，风控校验指纹信息");
        return true;
    }

    @Override
    public boolean security(PayBaseMessage message) {
        PayFingerprintMessage fingerprintMessage = (PayFingerprintMessage) message;
        log.info("指纹支付:{}",fingerprintMessage.toString());
        return false;
    }
}
