package com.zhang.nacos.learn.controller;

import com.alibaba.fastjson.JSON;
import com.zhang.nacos.learn.config.StudentListProperties;
import com.zhang.nacos.learn.config.StudentMapProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/nacos")
public class StudentController {
    @Autowired
    private StudentListProperties studentListProperties;
    @Autowired
    private StudentMapProperties studentMapProperties;
    @GetMapping("/getStudentInfoList")
    public List<StudentListProperties.StudentInfo> getStudentInfoList(){
        List<StudentListProperties.StudentInfo> infoList = studentListProperties.getInfoList();
        System.out.println(JSON.toJSONString(infoList));
        return infoList;
    }

    @GetMapping("/getStudentInfoMap")
    public Map<String,StudentMapProperties.StudentInfo2> getStudentInfoMap(){
        Map<String,StudentMapProperties.StudentInfo2> infoList = studentMapProperties.getInfoMap();
        System.out.println(JSON.toJSONString(infoList));
        return infoList;
    }
}
