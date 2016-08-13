package cn.opencil.oa.core.web.activiti.service;

import org.activiti.engine.repository.ProcessDefinition;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

/**
 * Created by mnzero on 16-8-10.
 */
public interface ActivitiService {
    /**
     * 流程的部署与发布
     */
    void deploy(File processFile);

    /**
     * 已部署的流程列表
     */
    void deployed();



    /**
     * 返回部署的流程列表
     * @return
     */
    List<ProcessDefinition> getDefinitions();

    /**
     * 删除流程
     * @param id
     */
    void delete(String id);

    /**
     * 返回指定上传文件的流
     * @param deploymentId
     * @param resourceName
     * @return
     */
    InputStream getResourceAsStream(String deploymentId, String resourceName);

    /**
     * 根据任务的key启动流程
     * key: 为对应业务对象的类名
     */
    void start(String processDefinitionKey, String businessKey, HashMap<String, Object> value);

}
