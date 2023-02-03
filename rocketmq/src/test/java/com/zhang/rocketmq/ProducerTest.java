package com.zhang.rocketmq;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/8/3 10:29
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = RocketmqApplication.class)
public class ProducerTest {
    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Test
    void send() {
        rocketMQTemplate.convertAndSend("springboot-rocketmq", "Hello springboot2");
    }
}
