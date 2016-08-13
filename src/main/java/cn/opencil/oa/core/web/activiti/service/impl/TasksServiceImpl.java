package cn.opencil.oa.core.web.activiti.service.impl;

import cn.opencil.oa.common.util.PageUtil;
import cn.opencil.oa.core.domain.User;
import cn.opencil.oa.core.web.activiti.service.TasksService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by mnzero on 16-8-13.
 */
@Service(TasksService.SERVICENAME)
public class TasksServiceImpl implements TasksService {

    @Autowired
    TaskService taskService;

    @Override
    public List<Task> taskList() {
        User user = PageUtil.getUser();
        //判断用户权限
        //通过用户名查找对应的任务
        return taskService.createTaskQuery()
                .orderByTaskCreateTime().desc().list();
    }

    @Override
    public void claimTask(String taskId) {
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        User user = PageUtil.getUser();
        task.setAssignee(user.getUserName());
    }

    @Override
    public void completeTask(String taskId, Map<String, Object> variables) {
        taskService.complete(taskId, variables);
    }

}
