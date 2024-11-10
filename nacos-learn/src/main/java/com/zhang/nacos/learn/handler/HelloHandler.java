package com.zhang.nacos.learn.handler;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Component
public class HelloHandler {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
    }
    @Resource
    private CustomProperties customProperties;

//    @Value("${print.paused:false}")
//    private volatile boolean paused;

    @Data
    @Component
    @RefreshScope
    public static class CustomProperties {

        @Value("${print.paused:1}")
        private String paused;
    }

    @PostConstruct
    public void post() {

        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(1);
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("paused:" + customProperties.getPaused());
            }
        },1,1,TimeUnit.SECONDS);
    }

//    private void hello {
//        while (true) {
//            System.out.println("paused:" + customProperties.isPaused());
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//
//            }
//        }
//    }
}
