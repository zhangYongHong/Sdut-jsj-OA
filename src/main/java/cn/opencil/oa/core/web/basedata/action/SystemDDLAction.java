package cn.opencil.oa.core.web.basedata.action;


import cn.opencil.oa.common.page.PageResult;
import cn.opencil.oa.core.base.action.BaseAction;
import cn.opencil.oa.core.domain.SystemDDL;
import cn.opencil.oa.core.query.SystemDDLQuery;
import cn.opencil.oa.core.web.basedata.service.SystemDDLService;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

/**
 * Project Name:SdutOA
 * File Name:SystemDDLAction.java
 * Date:2016-4-15下午8:35:50
 * Author : 张树伟
 */
@Controller
@Scope("prototype")
public class SystemDDLAction extends BaseAction<SystemDDL> {

    private static final long serialVersionUID = 1L;

    @Autowired
    private SystemDDLService systemDDLService;

    public String list() {
        SystemDDLQuery systemDDLQuery = new SystemDDLQuery();
        if (this.getModel().getKeyword() == null)
            systemDDLQuery.setKeyword("dept");
        else
            systemDDLQuery.setKeyword(this.getModel().getKeyword());
        PageResult<SystemDDL> systemDDLs = this.systemDDLService.getPageResultByKeyword(systemDDLQuery);
        ActionContext.getContext().put("systemDDLs", systemDDLs);
        return LISTACTION;
    }

    public String addUI() {
        return addUI;
    }

    public String add() {
        SystemDDL systemDDL = this.getModel();
        systemDDL.setUuid(UUID.randomUUID().toString());
        systemDDL.setDdlCode(systemDDLService.getNumberIsNotInDdlCode(systemDDL.getKeyword()));
        systemDDLService.addEntry(systemDDL);
        loadSource(systemDDL.getKeyword());
        return REDIRECT;
    }

    public String updateUI() {
        SystemDDL systemDDL = systemDDLService.getEntryById(this.getModel().getUuid());
        ActionContext.getContext().put("systemDDL", systemDDL);
        return REDIRECT;
    }

    public String update() {
        systemDDLService.updateEntry(this.getModel());
        loadSource(this.getModel().getKeyword());
        return REDIRECT;
    }

    public String delete() {
        systemDDLService.deleteEntry(this.getModel().getUuid());
        return REDIRECT;
    }

    private boolean loadSource(String valueName) {
        List<SystemDDL> sourceList = systemDDLService.getDDLs(valueName);
        if (null != sourceList) {
            ActionContext.getContext().getSession().put(valueName + "List", sourceList);
            return true;
        }
        return false;
    }
}
