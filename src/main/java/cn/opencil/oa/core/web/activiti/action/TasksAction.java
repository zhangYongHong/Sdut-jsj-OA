package cn.opencil.oa.core.web.activiti.action;

import cn.opencil.oa.common.util.PageUtil;
import cn.opencil.oa.core.domain.User;
import cn.opencil.oa.core.web.activiti.service.TasksService;
import com.opensymphony.xwork2.ActionContext;
import org.activiti.engine.task.Task;
import org.apache.commons.collections.map.HashedMap;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;
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
    /**
     * 待办任务列表
     */
    public String taskList() {
        List<Task> taskList = tasksService.taskList();
        ActionContext.getContext().put("taskList", taskList);
        return "listAction";
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
        //通过taskID获取formKey
        String taskId = id.toString();
        String formKey = tasksService.getFormKey(taskId);
        //通过taskID获取业务对象ID
        Long objId = tasksService.getObjId(taskId);
        //拼装URL
        formUrl = formKey + "?aid=" + objId;
        ActionContext.getContext().put("formUrl", formUrl);
        HttpSession session = ServletActionContext.getRequest().getSession();
        session.setAttribute("taskId", taskId);
        return "taskForm";
    }

    /**
     * 办理任务
     */
    public String completeTask() {
        httpSession = ServletActionContext.getRequest().getSession();
        String taskId = (String) httpSession.getAttribute("taskId");
        Integer state = (Integer) httpSession.getAttribute("state");
        Map<String, Object> variables = new HashedMap();
        variables.put("assignee", PageUtil.getUser().getUserName());
        if (state == null) {
            tasksService.completeTask(taskId, variables);
            return "redirect";
        } else if (state == 2){
            variables.put("state", 2);
            tasksService.completeTask(taskId, variables);
        } else if (state == 3) {
            variables.put("state", 3);
            tasksService.completeTask(taskId, variables);
        }
        return "redirect";
    }



//=====================================================================
    public void setId(Long id) {
        this.id = id;
    }
}
