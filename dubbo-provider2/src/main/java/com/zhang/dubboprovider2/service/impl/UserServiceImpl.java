package com.zhang.dubboprovider2.service.impl;


import com.zhang.dubbointerface.service.UserService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/8/3 14:01
 */
@DubboService(interfaceClass = UserService.class)
public class UserServiceImpl implements UserService {
    @Override
    public String sayHello(String name) {
        return "hello: " + name;
    }
}
