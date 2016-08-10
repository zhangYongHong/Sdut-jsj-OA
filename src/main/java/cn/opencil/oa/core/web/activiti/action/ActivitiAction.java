package cn.opencil.oa.core.web.activiti.action;

import cn.opencil.oa.core.base.action.BaseAction;
import cn.opencil.oa.core.web.activiti.service.ActivitiService;
import com.opensymphony.xwork2.ActionContext;
import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by mnzero on 16-8-10.
 */
@Controller("ActivitiAction")
@Scope("prototype")
public class ActivitiAction extends BaseAction {
    @Resource
    private ActivitiService activitiService;

    /**
     * 流程部署列表
     * @return
     */
    public String list() {
        List<ProcessDefinition> definitions = activitiService.getDefinitions();

        ActionContext.getContext().put("definitions", definitions);
        return listAction;
    }
}
