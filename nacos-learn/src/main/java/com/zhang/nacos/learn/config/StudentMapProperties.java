package com.zhang.nacos.learn.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Data
@Component
@ConfigurationProperties(prefix = "student.map")
public class StudentMapProperties {

    private Map<String,StudentInfo2> infoMap;

    @Data
    public static class StudentInfo2{
        private Integer age;
        private Boolean sanBan;
    }
}
