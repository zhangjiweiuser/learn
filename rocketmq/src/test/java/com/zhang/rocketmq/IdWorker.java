package com.zhang.rocketmq;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/8/9 14:21
 */
public class IdWorker {
    private static final Logger log = LoggerFactory.getLogger(IdWorker.class);
    //下面两个每个5位，加起来就是10位的工作机器id
    private long workerId;    //工作id
    private long datacenterId;   //数据id
    //12位的序列号
    private long sequence;

    private Random random = new Random();

    private static IdWorker singleton = new IdWorker();

    private IdWorker(){
        this.workerId = 31;
        this.datacenterId = 6;
        this.sequence = 0;
        // sanity check for workerId
        if (workerId > maxWorkerId || workerId < 0) {
            log.error("worker Id can't be greater than {} or less than 0", maxWorkerId);
        }
        if (datacenterId > maxDatacenterId || datacenterId < 0) {
            log.error("datacenter Id can't be greater than {} or less than 0",maxDatacenterId);
        }
        log.info("worker starting. timestamp left shift {}, datacenter id bits {}, worker id bits {}, sequence bits {}, workerid {}",
                timestampLeftShift, datacenterIdBits, workerIdBits, sequenceBits, workerId);

//        this.workerId = workerId;
//        this.datacenterId = datacenterId;
//        this.sequence = sequence;
    }

    //初始时间戳
    private final long twepoch = 1288834974657L;

    //长度为5位
    private final long workerIdBits = 5L;
    private final long datacenterIdBits = 5L;
    //最大值
    private final long maxWorkerId = -1L ^ (-1L << workerIdBits);
    private final long maxDatacenterId = -1L ^ (-1L << datacenterIdBits);
    //序列号id长度
    private final long sequenceBits = 12L;
    //序列号最大值
    private final long sequenceMask = -1L ^ (-1L << sequenceBits);

    //工作id需要左移的位数，12位
    private final long workerIdShift = sequenceBits;
    //数据id需要左移位数 12+5=17位
    private final long datacenterIdShift = sequenceBits + workerIdBits;
    //时间戳需要左移位数 12+5+5=22位
    private final long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;

    //上次时间戳，初始值为负数
    private long lastTimestamp = -1L;

    public long getTimestamp(){
        return System.currentTimeMillis();
    }

    //下一个ID生成算法
    public synchronized long nextId() {
        long timestamp = timeGen();

        //获取当前时间戳如果小于上次时间戳，则表示时间戳获取出现异常
        if (timestamp < lastTimestamp) {
            log.error("clock is moving backwards. Rejecting requests until {}.", lastTimestamp);
            log.error("Clock moved backwards.  Refusing to generate id for {} milliseconds", lastTimestamp - timestamp);
        }

        //获取当前时间戳如果等于上次时间戳（同一毫秒内），则在序列号加一；否则序列号赋值为0，从0开始。
        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0;
        }

        //将上次时间戳值刷新
        lastTimestamp = timestamp;

        /**
         * 返回结果：
         * (timestamp - twepoch) << timestampLeftShift) 表示将时间戳减去初始时间戳，再左移相应位数
         * (datacenterId << datacenterIdShift) 表示将数据id左移相应位数
         * (workerId << workerIdShift) 表示将工作id左移相应位数
         * | 是按位或运算符，例如：x | y，只有当x，y都为0的时候结果才为0，其它情况结果都为1。
         * 因为个部分只有相应位上的值有意义，其它位上都是0，所以将各部分的值进行 | 运算就能得到最终拼接好的id
         */
        return ((timestamp - twepoch) << timestampLeftShift) |
                (datacenterId << datacenterIdShift) |
                (workerId << workerIdShift) |
                sequence;
    }

    public String getNextId() {
        long nextId = nextId();
        String nextIdStr = String.valueOf(nextId);
        return StringUtils.substring(nextIdStr, 9);
    }

    //获取时间戳，并与上次时间戳比较
    private long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    //获取系统时间戳
    private long timeGen(){
//        System.out.println("时间戳:"+System.currentTimeMillis());
//        return System.currentTimeMillis();
//        LocalDateTime time = LocalDateTime.ofInstant(Instant.ofEpochMilli(1628490399300L), ZoneId.of("+8"));
//        LocalDateTime time2 = time.plusNanos(2441406000000L);
//        return time2.toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
//        return 1628490399300L;
//        return 1628492840706L;
//        return 1628490401348L;
//        return 1628490401685L;
        return 1628490404069L;

    }

    public static IdWorker getIdWorker() {
        return singleton;
    }
}
