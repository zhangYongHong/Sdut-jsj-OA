package cn.opencil.oa.core.web.role.service.impl;

import cn.opencil.oa.core.base.dao.BaseDao;
import cn.opencil.oa.core.base.service.impl.BaseServiceImpl;
import cn.opencil.oa.core.domain.Role;
import cn.opencil.oa.core.domain.SystemDDL;
import cn.opencil.oa.core.web.basedata.dao.SystemDDLDao;
import cn.opencil.oa.core.web.resource.server.ResourceServer;
import cn.opencil.oa.core.web.role.dao.RoleDao;
import cn.opencil.oa.core.web.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


/**
 * Created by 张树伟 on 16-5-16.
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {

    @Autowired
    private RoleDao userRoleDao;

    @Autowired
    private SystemDDLDao systemDDLDao;

    @Autowired
    private ResourceServer resourceServer;


    @Override
    public BaseDao getBaseDao() {
        return this.userRoleDao;
    }

    @Override
    public List getDDLs(String keyWorld) {
        ArrayList<SystemDDL> arrayList;
        arrayList = (ArrayList<SystemDDL>) systemDDLDao.getDDLs(keyWorld);
        return arrayList;
    }

    @Override
    public Role getOne(Long roleId) {
        return userRoleDao.getOne(roleId);
    }

    @Override
    public Collection<Role> getAll() {
        return userRoleDao.getAll();
    }

    @Override
    public Set<String> findPermissions(Long[] roleIds) {
        Set<Long> resourcesIds = new HashSet<>();
        for (Long roleId : roleIds) {
            Role role = getOne(roleId);
            if (role != null) {
                resourcesIds.addAll(role.getResourceIds());
            }
        }
        return resourceServer.getPermissions(resourcesIds);
    }

    @Override
    public Set<String> findRoles(Long... roleIds) {
        Set<String> roles = new HashSet<String>();
        for (Long roleId : roleIds) {
            Role role = getOne(roleId);
            if (role != null) {
                roles.add(role.getRole());
            }
        }
        return roles;
    }

    @Override
    public String getRoleName(Long[] roleIds) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < roleIds.length; i++) {
            Long roleId = roleIds[i];
            if (i != roleIds.length - 1) {
                stringBuffer.append(getOne(roleId).getRole() + ",");
            } else {
                stringBuffer.append(getOne(roleId).getRole());
            }
        }
        return stringBuffer.toString();
    }
}
