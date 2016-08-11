package cn.opencil.oa.core.web.activiti.action;

import cn.opencil.oa.core.base.action.BaseAction;
import cn.opencil.oa.core.domain.Awards;
import cn.opencil.oa.core.web.activiti.service.ActivitiService;
import com.opensymphony.xwork2.ActionContext;
import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.io.File;
import java.io.InputStream;
import java.util.List;

/**
 * Created by mnzero on 16-8-10.
 */
@Controller("ActivitiAction")
@Scope("prototype")
public class ActivitiAction extends BaseAction<Awards> {

    @Resource
    private ActivitiService activitiService;

    private File processFile;
    private String deploymentId;
    private String resourceName;
    private InputStream inputStream;

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setProcessFile(File processFile) {
        this.processFile = processFile;
    }

    public void setDeploymentId(String deploymentId) {
        this.deploymentId = deploymentId;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }


    /**
     * 流程部署列表
     *
     * @return
     */
    public String list() {
        List<ProcessDefinition> definitions = activitiService.getDefinitions();
        ActionContext.getContext().put("definitions", definitions);
        return listAction;
    }

    /**
     * 跳转到规则文件上传页面
     * @return
     */
    public String newProcessUI() {
        return NEWPROCESSUI;
    }
    /**
     * 新建流程
     * @return
     */
    public String newProcess() {
        activitiService.deploy(processFile);
        return "redirect";
    }

    /**
     * 删除流程list
     */
    public String deleteProcess() {
        activitiService.delete(deploymentId);
        return LISTACTION;
    }

    /**
     * 查看流程规则图片
     */
    public String showImage() {
        inputStream = activitiService.getResourceAsStream(deploymentId, resourceName);
        return "";
    }

    /**
     *
     */
//    public String taskList() {
//        String assignee =
//    }
}
