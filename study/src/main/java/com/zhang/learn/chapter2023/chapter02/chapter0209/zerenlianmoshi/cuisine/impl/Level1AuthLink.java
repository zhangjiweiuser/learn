package com.zhang.learn.chapter2023.chapter02.chapter0209.zerenlianmoshi.cuisine.impl;

import com.zhang.learn.chapter2023.chapter02.chapter0209.zerenlianmoshi.AuthInfo;
import com.zhang.learn.chapter2023.chapter02.chapter0209.zerenlianmoshi.AuthLink;
import com.zhang.learn.chapter2023.chapter02.chapter0209.zerenlianmoshi.AuthService;

import java.time.LocalDateTime;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-09 10:13
 */
public class Level1AuthLink extends AuthLink {

    public Level1AuthLink(String levelUserId, String levelUserName) {
        super(levelUserId, levelUserName);
    }

    @Override
    public AuthInfo doAuth(String uid, String orderId, LocalDateTime authDate) {
        LocalDateTime localDateTime = AuthService.queryAuthInfo(uid, orderId);
        if (null == localDateTime) {
            return new AuthInfo("0001", "单号：" + orderId + " 状态：待一级审批负责人 " + levelUserName);
        }
        AuthLink next = super.next();
        if (null == next) {
            return new AuthInfo("0000", "单号: " + orderId + " 状态：一级审批完成负责人，时间" + localDateTime + " 审批人 " + levelUserName);
        }
        return next.doAuth(uid, orderId, authDate);
    }
}
