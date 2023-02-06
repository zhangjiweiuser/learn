package learn.chapter2021.chapter03.chapter0322;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/3/22 14:49
 */
@Slf4j
@Service("CYPHER")
public class PayCypher implements IPayMode {
    @Override
    public boolean security(String uId) {
        log.info("密码支付，风控校验环境安全");
        return true;
    }

    @Override
    public boolean security(PayBaseMessage message) {
        PayCypherMessage cypherMessage = (PayCypherMessage) message;
        log.info("密码支付：{}", cypherMessage.toString());
        return false;
    }
}
