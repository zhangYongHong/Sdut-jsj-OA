package cn.opencil.oa.core.web.role.action;


import cn.opencil.oa.common.util.PageUtil;
import cn.opencil.oa.core.base.action.BaseAction;
import cn.opencil.oa.core.domain.Role;
import cn.opencil.oa.core.domain.SystemDDL;
import cn.opencil.oa.core.web.basedata.service.SystemDDLService;
import cn.opencil.oa.core.web.role.service.RoleService;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by 张树伟 on 16-5-16.
 */
@Controller
public class RoleAction extends BaseAction<Role> {
    @Autowired
    private RoleService roleService;
    @Autowired
    private SystemDDLService systemDDLService;

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
        PageUtil.removeSpaces(role);
        SystemDDL systemDDL = new SystemDDL();
        systemDDL.setUuid(UUID.randomUUID().toString());
        systemDDL.setKeyword("role");
        systemDDL.setDdlCode(systemDDLService.getNumberIsNotInDdlCode(systemDDL.getKeyword()));
        systemDDL.setDdlName(role.getRole());
        role.setDdlId(systemDDL.getUuid());
        Long id = (Long) roleService.addEntry(role);
        systemDDL.setDdlCode(id.intValue());
        systemDDLService.addEntry(systemDDL);
        List<SystemDDL> sourceList = systemDDLService.getDDLs("role");
        if (null != sourceList) {
            ActionContext.getContext().getSession().put("roleList", sourceList);
        }
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
        SystemDDL systemDDL = systemDDLService.getEntryById(role.getDdlId());
        systemDDL.setDdlName(role.getRole());
        systemDDLService.updateEntry(systemDDL);
        return "redirect";
    }

    public String delete() {
        Long id = getModel().getId();
        Role role = roleService.getOne(id);
        String uuid = systemDDLService.getEntryById(role.getDdlId()).getUuid();
        systemDDLService.deleteEntry(uuid);
        roleService.deleteEntry(id);
        return "redirect";
    }
}
