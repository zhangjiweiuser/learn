package com.zhang.learn.config;

import com.zhang.learn.constant.RabbitMQConstant;
import com.zhang.learn.rabbitmq.CorrelationDataExt;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/7/17 10:19
 */
@Configuration
public class RabbitMQConfig {


    @Bean
    public Exchange demoExchange() {
        return ExchangeBuilder.directExchange(RabbitMQConstant.EXCHANGE_NAME).durable(true).build();
    }

    @Bean
    public Queue demoQueue() {
        return QueueBuilder.durable(RabbitMQConstant.QUEUE_NAME).build();
    }

    @Bean
    public Binding demoBinding() {
        return BindingBuilder.bind(demoQueue()).to(demoExchange()).with(RabbitMQConstant.ROUTING_KEY).noargs();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean b, String s) {
                if (b) {
                    System.out.println("消息发送成功");
                } else {

                    if (correlationData instanceof CorrelationDataExt) {
                        CorrelationDataExt data = (CorrelationDataExt) correlationData;
                        System.out.println("增强回调结果correlationData:" + data + ",b=" + b + ",s=" + s);
                    } else {
                        System.out.println("未增强回调结果correlationData:" + correlationData + ",b=" + b + ",s=" + s);
                    }
                }
            }
        });
        rabbitTemplate.setMandatory(true);
        return rabbitTemplate;
    }

    @Bean
    public Exchange deadLetterExchange() {
        return ExchangeBuilder.directExchange("dead_letter_exchange").durable(true).build();
    }

    @Bean
    public Queue queue5s() {
        return QueueBuilder.durable("queue5s").deadLetterExchange("dead_letter_exchange")
                .deadLetterRoutingKey("dlx1")
                .ttl(5000)
                .build();
    }

    @Bean
    public Binding queue5sBinding() {
        return new Binding("queue5s", Binding.DestinationType.QUEUE, "dead_letter_exchange", "5s", null);
    }

    @Bean
    public Queue queueDelay5s() {
        return QueueBuilder.durable("queueDelay5s").build();
    }

    @Bean
    public Binding queueDelay5sBinding() {
        return new Binding("queueDelay5s", Binding.DestinationType.QUEUE, "dead_letter_exchange", "dlx1", null);
    }

    @Bean
    public Queue queue10s() {
        return QueueBuilder.durable("queue10s").deadLetterExchange("dead_letter_exchange")
                .deadLetterRoutingKey("dlx2")
                .ttl(1000000)
                .build();
    }

    @Bean
    public Binding queue10sBinding() {
        return new Binding("queue10s", Binding.DestinationType.QUEUE, "dead_letter_exchange", "10s", null);
    }

    @Bean
    public Queue queueDelay10s() {
        return QueueBuilder.durable("queueDelay10s").build();
    }

    @Bean
    public Binding queueDelay10sBinding() {
        return new Binding("queueDelay10s", Binding.DestinationType.QUEUE, "dead_letter_exchange", "dlx2", null);
    }


}
