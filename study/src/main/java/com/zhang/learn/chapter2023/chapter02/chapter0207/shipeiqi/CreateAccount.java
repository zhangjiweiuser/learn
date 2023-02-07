package com.zhang.learn.chapter2023.chapter02.chapter0207.shipeiqi;

import lombok.Data;

import java.util.Date;

/**
 * @author zhangjiwei1
 * @description 开户
 * @create 2023-02-07 11:28
 */
@Data
public class CreateAccount {
    /**
     * 开户编码
     */
    private String number;
    /**
     * 开户地
     */
    private String address;
    /**
     * 开户时间
     */
    private Date accountDate;
    /**
     * 开户描述
     */
    private String desc;
}
