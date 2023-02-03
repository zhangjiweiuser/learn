package com.zhang.db;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/7/27 14:06
 */
public class RandomTest {

    @Test
    public void random() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            Random random = new Random();
            String code = String.format("%06d", Math.abs(random.nextLong()) % 1000000);
            System.out.println(code);
        }
        System.out.println("耗时:" + (System.currentTimeMillis() - start));
    }

    @Test
    public void threadLocalRandomTest() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            int random = ThreadLocalRandom.current().nextInt(1, 1000000);
            String code = String.format("%06d", random);
            System.out.println(code);
        }
        System.out.println("耗时:" + (System.currentTimeMillis() - start));
    }
}
