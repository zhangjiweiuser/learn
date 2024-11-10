package com.zhang.activiti6.controller;

import com.zhang.activiti6.util.DateUtil;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class ActivitController {
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private RuntimeService runtimeService;

    @GetMapping("/delete")
    public void delete() {
        Deployment qingjia = repositoryService.createDeploymentQuery().processDefinitionKey("qingjia").singleResult();
        repositoryService.deleteDeployment(qingjia.getId());
    }

    @GetMapping("/deploy")
    public void deploy() {
        Deployment deploy = repositoryService.createDeployment()
                .addClasspathResource("processes/qingjia.bpmn20.xml")
                .name("请假")
                .deploy();
        System.out.println(deploy.getId());
    }

    @GetMapping("/start")
    public void start() {
        System.out.println("我要开始启动实例了11111" + DateUtil.getNow());
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("qingjia", "qingjia-1");
        System.out.println("我要开始启动实例了22222" + DateUtil.getNow());
        System.out.println(processInstance.getId() + "-----" + DateUtil.getNow());
    }
}
