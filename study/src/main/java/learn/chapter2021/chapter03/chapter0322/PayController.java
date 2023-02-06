package learn.chapter2021.chapter03.chapter0322;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/3/22 14:38
 */
@Slf4j
public class PayController {

    public boolean doPay(String uId, String tradeId, BigDecimal amount, int channelType, int modeType) {
        // 微信支付
        if (1 == channelType) {
            log.info("模拟微信渠道支付划账开始，uId:{},tradeId:{},amount:{}", uId, tradeId, amount);
            if (1 == modeType) {
                log.info("密码支付，风控校验安全");
            } else if (2 == modeType) {
                log.info("人脸支付，风控校验安全");
            } else if (3 == modeType) {
                log.info("指纹支付，风控校验安全");
            }
        } else if (2 == channelType) {
            log.info("模拟支付宝渠道支付划账开始，uId:{},tradeId:{},amount:{}", uId, tradeId, amount);
            if (1 == modeType) {
                log.info("密码支付，风控校验安全");
            } else if (2 == modeType) {
                log.info("人脸支付，风控校验安全");
            } else if (3 == modeType) {
                log.info("指纹支付，风控校验安全");
            }
        }
        return true;
    }
}
