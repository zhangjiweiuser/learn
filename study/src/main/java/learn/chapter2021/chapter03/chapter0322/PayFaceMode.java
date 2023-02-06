package learn.chapter2021.chapter03.chapter0322;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/3/22 14:47
 */
@Slf4j
@Service("FACE")
public class PayFaceMode implements IPayMode {
    @Override
    public boolean security(String uId) {
        log.info("人脸支付，风控校验脸部识别通过");
        return true;
    }

    @Override
    public boolean security(PayBaseMessage message) {
        PayFaceMessage faceMessage = (PayFaceMessage) message;
        log.info("人脸支付，{}", faceMessage.toString());
        return true;
    }
}
