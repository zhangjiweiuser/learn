package com.zhang.learn.chapter12.chapter1228;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.QueryTimeoutException;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/12/28 14:20
 */
@Slf4j
@Service
public class RedisDelayQueue {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    private ScheduledExecutorService timer = Executors.newScheduledThreadPool(16);

    private List<String> consumeTopics = new ArrayList<>(64);


    @PostConstruct
    public void init() {
        Set<String> topicList = stringRedisTemplate.opsForSet().members("topicList");
        if (topicList != null) {
            topicList.forEach(this::registerTopic);
        }

    }

    private void registerTopic(String topic) {
        log.info("注册监听topic消息:{}", topic);
        timer.scheduleAtFixedRate(() -> {
            Set<String> msgs = stringRedisTemplate.opsForZSet().rangeByScore(topic, 0, System.currentTimeMillis(), 0, 1000);
            if (msgs != null && msgs.size() > 0) {
                Long remove = stringRedisTemplate.opsForZSet().remove(topic, msgs.toArray());
                //删除结果大于0代表 抢到了
                if( remove != null && remove> 0 ){
                    stringRedisTemplate.opsForList().leftPushAll(topic + "queue", msgs);
                }

            }
        }, 1, 1, TimeUnit.SECONDS);
    }


    public void produce(String topic, String msg, Date date) {
        log.info("topic:{} 生产消息：{},于{}消费", topic, msg, date);
        Long addSuccess = stringRedisTemplate.opsForSet().add("topicList", topic);
        if (addSuccess != null && addSuccess > 0) {
            registerTopic(topic);
        }
        stringRedisTemplate.opsForZSet().add(topic, msg, date.getTime());
    }


    public synchronized void consumer(String topic, Function<String, Boolean> consumer) {
        if (consumeTopics.contains(topic)) {
            throw new RuntimeException("请勿重复监听消费" + topic);
        }
        consumeTopics.add(topic);
        int consumerPoolSize = 10;
        ExecutorService consumerPool = Executors.newFixedThreadPool(consumerPoolSize);
        for (int i = 0; i < consumerPoolSize; i++) {
            consumerPool.submit(() -> {
                do {
                    log.info("循环取消息：{}", topic);
                    String msg;
                    try {
                        msg = stringRedisTemplate.opsForList().rightPop(topic + "queue", 1000, TimeUnit.MINUTES);
                    } catch (QueryTimeoutException e) {
                        log.debug("监听超时，重试中！");
                        continue;
                    }
                    log.info("{}监听到消息：{}", topic, msg);
                    if (msg != null) {
                        Boolean consumerSuccess;
                        try {
                            consumerSuccess = consumer.apply(msg);
                        } catch (Exception e) {
                            log.warn("消费失败！", e);
                            consumerSuccess = false;
                        }
                        //消费失败，1分钟后再重试
                        if (consumerSuccess == null || !consumerSuccess) {
                            log.info("消费失败，重新放回队列。msg:{},topic:{}", msg, topic);
                            produce(topic, msg, new Date(System.currentTimeMillis() + 60000));
                        }
                    }
                } while (true);
            });
        }

    }
}
