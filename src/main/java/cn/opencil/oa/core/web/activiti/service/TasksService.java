package cn.opencil.oa.core.web.activiti.service;

import org.activiti.engine.task.Task;

import java.util.List;
import java.util.Map;

/**
 * Created by mnzero on 16-8-13.
 */
public interface TasksService {
    String SERVICENAME = "cn.opencil.oa.core.web.activiti.service.impl.TasksServiceImpl";

    /**
     * 获取对应用户的任务
     * @return
     */
    List<Task> taskList();

    /**
     *签收任务
     */
    void claimTask(String taskId);

    /**
     * 办理任务
     */
    void completeTask(String taskId, Map<String, Object> variables);


}
