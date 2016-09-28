package cn.opencil.oa.core.web.activiti.service.impl;

import cn.opencil.oa.common.util.PageUtil;
import cn.opencil.oa.core.domain.User;
import cn.opencil.oa.core.web.activiti.service.TasksService;
import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
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
    @Autowired
    private HistoryService historyService;

    @Override
    public List<Task> taskList() {
        User user = PageUtil.getUser();
        List<Task> list = new ArrayList<>();
        //判断用户权限
        //通过用户名查找对应的任务
        Subject subject = SecurityUtils.getSubject();
        if (subject.hasRole("admin")) {
            List<Task> taskList;
            taskList = taskService.createTaskQuery()
                    .orderByTaskCreateTime().desc().list();
            for (int i = 0; i < taskList.size(); i++) {
                if (!StringUtils.isNotEmpty(taskList.get(i).getAssignee()) || taskList.get(i).getAssignee().equals("超级管理员")) {
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
    public void completeTask(String taskId, Map<String, Object> variables, Integer state) {
        if (state == null) {
            taskService.complete(taskId, variables);
        } else if (state == 2){
            //同意状态
            variables.put("state", 2);
            taskService.complete(taskId, variables);
        } else if (state == 3) {
            //驳回状态
            variables.put("state", 3);
            taskService.complete(taskId, variables);
        }
    }

    @Override
    public String getFormKey(String taskId) {
        return formService.getTaskFormData(taskId).getFormKey();
    }

    @Override
    public Long getObjId(String taskId) {
        return (Long) taskService.getVariable(taskId, "objId");
    }

    @Override
    public String getFormUrl(Long id) {
        //通过taskID获取formKey
        String taskId = id.toString();
        String formKey = this.getFormKey(taskId);
        //通过taskID获取业务对象ID
        Long objId = this.getObjId(taskId);
        //拼装URL
        return formKey + "?aid=" + objId;
    }

    @Override
    public List<HistoricTaskInstance> historyList() {
        return historyService.createHistoricTaskInstanceQuery()
                .taskAssignee(PageUtil.getUser()
                        .getUserName()).orderByTaskCreateTime().desc().list();
    }

}
