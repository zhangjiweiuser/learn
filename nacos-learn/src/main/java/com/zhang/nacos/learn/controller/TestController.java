package com.zhang.nacos.learn.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RefreshScope
@Slf4j
public class TestController {
//    @Value("${jdbc.name}")
//    private String jdbcName;
//    @Value("${redis.username}")
//    private String redisname;
//    @Value("${mysql.password}")
//    private String dbpwd;
//    @Value("#{T(com.zhang.nacos.learn.util.MapDecoder).decodeMap(${mysql.params})}")
//    private Map<String,String> params;

    @Value("#{T(com.zhang.nacos.learn.util.MapDecoder).decodeMap('${mysql.params}')}")
    private Map<String,String> params;
//    @GetMapping("/test")
//    public String test(){
//        log.info("test:{}",jdbcName);
//        return jdbcName;
//    }
//    @GetMapping("/testredis")
//    public String testredis(){
//        return redisname;
//    }
//    @GetMapping("/testdb")
//    public String testdb(){
//        return dbpwd;
//    }
    @GetMapping("/testmap")
    public Map<String,String> testmap(){
        return params;
    }


}
