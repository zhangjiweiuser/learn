package com.zhang.activiti62;

import org.activiti.engine.*;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Name ：LeaveTest
 * @Description ：TODO
 * @Author ：zhangjiwei
 * @Date ：2024/11/7 13:54
 * @Version ：1.0.0
 */
public class LeaveTest {
    @Test
    public void deployTest(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        repositoryService.createDeployment()
                .addClasspathResource("bpmn/leave.bpmn20.xml")
                .name("请假单")
                .deploy();
    }
    @Test
    public void queryDefinition(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        ProcessDefinition leave = repositoryService.createProcessDefinitionQuery().processDefinitionKey("leave").singleResult();
        System.out.println(leave.getId());
        System.out.println(leave.getKey());
        System.out.println(leave.getName());
    }
    @Test
    public void startProcess(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();
        Map<String,Object> param = new HashMap<>();
        param.put("banzhuren","zhangsan");
        param.put("renshi","lisi");
        String businessKey = "qingjia-1";
        ProcessInstance leave = runtimeService.startProcessInstanceByKey("leave", businessKey, param);
        System.out.println(leave.getId());
    }

    @Test
    public void completeTask(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        List<Task> taskList = taskService.createTaskQuery().taskAssignee("zhangsan").list();
        String businessKey = "qingjia-1";
        for(Task task : taskList){
            System.out.println(task.getId());
            System.out.println(task.getName());
            System.out.println(task.getAssignee());
            String processInstanceId = task.getProcessInstanceId();
            System.out.println(processInstanceId);
            System.out.println("============");
            RuntimeService runtimeService = processEngine.getRuntimeService();
            ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
            System.out.println(processInstance.getName());
            System.out.println(processInstance.getBusinessKey());
            if(businessKey.equals(processInstance.getBusinessKey())){
                taskService.complete(task.getId());
            }
            System.out.println("---------");
        }
    }

    @Test
    public void completeRenShiTask(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        List<Task> taskList = taskService.createTaskQuery().taskAssignee("lisi").list();
        String businessKey = "qingjia-1";
        for(Task task : taskList){
            System.out.println(task.getId());
            System.out.println(task.getName());
            System.out.println(task.getAssignee());
            String processInstanceId = task.getProcessInstanceId();
            System.out.println(processInstanceId);
            System.out.println("============");
            RuntimeService runtimeService = processEngine.getRuntimeService();
            ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
            System.out.println(processInstance.getName());
            System.out.println(processInstance.getBusinessKey());
            if(businessKey.equals(processInstance.getBusinessKey())){
                taskService.complete(task.getId());
            }
            System.out.println("---------");
        }
    }
}
