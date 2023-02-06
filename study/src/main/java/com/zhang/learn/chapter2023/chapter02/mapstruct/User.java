package com.zhang.learn.chapter2023.chapter02.mapstruct;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-02 14:20
 */
@Data
@Builder
public class User {
    private Integer id;
    private String name;
    private String address;
    private Date birth;
}
