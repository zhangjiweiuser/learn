package com.zhang.nacos.learn.service;


import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@RefreshScope
public class UserServiceImpl implements UserService {

    @Value(value = "${aa.name}")
    private String name;

    @Override
    public String getKey() {
        return name;
    }
}
