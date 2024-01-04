package com.zhang.nacos.learn.controller;

import com.zhang.nacos.learn.config.MyStudentProperties;
import com.zhang.nacos.learn.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyStudentController2 {
    @Resource
    private UserService userService;

    @GetMapping("/getName2")
    public String getName() {
        return userService.getKey();
    }
}
