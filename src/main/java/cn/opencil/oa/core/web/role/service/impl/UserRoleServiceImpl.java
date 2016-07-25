package cn.opencil.oa.core.web.role.service.impl;

import cn.opencil.oa.core.base.dao.BaseDao;
import cn.opencil.oa.core.base.service.impl.BaseServiceImpl;
import cn.opencil.oa.core.domain.RolePopedom;
import cn.opencil.oa.core.domain.SystemDDL;
import cn.opencil.oa.core.domain.UserRole;
import cn.opencil.oa.core.web.basedata.dao.SystemDDLDao;
import cn.opencil.oa.core.web.role.dao.RolePopedomDao;
import cn.opencil.oa.core.web.role.dao.UserRoleDao;
import cn.opencil.oa.core.web.role.service.UserRoleService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by 张树伟 on 16-5-16.
 */
@Service(UserRoleService.SERVICENAME)
public class UserRoleServiceImpl extends BaseServiceImpl implements UserRoleService {
    @Resource(name = UserRoleDao.DAONAME)
    private UserRoleDao userRoleDao;

    @Resource(name = RolePopedomDao.DAONAME)
    private RolePopedomDao rolePopedomDao;

    @Resource(name = SystemDDLDao.DAONAME)
    private SystemDDLDao systemDDLDao;


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
        if(null != uid) {
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
    public List getDDLs(String keyWorld) {
        ArrayList<SystemDDL> arrayList;
        arrayList = (ArrayList<SystemDDL>)systemDDLDao.getDDLs(keyWorld);
        return arrayList;
    }
}
