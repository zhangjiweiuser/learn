package com.zhang.learn.controller;

import com.zhang.learn.annotation.NoRepeatSubmit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/7/17 10:35
 */
@RestController
public class AopController {

    @NoRepeatSubmit
    @GetMapping("/aop")
    public String setMessage() {

        return "aaa";
    }

}
