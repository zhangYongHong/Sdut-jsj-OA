package cn.opencil.oa.core.web.activiti.service;

import org.activiti.engine.task.Task;

import java.util.List;
import java.util.Map;

/**
 * Created by mnzero on 16-8-13.
 */
public interface TasksService {
    /**
     * 获取对应用户的任务
     */
    List<Task> taskList();

    /**
     *签收任务
     */
    void claimTask(String id, String userName);

    /**
     * 办理任务
     */
    void completeTask(String taskId, Map<String, Object> variables);

    String getFormKey(String taskId);

    Long getObjId(String taskId);
}
