package com.zhang.dubboprovider2.service.impl;


import com.zhang.dubbointerface.service.UserService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/8/3 14:01
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public String sayHello(String name) {
        return "user: " + name;
    }
}
