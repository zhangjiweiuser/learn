package com.zhang.learn.chapter2023.chapter03.chapter0331;

import java.util.concurrent.TimeUnit;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-03-31 15:11
 */
public class Test {
    public static void main(String[] args) {
        final TimeWheel wheel = new TimeWheel(1,  TimeUnit.SECONDS);
        wheel.createTimeTask(new TimerTask() {
            @Override
            public void run() {
                System.out.println(111);
                wheel.createTimeTask(this, 4, TimeUnit.SECONDS);
            }
        }, 3, TimeUnit.SECONDS);
    }
}
