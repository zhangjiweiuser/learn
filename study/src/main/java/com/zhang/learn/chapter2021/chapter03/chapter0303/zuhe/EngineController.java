package com.zhang.learn.chapter2021.chapter03.chapter0303.zuhe;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/3/3 11:22
 */
@Slf4j
public class EngineController {


    public String process(final String userId, final String userSex, final
    int userAge) {
        log.info("ifelse实现⽅方式判断⽤用户结果。 userId： {} userSex： {} userAge：{}", userId, userSex, userAge);
        if ("man".equals(userSex)) {
            if (userAge < 25) {
                return "果实A";
            }
            if (userAge >= 25) {
                return "果实B";
            }
        }
        if ("woman".equals(userSex)) {
            if (userAge < 25) {
                return "果实C";
            }
            if (userAge >= 25) {
                return "果实D";
            }
        }
        return null;
    }
}

