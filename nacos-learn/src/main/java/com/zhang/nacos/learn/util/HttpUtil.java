package com.zhang.nacos.learn.util;

import com.alibaba.nacos.api.utils.StringUtils;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
//@ConfigurationProperties(prefix = "oss-upload")
public class HttpUtil {
    @Value("${oss-upload.key}")
    private String ossKey;

    @Value("${oss-upload.value}")
    private String ossValue;
    private static String key;
    private static String value;

    @PostConstruct
    public void init(){
        if(StringUtils.isBlank(this.ossKey)){
            throw new IllegalArgumentException("加密key不存在");
        }
        key = this.ossKey;
        if(StringUtils.isBlank(this.ossValue)){
            throw new IllegalArgumentException("加密密钥不存在");
        }
        value = this.ossValue;
    }


    public static String sign() {
        return key + "---" + value;
    }
}
