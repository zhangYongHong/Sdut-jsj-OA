package cn.opencil.oa.core.web.basedata.service.impl;

import cn.opencil.oa.common.page.PageResult;
import cn.opencil.oa.core.base.dao.BaseDao;
import cn.opencil.oa.core.base.service.impl.BaseServiceImpl;
import cn.opencil.oa.core.domain.User;
import cn.opencil.oa.core.query.UserQuery;
import cn.opencil.oa.core.web.basedata.dao.UserDao;
import cn.opencil.oa.core.web.basedata.service.UserService;
import cn.opencil.oa.core.web.role.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Project Name:SdutOA
 * File Name:UserServiceImpl.java
 * Date:2016-4-15下午1:44:52
 * Author : 张树伟
 */

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRoleService userRoleService;

    @Override
    public BaseDao getBaseDao() {
        return this.userDao;
    }


    @Override
    public PageResult<User> getUserPageResult(final UserQuery userQuery) {

        String roleName;
        PageResult<User> userPageResult = this.getPageResult(userQuery);
        List<User> userList = userPageResult.getRows();
        //填充user_role表中的用户角色数据
        for (User user : userList) {
            roleName = userRoleService.getRoleName(user.getUid());
            user.setRole(roleName);
        }
        return userPageResult;
    }

    @Override
    public User getUserByEmployeenum(String value) {
        return this.userDao.getUserByEmployeenum(value);
    }

    @Override
    public Set<String> getRoles(String employeenum) {
        User user = getUserByEmployeenum(employeenum);
        if (user == null) {
            return Collections.emptySet();
        }
        return userRoleService.findRoles(user.getRoleIds().toArray(new Long[0]));
    }

    @Override
    public Set<String> getPermissions(String employeenum) {
        User user = getUserByEmployeenum(employeenum);
        if(user == null) {
            return Collections.EMPTY_SET;
        }
        return userRoleService.findPermissions(user.getRoleIds().toArray(new Long[0]));
    }
}
