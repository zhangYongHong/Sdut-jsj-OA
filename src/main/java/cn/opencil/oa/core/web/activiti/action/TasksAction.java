package cn.opencil.oa.core.web.activiti.action;

import cn.opencil.oa.common.util.PageUtil;
import cn.opencil.oa.core.domain.User;
import cn.opencil.oa.core.web.activiti.service.TasksService;
import com.opensymphony.xwork2.ActionContext;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.task.Task;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mnzero on 16-8-13.
 */
@Controller
@Scope("prototype")
public class TasksAction {
    @Autowired
    private TasksService tasksService;

    private Long id;
    private HttpSession httpSession;
    private String formUrl;

    /**
     * 待办任务列表
     */
    public String taskList() {
        List<Task> taskList = tasksService.taskList();
        ActionContext.getContext().put("taskList", taskList);
        return "listAction";
    }

    /**
     * 已办任务列表
     */
    public String historyList() {
        List<HistoricTaskInstance> historicTaskInstanceList = tasksService.historyList();
        ActionContext.getContext().put("historyList", historicTaskInstanceList);
        return "historyList";
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
    public String viewTaskForm() {
        String formUrl;
        formUrl = tasksService.getFormUrl(id);
        ActionContext.getContext().put("formUrl", formUrl);
        HttpSession session = ServletActionContext.getRequest().getSession();
        session.setAttribute("taskId", id.toString());
        return "taskForm";
    }

    /**
     * 办理任务
     */
    public String completeTask() {
        httpSession = ServletActionContext.getRequest().getSession();
        String taskId = (String) httpSession.getAttribute("taskId");
        Integer state = (Integer) httpSession.getAttribute("state");
        Map<String, Object> variables = new HashMap();
        variables.put("assignee", PageUtil.getUser().getUserName());
        tasksService.completeTask(taskId, variables, state);
        return "redirect";
    }





//=====================================================================
    public void setId(Long id) {
        this.id = id;
    }

    public String getFormUrl() {
        return formUrl;
    }

}
