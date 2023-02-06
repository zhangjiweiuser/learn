package com.zhang.learn.shiro;

import lombok.Data;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/8/20 14:28
 */
@Data
public class RespEntity<T> {

    private int httpCode;
    private T data;
    private String message;
}
