package com.zhang.db;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/7/26 17:13
 */
public class CompleteTest {

    @Test
    public void completeTest() throws InterruptedException, ExecutionException {
        List<CompletableFuture<String>> futureList = Lists.newArrayList();
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> {
//            try {
////                TimeUnit.MILLISECONDS.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

            return "";
        });
        futureList.add(f1);

        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return "f2";
        });
        futureList.add(f2);
        CompletableFuture<String> f3 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return "f3";
        });
        futureList.add(f3);
        System.out.println("1-----------" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        CompletableFuture<Object> anyOf = CompletableFuture.anyOf(f1, f2, f3);
        System.out.println("2-----------" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        String result = "";
        try {
            result = (String) anyOf.get(200, TimeUnit.MILLISECONDS);
            System.out.println("3-----------" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        long start = System.currentTimeMillis();
        if (StringUtils.isBlank(result)) {
            for (CompletableFuture<String> future : futureList) {
                long time = System.currentTimeMillis();
                long wait = 200 + start - time;
                System.out.println("wait:" + wait);
                try {
                    if (wait > -200) {
                        result = future.get(200, TimeUnit.MILLISECONDS);
                    } else {
                        result = future.get(1, TimeUnit.MILLISECONDS);
                    }

                    if (StringUtils.isNotBlank(result)) {
                        break;
                    }
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }
            }
        }
        if (StringUtils.isBlank(result)) {
            for (CompletableFuture<String> future : futureList) {
                try {
                    result = future.get(1, TimeUnit.MILLISECONDS);
                    if (StringUtils.isNotBlank(result)) {
                        break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(result);
        System.out.println("到这里了。");
    }
}
