package cn.opencil.oa.core.web.activiti.service;

import org.activiti.engine.repository.ProcessDefinition;

import java.util.List;

/**
 * Created by mnzero on 16-8-10.
 */
public interface ActivitiService {
    String SERVICENAME = "cn.opencil.oa.core.web.activiti.service.impl";

    /**
     * 流程的部署与发布
     */
    void deploy();

    /**
     * 已部署的流程列表
     */
    void deployed();

    /**
     * 启动流程
     */
    void start();

    void task();

    List<ProcessDefinition> getDefinitions();

}
