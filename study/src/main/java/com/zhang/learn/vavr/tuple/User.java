package com.zhang.learn.vavr.tuple;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-04-11 10:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String name;
    private Integer age;
}
