package com.zhang.rocketmq.controller;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.security.MessageDigest;
import java.util.*;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/8/9 9:57
 */
@Slf4j
@RestController
public class CityController {

    private static final String channel = "1c8a47c155a76d49";
    private static final String signKey = "c94dcf28f03d8b6fedd3285d5bd66c6f";
    private static final String SIGN_KEY = "sign_key";

    @GetMapping("/getCity")
    public String getCity() {
        return getCities();
    }

    @GetMapping("/v2/common/getAllCities")
    public String getCitite(@RequestParam Map<String, Object> param) {
        log.info("入参：" + param.toString());
        return "{\"code\":200,\"data\":{\"cities\":[{\"luxurious\":1,\"commercial\":1," +
                "\"cityName\":\"北京\",\"economic_business\":0,\"cityCode\":\"010\"," +
                "\"comfortable\":1,\"newEnergy\":1,\"taxi\":0,\"choiceness\":0}," +
                "{\"luxurious\":0,\"commercial\":0,\"cityName\":\"天津\",\"economic_business\":0," +
                "\"cityCode\":\"022\",\"comfortable\":0,\"newEnergy\":1,\"taxi\":0,\"choiceness\":0}" + "" +
                "]},\"success\":true}";
    }

    public String getCities() {
        Map<String, Object> paramMap = Maps.newHashMap();
        paramMap.put("client_id", channel);
        paramMap.put("timestamp", System.currentTimeMillis());
        String sign = sign(paramMap, signKey);
        paramMap.put("sign", sign);
        paramMap.remove("sign_key");
        log.info("caocao getCities paramMap:{}", paramMap);
        // domain: https://sandbox-cop.caocaokeji.cn
        //  estimatePrice: /v2/common/estimatePriceWithDetail
        //  getOpenCityList: /v2/common/getAllCities

        RestTemplate template = new RestTemplate();

        // c
        //        .queryParam("msisdn", msisdn)
        //        .queryParam("sex", "男")
        //        .queryParam("national", "中国")
        //        .queryParam("birthday", "199002190");
        //————————————————
        //版权声明：本文为CSDN博主「wokenshin」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
        //原文链接：https://blog.csdn.net/wokenshin/article/details/80971115


        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://sandbox-cop.caocaokeji.cn:8085/v2/common/getAllCities");
        for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
            builder.queryParam(entry.getKey(), entry.getValue());
        }
        log.info("请求url:{}",builder.toUriString());
        log.info("请求url2:{}",builder.toString());
        log.info("请求url3:{}",builder.build().encode().toUri());
        String result = template.getForObject(builder.toUriString(), String.class);

//        String result = HttpRequestProxy.doGet(, paramMap);

        log.info("caocao getCities result:{}", result);
        return result;


    }

    public static String sign(Map<String, Object> params, String signKey) {
        params.put(SIGN_KEY, signKey);
        Map<String, String> needVerify = new HashMap<>();
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            needVerify.put(entry.getKey(), String.valueOf(entry.getValue()));
        }
        List<Map.Entry<String, String>> entryList = new ArrayList<>(needVerify.entrySet());
        //排序
        entryList.sort(Comparator.comparing(Map.Entry::getKey));
        StringBuilder buffer = new StringBuilder();
        for (Map.Entry<String, String> entry : entryList) {
            buffer.append(entry.getKey()).append(entry.getValue());
        }
        log.info("sha1 签名参数:{}", buffer.toString());
        String sha = getSha1(buffer.toString());
        params.remove(SIGN_KEY);
        return sha;
    }

    public static String getSha1(String str) {
        if (null == str || 0 == str.length()) {
            return null;
        }
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
            mdTemp.update(str.getBytes("UTF-8"));

            byte[] md = mdTemp.digest();
            int j = md.length;
            char[] buf = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
                buf[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(buf);
        } catch (Exception e) {
            return null;
        }
    }
}
