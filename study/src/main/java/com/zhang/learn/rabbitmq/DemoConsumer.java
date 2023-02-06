package com.zhang.learn.rabbitmq;


import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/7/17 10:41
 */
@Configuration
public class DemoConsumer {

    @RabbitListener(queues = "queue_demo")
    public void demoConsumer(String message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {
        System.out.println("收到消息:" + message);
//        System.out.println(map);
//        channel.basicAck((Long) map.get("amqp_deliveryTag"), false);+
        channel.basicAck(tag, false);
    }

    @RabbitListener(queues = "queueDelay5s")
    public void queueDelay5sConsumer(String message, Channel channel, @Headers Map<String, Object> map) throws IOException {
        System.out.println("收到消息queueDelay5s:" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "--" + message);
        System.out.println(map);
        channel.basicAck((Long) map.get("amqp_deliveryTag"), false);
    }

    @RabbitListener(queues = "queueDelay10s")
    public void queueDelay10sConsumer(String message, Channel channel, @Headers Map<String, Object> map) throws IOException {
        System.out.println("收到消息queueDelay10s:当前时间" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "--消息为：" + message);
        System.out.println(map);
        channel.basicAck((Long) map.get("amqp_deliveryTag"), false);
    }
}
