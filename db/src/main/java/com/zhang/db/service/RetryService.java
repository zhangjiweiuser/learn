package com.zhang.db.service;

import com.alibaba.fastjson.JSONObject;
import com.zhang.db.util.HttpClientUtils;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class RetryService {

    @Retryable(value = {Exception.class}, backoff = @Backoff(1000))
    public String retry() throws Exception {
        JSONObject param = new JSONObject();
        param.put("name", "name");
        param.put("age", ThreadLocalRandom.current().nextInt(1000, 9999));
        System.out.println(param.toJSONString());
        String result = HttpClientUtils.doGet("http://127.0.0.1:8056/getName");
        return result;
    }
    @Recover
    public String recover(){
        return "helllo";
    }
}
