package cn.opencil.oa.core.web.activiti.action;

import cn.opencil.oa.common.util.PageUtil;
import cn.opencil.oa.core.base.action.BaseAction;
import cn.opencil.oa.core.domain.User;
import cn.opencil.oa.core.web.activiti.service.TasksService;
import com.opensymphony.xwork2.ActionContext;
import org.activiti.engine.task.Task;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

/**
 * Created by mnzero on 16-8-13.
 */
@Controller
@Scope("prototype")
public class TasksAction extends BaseAction<Task> {
    @Autowired
    TasksService tasksService;
    Long id;

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 待办任务列表
     */
    public String taskList() {
        List<Task> taskList = tasksService.taskList();
        ActionContext.getContext().put("taskList", taskList);
        return listAction;
    }

    /**
     * 签收任务
     * @return
     */
    public String claimTask() {
        String taskId = id.toString();
        User user = PageUtil.getUser();
        tasksService.claimTask(taskId, user.getUserName());
        return "redirect";
    }

    /**
     * 跳转到业务对象的表单
     */
    public String redirectAtion() {

        return "";
    }

    /**
     * 办理任务
     */
    public String completeTask() {
        String taskId = id.toString();
        Map<String, Object> variables = new HashedMap();
        variables.put("assignee", PageUtil.getUser().getUserName());
        tasksService.completeTask(taskId, variables);
        return "redirect";
    }
}
