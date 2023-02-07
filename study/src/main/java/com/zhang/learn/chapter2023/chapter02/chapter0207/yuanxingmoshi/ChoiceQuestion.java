package com.zhang.learn.chapter2023.chapter02.chapter0207.yuanxingmoshi;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-07 9:49
 */
@Data
@NoArgsConstructor
public class ChoiceQuestion {
    private String name;
    private Map<String, String> option;
    private String key;

    public ChoiceQuestion(String name, Map<String, String> option, String key) {
        this.name = name;
        this.option = option;
        this.key = key;
    }
}
