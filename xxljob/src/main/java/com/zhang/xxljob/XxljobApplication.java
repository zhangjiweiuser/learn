package com.zhang.xxljob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.locks.LockSupport;

@SpringBootApplication
public class XxljobApplication {

    public static void main(String[] args) {
        SpringApplication.run(XxljobApplication.class, args);
        LockSupport.park();
    }

}
