package com.zhang.learn.chapter2023.chapter02.chapter0207.shipeiqi;

import lombok.Data;

import java.util.Date;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-07 17:05
 */
@Data
public class RebateInfo {
    private String userId;
    private String bizId;
    private Date bizTime;
    private String desc;
}
