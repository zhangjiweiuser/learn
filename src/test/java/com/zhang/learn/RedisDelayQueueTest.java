package com.zhang.learn;

import com.zhang.learn.chapter12.chapter1228.RedisDelayQueue;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/12/28 14:22
 */
@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RedisDelayQueueTest {
    @Resource
    private RedisDelayQueue redisDelayQueue;

    @Test
    public void produce() {
        for (int i = 0; i < 30; i++) {
            redisDelayQueue.produce("topic" + i % 3, "hello message" + i, new Date(System.currentTimeMillis() + i * 1000));
        }
    }

    @Test
    public void consumer() throws InterruptedException {

        redisDelayQueue.consumer("topic0", (msg) -> {
            log.info("topic【{}】收到消息：{}", "topic0", msg);
            return true;
        });
        redisDelayQueue.consumer("topic1", (msg) -> {
            log.info("topic【{}】收到消息：{}", "topic1", msg);
            return true;
        });
        redisDelayQueue.consumer("topic2", (msg) -> {
            log.info("topic【{}】收到消息：{}", "topic2", msg);
            return true;
        });


        TimeUnit.MINUTES.sleep(10);
    }
}
