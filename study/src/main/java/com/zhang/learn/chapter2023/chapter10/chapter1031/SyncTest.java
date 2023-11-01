package com.zhang.learn.chapter2023.chapter10.chapter1031;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SyncTest {
    final Integer integer = new Integer(1);

    public String getString() {
        synchronized (integer) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "111";
        }
    }

    public static void main(String[] args) {
        SyncTest test = new SyncTest();
        for (int i = 0; i < 5; i++) {

            new Thread(() -> {
                System.out.println(test.getString() + "--" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            }).start();
        }
    }
}
