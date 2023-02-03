package com.zhang.rocketmq;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/8/9 11:26
 */
public class LeftMove {

    @Test
    void test() {
        System.out.println(1 << 5);
        System.out.println(1 << 12);
        System.out.println((long) 1 << 41);
        System.out.println(System.currentTimeMillis());
        System.out.println(Long.toBinaryString(3564640256L));
        System.out.println(Long.toBinaryString(1424572103564640256L));
        System.out.println(86400 * 4096);
        System.out.println(10000000000L / 4096);
        System.out.println(10000000000L % 4096);


        LocalDateTime time1 = LocalDateTime.of(2021, 8, 9, 14, 0, 0, 0);
        System.out.println(time1.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        LocalDateTime time2 = time1.plusNanos(2441406000000L);
        System.out.println(time2.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

    @Test
    void idWorkerTest() throws InterruptedException {
        // 时间戳:1628490399300
        //6206162944
        //6201968640
        IdWorker worker = IdWorker.getIdWorker();
//        System.out.println(worker.getNextId());
//        LocalDateTime time = LocalDateTime.ofInstant(Instant.ofEpochMilli(1628490399300L), ZoneId.of("+8"));
//
//        System.out.println(time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
//        LocalDateTime time2 = time.plusNanos(2441406000000L);
//        System.out.println(time2.toInstant(ZoneOffset.ofHours(8)).toEpochMilli());

        ThreadPoolExecutor executor = new ThreadPoolExecutor(8, 8, 5, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1000));

        for (int i = 0; i < 8; i++) {
            executor.execute(() -> {
                for (int j = 0; j < 512; j++) {
                    System.out.println(worker.getNextId());
                }
            });
        }
        TimeUnit.SECONDS.sleep(2);
        executor.shutdown();
    }
    @Test
    void test3(){
        LocalDateTime time = LocalDateTime.ofInstant(Instant.ofEpochMilli(1628490399300L), ZoneId.of("+8"));
        LocalDateTime time2 = time.plusNanos(2441406000000L);
        System.out.println(1628490399300L);
        System.out.println(1628490399300L+2048);
        System.out.println(1628490399300L+2048);
        System.out.println(time2.toInstant(ZoneOffset.ofHours(8)).toEpochMilli());
        System.out.println(1<<10);
    }
    @Test
    void test4(){
//        System.out.println(1<<22);//4194304
//        System.out.println(10000000000L/4194304); // 2384
//        System.out.println(10000000000L%4194304); //779264
//        System.out.println(1628490399300L+2384);
//        System.out.println(6201968640L-6201189376L);
//        System.out.println(1<<17);//131072
//        System.out.println(1<<12);//4096
//        System.out.println(779264/131072);//5
//        System.out.println(779264%131072);//123904
//        System.out.println(123904/4096);//30
//        System.out.println(123904%4096);//1024
//        System.out.println(1628490401685L+2384);//1628490404069L

        System.out.println(20000000000L/4194304); // 2384
        System.out.println(20000000000L%4194304); //779264

        long twepoch = 1288834974657L;
        System.out.println(((1628490404069L - twepoch) << 22) | (6 << 17) | (31 << 12) | 1025);
        System.out.println(((1628490401685L - twepoch) << 22) | (1 << 17) | (1 << 12) | 1);

        System.out.println(((1628490406453L - twepoch) << 22) | (12 << 17) | (29 << 12) | 2049);
        System.out.println(((1628490401685L - twepoch) << 22) | (1 << 17) | (1 << 12) | 1);

        System.out.println(((1628490404069L - twepoch) << 22) | (7 << 17) | (31 << 12) | 1025);
        System.out.println(((1628490401685L - twepoch) << 22) | (2 << 17) | (1 << 12) | 1);

    }
}
