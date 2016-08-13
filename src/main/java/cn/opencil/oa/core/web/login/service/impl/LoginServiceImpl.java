package cn.opencil.oa.core.web.login.service.impl;

import cn.opencil.oa.core.base.dao.BaseDao;
import cn.opencil.oa.core.base.service.impl.BaseServiceImpl;
import cn.opencil.oa.core.domain.User;
import cn.opencil.oa.core.web.login.dao.LoginDao;
import cn.opencil.oa.core.web.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Project Name:SdutOA
 * File Name:LoginServiceImpl.java
 * Date:2016-4-15下午1:51:44
 * Author : 张树伟
 * 
 */

@Service
public class LoginServiceImpl extends BaseServiceImpl<User> implements LoginService{

	@Autowired
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
