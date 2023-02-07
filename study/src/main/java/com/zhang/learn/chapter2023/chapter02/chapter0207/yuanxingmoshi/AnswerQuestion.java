package com.zhang.learn.chapter2023.chapter02.chapter0207.yuanxingmoshi;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-07 9:48
 */
@Data
@NoArgsConstructor
public class AnswerQuestion {
    private String name;
    private String key;

    public AnswerQuestion(String name, String key) {
        this.name = name;
        this.key = key;
    }
}
