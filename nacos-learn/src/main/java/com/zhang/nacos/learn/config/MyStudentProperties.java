package com.zhang.nacos.learn.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Data
@Component
@RefreshScope
public class MyStudentProperties {
    @Value("${mystudent.name}")
    private String name;
    @Value("${mystudent.course}")
    private String course;
}
