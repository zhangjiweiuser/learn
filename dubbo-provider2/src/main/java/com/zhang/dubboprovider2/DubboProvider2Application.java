package com.zhang.dubboprovider2;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
public class DubboProvider2Application {

    public static void main(String[] args) {
        SpringApplication.run(DubboProvider2Application.class, args);
    }

}
