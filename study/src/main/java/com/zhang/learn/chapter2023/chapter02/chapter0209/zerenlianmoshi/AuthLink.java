package com.zhang.learn.chapter2023.chapter02.chapter0209.zerenlianmoshi;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-09 10:08
 */
@Slf4j
public abstract class AuthLink {
    protected DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    protected String levelUserId;
    protected String levelUserName;
    private AuthLink next;

    public AuthLink(String levelUserId, String levelUserName) {
        this.levelUserId = levelUserId;
        this.levelUserName = levelUserName;
    }

    public AuthLink next() {
        return next;
    }

    public AuthLink appendNext(AuthLink next) {
        this.next = next;
        return this;
    }

    public abstract AuthInfo doAuth(String uid, String orderId, LocalDateTime authDate);
}
