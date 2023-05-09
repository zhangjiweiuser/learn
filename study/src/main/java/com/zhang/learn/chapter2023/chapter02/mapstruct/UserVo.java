package com.zhang.learn.chapter2023.chapter02.mapstruct;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-02 14:21
 */
@Data
public class UserVo implements Serializable {
    private Integer id;
    private String name;
    private String sex;
    private String city;
}
