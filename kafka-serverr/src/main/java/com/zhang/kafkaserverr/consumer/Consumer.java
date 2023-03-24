package com.zhang.kafkaserverr.consumer;

import com.alibaba.fastjson2.JSON;
import com.zhang.kafkaserverr.entity.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-03-23 15:06
 */
@Configuration
public class Consumer {
    @KafkaListener(topics = "usertopic")
    public void consume(String message){
        System.out.println("接收到消息:"+message);
        User user = JSON.parseObject(message, User.class);
        System.out.println("正在为:"+user.getName()+" 办理注册业务。。。");
        System.out.println("注册成功");
    }
}
