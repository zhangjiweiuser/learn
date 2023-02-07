package com.zhang.learn.chapter2023.chapter02.chapter0207.yuanxingmoshi;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-07 10:04
 */
@Data
@NoArgsConstructor
public class Topic {
    private Map<String, String> option;
    private String key;

    public Topic(Map<String, String> option, String key) {
        this.option = option;
        this.key = key;
    }
}
