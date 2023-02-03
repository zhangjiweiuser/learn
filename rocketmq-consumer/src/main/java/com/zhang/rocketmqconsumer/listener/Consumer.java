package com.zhang.rocketmqconsumer.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/8/3 10:38
 */
@Slf4j
@Component
@RocketMQMessageListener(topic = "springboot-rocketmq",consumerGroup = "${rocketmq.consumer.group}")
public class Consumer implements RocketMQListener<String> {
    @Override
    public void onMessage(String s) {
        log.info("接收到消息:{}", s);
    }
}
