package com.zhang.learn.chapter2023.chapter02.chapter0209.hengyuanmoshi;

import com.alibaba.fastjson2.JSON;

import java.util.concurrent.TimeUnit;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-09 9:31
 */
public class ApiTest {
    public static void main(String[] args) throws InterruptedException {
        ActivityController controller = new ActivityController();
        for (int i = 0; i < 10; i++) {
            Activity activity = controller.queryActivityInfo2(10L);
            System.out.println(JSON.toJSONString(activity));
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
