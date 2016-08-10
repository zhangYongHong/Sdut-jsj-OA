package cn.opencil.oa.core.web.activiti.service.impl;

import cn.opencil.oa.core.web.activiti.service.ActivitiService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mnzero on 16-8-10.
 */
@Service(ActivitiService.SERVICENAME)
public class ActivitiServiceImpl implements ActivitiService {
    @Autowired
    RepositoryService repositoryService;
    @Autowired
    RuntimeService runtimeService;
    @Autowired
    TaskService taskService;

    /**
     * 流程的部署与发布
     */
    @Override
    public void deploy() {
        DeploymentBuilder deploymentBuilder = repositoryService.createDeployment();
        deploymentBuilder.name("award")
                .addClasspathResource("cn/opencil/oa/core/activiti/Awards.bpmn")
                .addClasspathResource("cn/opencil/oa/core/activiti/Awards.png").deploy();
    }

    @Override
    public void deployed() {
        List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery().list();
        for (ProcessDefinition p : list) {
            System.out.println("------------------------------------------------");
            System.out.println(p.getId());
            System.out.println("------------------------------------------------");

        }
    }

    @Override
    public void start() {
        runtimeService.startProcessInstanceById("award:1:4");
    }

    @Override
    public void task() {
        taskService.createTaskQuery().list();
    }

    @Override
    public List<ProcessDefinition> getDefinitions() {
        return repositoryService.createProcessDefinitionQuery().list();
    }
}
