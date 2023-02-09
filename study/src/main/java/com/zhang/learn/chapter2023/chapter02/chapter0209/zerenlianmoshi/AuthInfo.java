package com.zhang.learn.chapter2023.chapter02.chapter0209.zerenlianmoshi;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-09 9:57
 */
@Data
@NoArgsConstructor
public class AuthInfo {
    private String code;
    private String info;

    public AuthInfo(String code, String info) {
        this.code = code;
        this.info = info;
    }
}
