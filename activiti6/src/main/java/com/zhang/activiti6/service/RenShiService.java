package com.zhang.activiti6.service;

import org.activiti.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RenShiService {
    @Autowired
    private TaskService taskService;

    public void complete(String taskId, Object count) {
        Map<String, Object> param = new HashMap<>();
        if ((Integer) count < 20) {
            param.put("result", "LOOP");
        } else {
            param.put("result", "COMPLETE");

        }
        taskService.complete(taskId, param);
    }
}
