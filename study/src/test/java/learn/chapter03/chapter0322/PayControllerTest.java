package learn.chapter03.chapter0322;

import com.zhang.learn.chapter2021.chapter03.chapter0322.PayBizService;
import com.zhang.learn.chapter2021.chapter03.chapter0322.PayController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/3/3 10:33
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PayControllerTest {
    @Test
    void payTest() {
        PayController pay = new PayController();
        System.out.println("\r\n模拟测试场景；微信⽀支付、⼈人脸⽅方式。 ");
        pay.doPay("weixin_1092033111", "100000109893", new BigDecimal(100), 1,
                2);
        System.out.println("\r\n模拟测试场景；⽀支付宝⽀支付、指纹⽅方式。 ");
        pay.doPay("jlu19dlxo111", "100000109894", new BigDecimal(100), 2, 3);
    }

    @Autowired
    private PayBizService payBizService;

    @Test
    void payBridgeTest() {
        payBizService.doPay("jlu19dlxo111", "100000109894", new BigDecimal(100), 1, 1);
//        System.out.println("\r\n模拟测试场景；微信⽀支付、⼈人脸⽅方式。 ");
//        Pay wxPay = new WxPay(new PayFaceMode());
//        wxPay.transfer("weixin_1092033111", "100000109893", new BigDecimal(100));
//        System.out.println("\r\n模拟测试场景；⽀支付宝⽀支付、指纹⽅方式。 ");
//        Pay zfbPay = new ZfbPay(new PayFaceMode());
//        zfbPay.transfer("jlu19dlxo111", "100000109894", new BigDecimal(100));
    }
}
