package com.zhang.activiti6.service;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BanZhuRenService {
    @Autowired
    private TaskService taskService;
    public void complete(String taskId){
        Map<String,Object> param = new HashMap<>();
        param.put("result","COMPLETE");
        taskService.complete(taskId,param);
    }
}
