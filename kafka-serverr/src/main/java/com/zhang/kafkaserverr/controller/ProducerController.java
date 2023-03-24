package com.zhang.kafkaserverr.controller;

import com.alibaba.fastjson2.JSON;
import com.zhang.kafkaserverr.entity.User;
import org.apache.kafka.common.message.ProduceRequestData;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-03-23 15:02
 */
@RestController
public class ProducerController {
    @Resource
    KafkaTemplate<String, String> kafkaTemplate;

    @RequestMapping("/register")
    public String register(User user) {
        String message = JSON.toJSONString(user);
        System.out.println("接收到用户消息:" + message);
        kafkaTemplate.send("usertopic", message);
        ProduceRequestData data = new ProduceRequestData();

        return "ok";
    }
}
