package com.zhang.learn.chapter2023.chapter05.chapter0509;

import com.github.dozermapper.core.Mapping;
import lombok.Data;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-05-09 15:52
 */
@Data
public class User {
    @Mapping("pk")
    private int id;
    @Mapping("username")
    private String name;
    private int age;
}
