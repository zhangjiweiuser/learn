package com.zhang.learn.chapter2021.chapter12.chapter1214;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/12/14 11:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class A {

    private Integer id;
    private String name;
    private C c;
}
