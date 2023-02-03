package com.zhang.db.http;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/7/30 14:08
 */
public class RestUtil {

    @Test
    public void get() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new CustomErrorHandler());

            ResponseEntity<String> result = restTemplate.getForEntity("http://127.0.0.1:10008/rent/car/front/test/qps", String.class);
            System.out.println(result.getStatusCodeValue());
            System.out.println(result);


    }
}
