package com.zhang.learn.chapter2023.chapter02.chapter0209.zerenlianmoshi;

import com.alibaba.fastjson2.JSON;
import com.zhang.learn.chapter2023.chapter02.chapter0209.zerenlianmoshi.cuisine.impl.Level1AuthLink;
import com.zhang.learn.chapter2023.chapter02.chapter0209.zerenlianmoshi.cuisine.impl.Level2AuthLink;
import com.zhang.learn.chapter2023.chapter02.chapter0209.zerenlianmoshi.cuisine.impl.Level3AuthLink;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-09 11:05
 */
@Slf4j
public class ApiTest {
    public static void main(String[] args) {
        AuthLink authLink = new Level3AuthLink("1000013", "王工")
                .appendNext(new Level2AuthLink("1000012", "张经理")
                        .appendNext(new Level1AuthLink("1000011", "段总")));

        log.info("测试结果：{}", JSON.toJSONString(authLink.doAuth("小傅哥", "1000998004813441", LocalDateTime.now())));

        // 模拟三级负责人审批
        AuthService.auth("1000013", "1000998004813441");
        log.info("测试结果：{}", "模拟三级负责人审批，王工");
        log.info("测试结果：{}", JSON.toJSONString(authLink.doAuth("小傅哥", "1000998004813441", LocalDateTime.now())));

        // 模拟二级负责人审批
        AuthService.auth("1000012", "1000998004813441");
        log.info("测试结果：{}", "模拟二级负责人审批，张经理");
        log.info("测试结果：{}", JSON.toJSONString(authLink.doAuth("小傅哥", "1000998004813441", LocalDateTime.now())));

        // 模拟一级负责人审批
        AuthService.auth("1000011", "1000998004813441");
        log.info("测试结果：{}", "模拟一级负责人审批，段总");
        log.info("测试结果：{}", JSON.toJSONString(authLink.doAuth("小傅哥", "1000998004813441", LocalDateTime.now())));

    }
}
