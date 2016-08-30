package cn.opencil.oa.core.web.activiti.service.impl;

import cn.opencil.oa.common.util.ContantKey;
import cn.opencil.oa.common.util.PageUtil;
import cn.opencil.oa.core.domain.User;
import cn.opencil.oa.core.web.activiti.service.TasksService;
import org.activiti.engine.FormService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by mnzero on 16-8-13.
 */
@Service
public class TasksServiceImpl implements TasksService {

    @Autowired
    private TaskService taskService;

    @Autowired
    private FormService formService;
    @Override
    public List<Task> taskList() {
        User user = PageUtil.getUser();
        List<Task> list = new ArrayList<>();
        //判断用户权限
        //通过用户名查找对应的任务
        String popedomCode = (String) PageUtil.getHttpSession().getAttribute(ContantKey.GLOBLE_USER_ROLE);

        if (popedomCode.equals("abc")) {
            List<Task> taskList = new ArrayList<>();

            taskList = taskService.createTaskQuery()
                    .orderByTaskCreateTime().desc().list();
            for (int i = 0; i < taskList.size(); i++) {
                if (taskList.get(i).getAssignee() == null || taskList.get(i).getAssignee().equals("超级管理员")) {
                    list.add(taskList.get(i));
                }
            }
            return list;
        }
        return taskService.createTaskQuery()
                .taskCandidateOrAssigned(user.getUserName())
                .orderByTaskCreateTime().desc().list();
    }

    @Override
    public void claimTask(String id, String userName) {
        taskService.claim(id, userName);
    }

    @Override
    public void completeTask(String taskId, Map<String, Object> variables) {
        taskService.complete(taskId, variables);
    }

    @Override
    public String getFormKey(String taskId) {
        return formService.getTaskFormData(taskId).getFormKey();
    }

    @Override
    public Long getObjId(String taskId) {
        return (Long) taskService.getVariable(taskId, "objId");
    }

}
