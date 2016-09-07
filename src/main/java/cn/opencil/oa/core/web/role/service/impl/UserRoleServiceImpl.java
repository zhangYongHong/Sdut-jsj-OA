package cn.opencil.oa.core.web.role.service.impl;

import cn.opencil.oa.core.base.dao.BaseDao;
import cn.opencil.oa.core.base.service.impl.BaseServiceImpl;
import cn.opencil.oa.core.domain.Role;
import cn.opencil.oa.core.domain.RolePopedom;
import cn.opencil.oa.core.domain.SystemDDL;
import cn.opencil.oa.core.domain.UserRole;
import cn.opencil.oa.core.web.basedata.dao.SystemDDLDao;
import cn.opencil.oa.core.web.resource.server.ResourceServer;
import cn.opencil.oa.core.web.role.dao.RolePopedomDao;
import cn.opencil.oa.core.web.role.dao.UserRoleDao;
import cn.opencil.oa.core.web.role.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


/**
 * Created by 张树伟 on 16-5-16.
 */
@Service
public class UserRoleServiceImpl extends BaseServiceImpl<UserRole> implements UserRoleService {

    @Autowired
    private UserRoleDao userRoleDao;

    @Autowired
    private RolePopedomDao rolePopedomDao;

    @Autowired
    private SystemDDLDao systemDDLDao;

    @Autowired
    private ResourceServer resourceServer;


    @Override
    public BaseDao getBaseDao() {
        return this.userRoleDao;
    }

    public String getPopedomCode(Long uid) {

        UserRole userRole = userRoleDao.getUserRole(uid);
        Integer rid = userRole.getRid();

        RolePopedom rolePopedom = rolePopedomDao.getRolePopedom(rid);

        String popedomCode = rolePopedom.getPopedomCode();

        return popedomCode;
    }

    @Override
    public UserRole getUserRole(final Long uid) {
        return userRoleDao.getUserRole(uid);
    }

    @Override
    public List<UserRole> getUserRoleList() {
        return (List<UserRole>) userRoleDao.getUserRoleList();
    }

    @Override
    public String getRoleName(Long uid) {
        List<SystemDDL> systemDDLList = systemDDLDao.getDDLs("role");
        if (null != uid) {
            UserRole userRole = userRoleDao.getUserRole(uid);
            if (userRole != null) {
                Integer rid = userRole.getRid();
                for (SystemDDL systemDDL : systemDDLList) {
                    if (rid == systemDDL.getDdlCode()) {
                        return systemDDL.getDdlName();
                    }
                }
            }
        }
        return "";
    }

    @Override
    public Set<String> getPermissions(Long[] roleIds) {
        Set<Long> resourceIds = new HashSet<>();
        for (Long roleId : roleIds) {
            Role role = getOne(roleId);
            if (role != null) {
                resourceIds.addAll(role.getResourceIds());
            }
        }
        return resourceServer.getPermissions(resourceIds);
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
        for(Long roleId : roleIds) {
            Role role = getOne(roleId);
            if(role != null) {
                roles.add(role.getRole());
            }
        }
        return roles;
    }
}
