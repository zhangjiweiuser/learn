package com.zhang.activiti6.component;

import com.zhang.activiti6.service.BanZhuRenService;
import com.zhang.activiti6.util.DateUtil;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BanZhuRenShenPi implements JavaDelegate {
    @Autowired
    private BanZhuRenService banZhuRenService;

    @Override
    public void execute(DelegateExecution delegateExecution) {
        System.out.println("我是班主任审批" + DateUtil.getNow());
        // 任务id
//        String taskId = delegateExecution.getId();
//        System.out.println("班主任 taskId:" + taskId);
//        banZhuRenService.complete(taskId);
        delegateExecution.setVariable("result", "COMPLETE");
    }
}
