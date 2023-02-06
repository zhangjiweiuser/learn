package learn.rabbitmq;

import lombok.Data;
import org.springframework.amqp.rabbit.connection.CorrelationData;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/4/8 11:24
 */
@Data
public class CorrelationDataExt extends CorrelationData {
    private Object data;
    private String exchange;
    private String routingKey;
}
