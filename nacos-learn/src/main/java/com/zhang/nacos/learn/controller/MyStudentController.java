package com.zhang.nacos.learn.controller;

import com.zhang.nacos.learn.config.MyStudentProperties;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyStudentController {
    @Resource
    private MyStudentProperties myStudentProperties;

    @GetMapping("/getName")
    public String getName(){
        return myStudentProperties.getName();
    }
}
