package com.zhang.learn.chapter2023.chapter02.chapter0208.zuhemoshi;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-08 9:11
 */
@Slf4j
public class ApiTest {
    public static void main(String[] args) {
        ifElse();
    }

    private static void ifElse() {
        EngineController engineController = new EngineController();
        String process = engineController.process("Oli09pLkdjh", "man", 29);
        log.info("测试结果：{}", process);
    }
}
