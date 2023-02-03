package com.zhang.learn.controller;

import com.zhang.learn.rabbitmq.DemoSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/7/17 10:35
 */
@RestController
public class DemoController {
    @Autowired
    private DemoSender demoSender;

    @GetMapping("/setMessage")
    public String setMessage(String message) {

        return demoSender.send(message);
    }

    @GetMapping("/setDelayMessage")
    public String setDelayMessage(String message, int delay) {
        return demoSender.sendDelay(message, delay);
    }
}
