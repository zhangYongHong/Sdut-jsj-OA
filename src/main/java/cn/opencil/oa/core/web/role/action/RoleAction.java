package cn.opencil.oa.core.web.role.action;


import cn.opencil.oa.core.base.action.BaseAction;
import cn.opencil.oa.core.domain.SystemDDL;
import cn.opencil.oa.core.web.role.service.UserRoleService;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;

/**
 * Created by 张树伟 on 16-5-16.
 */
@Controller
public class RoleAction extends BaseAction<Object> {
    @Autowired
    private UserRoleService userRoleService;

    public String home() {
        ArrayList<SystemDDL> roleList;
        roleList = (ArrayList<SystemDDL>) userRoleService.getDDLs("role");
        ActionContext.getContext().put("roleList", roleList);
        return SUCCESS;
    }
}
