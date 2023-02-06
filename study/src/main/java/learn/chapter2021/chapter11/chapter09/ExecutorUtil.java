package learn.chapter2021.chapter11.chapter09;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/11/9 10:50
 */
@Slf4j
public class ExecutorUtil {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        List<CompletableFuture> futures = new ArrayList<>(3);
        List<String> skuList = Lists.newArrayList("86021442732", "86021442732", "86021442732");
        List<CompletableFuture<JSONArray>> futureList = skuList.stream().map(sku -> getSkuResponse(sku)).collect(Collectors.toList());
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0]));
        CompletableFuture<List<JSONArray>> result = allFutures.thenApply(v -> futureList.stream().map(skuFuture -> {
            try {
                return skuFuture.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return new JSONArray();
        }).collect(Collectors.toList()));
        List<JSONArray> res = result.get();
        JSONArray resultJ = new JSONArray();
        for (int i = 0; i < res.size(); i++) {
            resultJ.fluentAddAll(res.get(i));
//            System.out.println(res.get(i).toJSONString());
        }
        System.out.println(resultJ.toJSONString());
        long end = System.currentTimeMillis();
        System.out.println("总耗时:" + (end - start) + "秒");

//        CompletableFuture first = CompletableFuture.runAsync(() -> {
//            try {
//                Thread.sleep(5000);
//                System.out.println("first");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).exceptionally(e -> {
//            e.printStackTrace();
//            return null;
//        });
//        futures.add(first);
//        Long startTime = System.currentTimeMillis();
//        log.info("开始等待所有线程结束，时间：{}", startTime);
//        try {
//            CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
//        } catch (Exception e) {
//            log.error("等待所有线程结束发生异常：", e);
//        } finally {
//            Long endTime = System.currentTimeMillis();
//            log.info("等待结束，时间：{}, 耗时：{}秒", startTime, (endTime - startTime) / 1000);
//            try {
//                log.info(JSONObject.toJSONString(first));
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
    }

    private static CompletableFuture<JSONArray> getSkuResponse(String skuId) {
        CompletableFuture<JSONArray> res = CompletableFuture.supplyAsync(() -> {
            int seconds = ThreadLocalRandom.current().nextInt(5, 10);
            if (seconds > 7) {
                throw new RuntimeException();
            }
            System.out.println("延迟" + seconds + "秒");
            try {
                TimeUnit.SECONDS.sleep(seconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            RestTemplate restTemplate = new RestTemplate();
            String url = "http://coupontest.mall.autohome.com.cn/coupon/getList?skuId={skuId}&platform={platform}&providerId={providerId}";
            Map<String, String> param = new HashMap<>();
            param.put("skuId", skuId);
            param.put("platform", "8");
            param.put("providerId", "0");
            String resStr = restTemplate.getForObject(url, String.class, param);
            log.info("查询优惠券信息返回值:{}", resStr);
            if (StringUtils.isNotBlank(resStr)) {
                JSONObject resJson = JSONObject.parseObject(resStr);
                boolean success = resJson.getBoolean("success");
                if (success) {
                    JSONArray result = resJson.getJSONArray("result");
                    return result;
                }
            }
            return new JSONArray();
        }).exceptionally(e -> {
            System.out.println("进到异常了");
            return new JSONArray();
        });

        return res;
    }
}
