package cn.opencil.oa.core.web.login.service.impl;

import javax.annotation.Resource;

import cn.opencil.oa.core.base.dao.BaseDao;
import cn.opencil.oa.core.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import cn.opencil.oa.core.domain.User;
import cn.opencil.oa.core.web.login.dao.LoginDao;
import cn.opencil.oa.core.web.login.service.LoginService;

/**
 * Project Name:SdutOA
 * File Name:LoginServiceImpl.java
 * Date:2016-4-15下午1:51:44
 * Author : 王基伟
 * 
 */

@Service(LoginService.SERVICENAME)
public class LoginServiceImpl extends BaseServiceImpl<User> implements LoginService{

	@Resource(name=LoginDao.DAONAME)
	private LoginDao loginDao;
	
	@Override
	public User authentication(String employeenum, String password) {
		return this.loginDao.authentication(employeenum, password);
	}

	@Override
	public BaseDao getBaseDao() {
		return this.loginDao;
	}
}
