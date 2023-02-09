package com.zhang.learn.chapter2023.chapter02.chapter0209.zerenlianmoshi.cuisine.impl;

import com.zhang.learn.chapter2023.chapter02.chapter0209.zerenlianmoshi.AuthInfo;
import com.zhang.learn.chapter2023.chapter02.chapter0209.zerenlianmoshi.AuthLink;
import com.zhang.learn.chapter2023.chapter02.chapter0209.zerenlianmoshi.AuthService;

import java.time.LocalDateTime;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-09 10:59
 */
public class Level2AuthLink extends AuthLink {

    private LocalDateTime begin = LocalDateTime.parse("2023-06-11 00:00:00", formatter);
    private LocalDateTime end = LocalDateTime.parse("2023-06-20 23:59:59", formatter);

    public Level2AuthLink(String levelUserId, String levelUserName) {
        super(levelUserId, levelUserName);
    }

    @Override
    public AuthInfo doAuth(String uid, String orderId, LocalDateTime authDate) {
        LocalDateTime localDateTime = AuthService.queryAuthInfo(uid, orderId);
        if (null == localDateTime) {
            return new AuthInfo("0001", "单号：" + orderId + " 状态：待二级审批负责人 " + levelUserName);
        }
        AuthLink next = super.next();
        if (null == next) {
            return new AuthInfo("0000", "单号: " + orderId + " 状态：二级审批完成负责人，时间" + localDateTime + " 审批人 " + levelUserName);
        }
        if(authDate.isBefore(begin) || authDate.isAfter(end)){
            return new AuthInfo("0000", "单号: " + orderId + " 状态：二级审批完成负责人，时间" + localDateTime + " 审批人 " + levelUserName);
        }
        return next.doAuth(uid, orderId, authDate);
    }
}
