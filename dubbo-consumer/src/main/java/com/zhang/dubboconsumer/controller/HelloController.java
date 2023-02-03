package com.zhang.dubboconsumer.controller;

import com.zhang.dubbointerface.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/8/3 14:20
 */
@RestController
public class HelloController {
    @DubboReference
    private UserService userService;

    @GetMapping("/hello")
    public String sayHello(String name) {
        return userService.sayHello(name);
    }
}
