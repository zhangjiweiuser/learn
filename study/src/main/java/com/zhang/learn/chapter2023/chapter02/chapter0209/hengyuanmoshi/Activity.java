package com.zhang.learn.chapter2023.chapter02.chapter0209.hengyuanmoshi;

import lombok.Data;

import java.util.Date;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-09 9:20
 */
@Data
public class Activity {
    private Long id;
    private String name;
    private String desc;
    private Date startTime;
    private Date stopTime;
    private Stock stock;
}
