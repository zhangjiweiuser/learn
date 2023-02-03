package com.zhang.learn;

import com.alibaba.fastjson2.JSONObject;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/12/29 16:17
 */
@Slf4j
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class GetPostRestTemplateTest {

    private RestTemplate restTemplate;

    @BeforeAll
    public void init() {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(30000);// 设置连接超时，单位毫秒
        requestFactory.setReadTimeout(30000);  //设置读取超时
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(requestFactory);
        log.info("RestTemplate初始化完成");
        this.restTemplate = restTemplate;
    }

    @Test
    public void getUserTest() {
        String url = "http://127.0.0.1:8082/getUser";
        Map<String,Integer> map = Maps.newHashMap();
        map.put("id",20);
        String result = getObject(url, map);
        log.info("result:{}", result);
    }

    @Test
    public void getUser2Test() {
        String url = "http://127.0.0.1:8082/getUser2";
        Map<String,Integer> map = Maps.newHashMap();
        map.put("id",22);
        String result = getObject(url, map);
        log.info("result:{}", result);

    }

    @Test
    public void postUserTest() {
        String url = "http://127.0.0.1:8082/postUser";
        MultiValueMap<String,Object> map = new LinkedMultiValueMap<>();
        map.add("id",23);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        HttpEntity<MultiValueMap<String,Object>> request = new HttpEntity<>(map,headers);

        String result = restTemplate.postForObject(url,request,String.class);
        log.info("result:{}", result);

    }

    @Test
    public void postUser1Test() {
        String url = "http://127.0.0.1:8082/postUser";
        MultiValueMap<String,Object> map = new LinkedMultiValueMap<>();
        map.add("id",23);
        map.add("name","23号");

//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
//        HttpEntity<MultiValueMap<String,Object>> request = new HttpEntity<>(map,headers);


        String result = restTemplate.postForObject(url,map,String.class);
        log.info("result:{}", result);

    }

    @Test
    public void postUser2Test() {
        String url = "http://127.0.0.1:8082/postUser2";
        JSONObject param = new JSONObject();
        param.put("id",1);
        param.put("name","hello");
        String result = restTemplate.postForObject(url,param,String.class);
        log.info("result:{}", result);

    }

    private String getObject(String url, Map<String, ?> param) {
        if (MapUtils.isNotEmpty(param)) {
            StringBuilder sb = new StringBuilder(url + "?");
            for (Map.Entry<String, ?> entry : param.entrySet()) {
                sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
            url = sb.substring(0, sb.length() - 1);
        }
        return restTemplate.getForObject(url, String.class);
    }

    private ResponseEntity<String> getEntity(String url, Map<String, ?> param) {
        if (MapUtils.isNotEmpty(param)) {
            StringBuilder sb = new StringBuilder(url + "?");
            for (Map.Entry<String, ?> entry : param.entrySet()) {
                sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
            url = sb.substring(0, sb.length() - 1);
        }
        return restTemplate.getForEntity(url, String.class);
    }

}
