package com.zhang.activiti62;

import org.activiti.engine.*;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * @Name ：ActivitiTest
 * @Description ：TODO
 * @Author ：zhangjiwei
 * @Date ：2024/9/4 10:19
 * @Version ：1.0.0
 */
public class ActivitiTest {
    @Test
    public void deployTest() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        repositoryService.createDeployment()
                .addClasspathResource("bpmn/VacationRequest.bpmn20.xml").deploy();
        System.out.println("Number of process definitions: " + repositoryService.createProcessDefinitionQuery().count());
    }

    @Test
    public void handleRequestTest() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("employeeName", "Kermit");
        variables.put("numberOfDays", new Integer(4));
        variables.put("vacationMotivation", "I'm really tired!");

        ProcessInstance vacationRequest = runtimeService.startProcessInstanceByKey("vacationRequest", variables);

        System.out.println("Number of process instances: " + runtimeService.createProcessInstanceQuery().count());
    }

    @Test
    public void taskListTest() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        List<Task> taskList = taskService.createTaskQuery().taskCandidateGroup("management").list();
        for (Task task : taskList) {
            System.out.println("Task available=> name: " + task.getName() + ",id=" + task.getId());
        }
    }

    @Test
    public void taskCompleteTest() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        List<Task> taskList = taskService.createTaskQuery().taskCandidateGroup("management").list();
        Task task = taskList.get(0);

        Map<String, Object> taskVariables = new HashMap<String, Object>();
        taskVariables.put("vacationApproved", "false");
        taskVariables.put("managerMotivation", "We have a tight deadline!");
        taskService.complete(task.getId(), taskVariables);
    }
}
