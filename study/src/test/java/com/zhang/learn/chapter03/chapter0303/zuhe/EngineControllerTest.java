package com.zhang.learn.chapter03.chapter0303.zuhe;

import com.zhang.learn.chapter2021.chapter03.chapter0303.zuhe.EngineController;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/3/3 11:24
 */
@Slf4j
public class EngineControllerTest {
    @Test
    void engineControllerTest() {
        EngineController engineController = new EngineController();
        String process = engineController.process("111", "man", 29);
        log.info("测试结果{}:{}", "111", process);
    }
}
