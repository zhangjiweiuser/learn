package com.zhang.dubboprovider2.service.impl;

import com.zhang.dubbointerface.service.HelloService;
import org.apache.dubbo.config.annotation.Service;

@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return "hello:"+name;
    }
}
