package com.zhang.rocketmq.controller;

import com.zhang.rocketmq.util.ShortUrlGenerator;
import com.zhang.rocketmq.util.UrlUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/8/6 11:07
 */
@Controller
public class ShortUrlController {


    @GetMapping("/get")
    @ResponseBody
    public String get(String url) {
        String shortCode = ShortUrlGenerator.shortUrl(url)[0];
        UrlUtil.setUrl(shortCode, url);
        return "http://127.0.0.1:8085/short/" + shortCode;
    }

    @RequestMapping("/short/{code}")
    public String shortUrl(@PathVariable String code, HttpServletResponse response) throws IOException {
        String url = UrlUtil.get(code);
        if (StringUtils.isBlank(url)) {
            return "";
        }
        return "redirect:"+url;
    }
}
