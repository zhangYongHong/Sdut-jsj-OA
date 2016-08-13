package cn.opencil.oa.core.web.activiti.service.impl;

import cn.opencil.oa.common.util.PageUtil;
import cn.opencil.oa.core.web.activiti.service.ActivitiService;
import cn.opencil.oa.core.web.awards.dao.AwardsDao;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.zip.ZipInputStream;

/**
 * Created by mnzero on 16-8-10.
 */
@Service
@Transactional(readOnly = false)
public class ActivitiServiceImpl implements ActivitiService {
    @Autowired
    RepositoryService repositoryService;
    @Autowired
    RuntimeService runtimeService;
    @Autowired
    TaskService taskService;
    @Autowired
    AwardsDao awardsDao;
    /**
     * 流程的部署与发布
     */
    @Override
    public void deploy(File processFile) {
        try {
            DeploymentBuilder deploymentBuilder = repositoryService.createDeployment();
            InputStream inputStream = new FileInputStream(processFile);
            String fileName = processFile.getName();
            String extension = PageUtil.getExtension(fileName);
//            if (extension.equals("zip") || extension.equals("bar")) {
                ZipInputStream zip = new ZipInputStream(inputStream);
                deploymentBuilder.addZipInputStream(zip);
//            } else {
//                deploymentBuilder.addInputStream(fileName, inputStream);
//            }
            deploymentBuilder.deploy();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("部署流程失败！");
        }
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
    public List<ProcessDefinition> getDefinitions() {
        return repositoryService.createProcessDefinitionQuery().orderByProcessDefinitionKey().desc().list();
    }

    @Override
    public void delete(String id) {
        repositoryService.deleteDeployment(id, true);
    }

    @Override
    public InputStream getResourceAsStream(String deploymentId, String resourceName) {
        return repositoryService.getResourceAsStream(deploymentId, resourceName);
    }

    @Override
    public void start(String processDefinitionKey, String businessKey, HashMap<String, Object> value) {
        runtimeService.startProcessInstanceByKey(processDefinitionKey, businessKey, value);
    }

}
