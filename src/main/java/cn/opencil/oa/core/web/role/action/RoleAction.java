package cn.opencil.oa.core.web.role.action;


import cn.opencil.oa.core.base.action.BaseAction;
import cn.opencil.oa.core.domain.Role;
import cn.opencil.oa.core.web.role.service.RoleService;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;

/**
 * Created by 张树伟 on 16-5-16.
 */
@Controller
public class RoleAction extends BaseAction<Role> {
    @Autowired
    private RoleService roleService;

    public String list() {
        ArrayList<Role> roleList;
        roleList = (ArrayList<Role>) roleService.getAll();
        ActionContext.getContext().put("roleList", roleList);
        return listAction;
    }

    public String addUI() {
        return "addUI";
    }

    public String add() {
        Role role = getModel();
        roleService.addEntry(role);
        return "redirect";
    }

    public String updateUI() {
        Long id = getModel().getId();
        Role role = roleService.getOne(id);
        ActionContext.getContext().put("roles", role);
        return "updateUI";
    }

    public String update() {
        Role role = getModel();
        roleService.updateEntry(role);
        return "redirect";
    }

    public String delete() {
        Long id = getModel().getId();
        roleService.deleteEntry(id);
        return "redirect";
    }
}
