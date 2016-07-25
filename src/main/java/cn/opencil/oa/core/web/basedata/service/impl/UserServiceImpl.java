package cn.opencil.oa.core.web.basedata.service.impl;

import javax.annotation.Resource;

import cn.opencil.oa.common.page.PageResult;
import cn.opencil.oa.common.util.MD5Util;
import cn.opencil.oa.core.domain.SystemDDL;
import cn.opencil.oa.core.domain.UserRole;
import cn.opencil.oa.core.query.UserQuery;
import cn.opencil.oa.core.web.role.dao.UserRoleDao;
import cn.opencil.oa.core.web.role.service.UserRoleService;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.opencil.oa.core.base.dao.BaseDao;
import cn.opencil.oa.core.base.service.impl.BaseServiceImpl;
import cn.opencil.oa.core.domain.User;
import cn.opencil.oa.core.web.basedata.dao.UserDao;
import cn.opencil.oa.core.web.basedata.service.UserService;

import java.util.Collection;
import java.util.List;

/**
 * Project Name:SdutOA
 * File Name:UserServiceImpl.java
 * Date:2016-4-15下午1:44:52
 * Author : 王基伟
 */

@Service(UserService.SERVICENAME)
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Resource(name = UserDao.DAONAME)
    private UserDao userDao;

    @Autowired
    private UserRoleService userRoleService;

    @Override
    public BaseDao getBaseDao() {
        return this.userDao;
    }

    @Override
    public User validation(String username) {
        return this.userDao.validation(username);
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




//	@Override
//	public void addEntry(User user) {
//		//密码 MD5加密
//		MD5Util md5Util =  new MD5Util();
//		user.setPassword(md5Util.getkeyBeanofStr(user.getPassword()));
//		super.addEntry(user);
//	}
}
