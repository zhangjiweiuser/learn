package com.zhang.groovy.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/8/13 16:13
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BusinessException extends RuntimeException {

    private String code;
    private String message;
}
