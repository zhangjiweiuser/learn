package com.zhang.activiti6.component;

import com.zhang.activiti6.service.BanZhuRenService;
import com.zhang.activiti6.service.RenShiService;
import com.zhang.activiti6.util.DateUtil;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class RenShiShenPi implements JavaDelegate {
    @Autowired
    private RenShiService renShiService;

    @Override
    public void execute(DelegateExecution delegateExecution) {
        System.out.println("我是人事审批" + DateUtil.getNow());
        // 任务id
        String taskId = delegateExecution.getId();
        Object count = delegateExecution.getVariable("count");
        if (null == count) {
            count = 0;
        } else {
            count = Integer.valueOf(count.toString()) + 1;
        }
        System.out.println("人事 taskId:" + taskId + ",count:" + count + "-----" + DateUtil.getNow());
        if ((Integer) count < 5) {

            delegateExecution.setVariable("result", "LOOP");
        } else {
            delegateExecution.setVariable("result", "COMPLETE");

        }
        delegateExecution.setVariable("count", count);
    }
}
