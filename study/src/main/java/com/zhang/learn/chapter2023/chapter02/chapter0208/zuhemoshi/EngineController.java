package com.zhang.learn.chapter2023.chapter02.chapter0208.zuhemoshi;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-08 9:01
 */
@Slf4j
public class EngineController {
    public String process(String userId, String userSex, int userAge) {
        log.info("if else 实现方式判断用户结果，userId:{},userSex:{},userAge:{}", userId, userSex, userAge);
        if ("man".equals(userSex)) {
            if (userAge < 25) {
                return "果实A";
            }
            return "果实B";
        }
        if ("woman".equals(userSex)) {
            if (userAge < 25) {
                return "果实C";
            }
            return "果实D";
        }
        return null;
    }
}
