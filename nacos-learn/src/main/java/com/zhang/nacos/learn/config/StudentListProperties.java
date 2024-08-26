package com.zhang.nacos.learn.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "student.list")
public class StudentListProperties {

    private List<StudentInfo> infoList;

    @Data
    public static class StudentInfo{
        private String name;
        private Integer age;
        private Boolean sanBan;
    }
}
