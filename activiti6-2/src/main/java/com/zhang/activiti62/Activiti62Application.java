package com.zhang.activiti62;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class Activiti62Application {

    public static void main(String[] args) {
        SpringApplication.run(Activiti62Application.class, args);
    }

}
