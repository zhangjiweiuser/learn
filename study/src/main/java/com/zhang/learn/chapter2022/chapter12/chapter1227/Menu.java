package com.zhang.learn.chapter2022.chapter12.chapter1227;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author zhangjiwei1
 * @description
 * @create 2022-12-27 16:41
 */
@Data
@AllArgsConstructor
public class Menu {
    private Integer id;
    private Integer pid;
    private String name;
    private List<Menu> child;
}
