package learn.rabbitmq;

import cn.hutool.core.lang.UUID;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/7/17 11:11
 */
@Configuration
public class DemoSender implements RabbitTemplate.ReturnCallback {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    public String send(String message) {
        String messageId = System.currentTimeMillis() + "$" + UUID.randomUUID().toString();
        CorrelationDataExt data = new CorrelationDataExt();
        data.setId(messageId);
        data.setExchange("exchange_demo");
        data.setRoutingKey("routingkey_demo");
        data.setData(message);
        rabbitTemplate.convertAndSend("exchange_demo", "routingkey_demo", message, data);

        return message;
    }

    public String sendDelay(String message, int delay) {
        message += LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String messageId = System.currentTimeMillis() + "$" + UUID.randomUUID().toString();
        CorrelationData data = new CorrelationData(messageId);
//        if (5 == delay) {
//            MessagePostProcessor processor = message1 -> {
//                message1.getMessageProperties().setExpiration("4000");
//                message1.getMessageProperties().setContentEncoding("utf-8");
//                return message1;
//            };
//            rabbitTemplate.convertAndSend("dead_letter_exchange", "5s", message, processor, data);
//        } else if (10 == delay) {
//            rabbitTemplate.convertAndSend("dead_letter_exchange", "10s", message, data);
//        }
        MessagePostProcessor processor = message1 -> {
            message1.getMessageProperties().setExpiration(String.valueOf(delay * 1000));
            message1.getMessageProperties().setContentEncoding("utf-8");
            return message1;
        };
        rabbitTemplate.convertAndSend("dead_letter_exchange", "10s", message, processor, data);
        return message;
    }


    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {

    }
}
