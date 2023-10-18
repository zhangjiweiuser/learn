package com.zhang.dubboconsumer.controller;

import com.zhang.dubbointerface.service.HelloService;
import com.zhang.dubbointerface.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/8/3 14:20
 */
@RestController
public class HelloController {
    @Reference
    private UserService userService;
    @Reference
    private HelloService helloService;
    @GetMapping("/user")
    public String getUser(String name) {
        return userService.sayHello(name);
    }

    @GetMapping("/hello")
    public String sayHello(String name) {
        return helloService.sayHello(name);
    }
}
