package com.zhang.db.controller;

import com.alibaba.fastjson.JSON;
import com.zhang.db.util.HttpClientUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/7/26 10:02
 */
@RestController
public class HttpController extends BaseController{

    @PostMapping("/verifyNo")
    public List<String> verifyNo(@RequestBody List<String> verifyNo) {
        System.out.println(JSON.toJSONString(verifyNo));
        return verifyNo;
    }

    @GetMapping("/getBaiDu")
    public String getBaiDu() throws Exception {

        String s = HttpClientUtils.doGet("https://cloud.tencent.com/developer/article/1549152");
        System.out.println(s);
        return s;
    }
}
