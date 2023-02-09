package com.zhang.learn.chapter2023.chapter02.chapter0209.zerenlianmoshi;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-09 9:54
 */
public class AuthController {
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public AuthInfo doAuth(String uid, String orderId, LocalDateTime authDate) {
        LocalDateTime localDateTime = AuthService.queryAuthInfo("1000013", orderId);
        if (null == localDateTime) {
            return new AuthInfo("0001", "单号:" + orderId + " 状态：待三级审批负责人 王工");
        }
        if (authDate.isAfter(LocalDateTime.parse("2023-06-01 00:00:00", formatter)) &&
                authDate.isBefore(LocalDateTime.parse("2023-06-25 23:59:59", formatter))) {
            localDateTime = AuthService.queryAuthInfo("1000012", orderId);
            if (null == localDateTime) {
                return new AuthInfo("0001", "单号:" + orderId + " 状态：待二级审批负责人 张经理");
            }
        }
        if (authDate.isAfter(LocalDateTime.parse("2023-06-11 00:00:00", formatter)) &&
                authDate.isBefore(LocalDateTime.parse("2023-06-20 23:59:59", formatter))) {
            localDateTime = AuthService.queryAuthInfo("1000011", orderId);
            if (null == localDateTime) {
                return new AuthInfo("0001", "单号:" + orderId + " 状态：待一级审批负责人 张总");
            }
        }
        return new AuthInfo("0001", "单号:" + orderId + " 状态：审批完成");
    }
}
