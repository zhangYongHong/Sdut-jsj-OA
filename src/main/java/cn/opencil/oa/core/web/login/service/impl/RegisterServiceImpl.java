package cn.opencil.oa.core.web.login.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.opencil.oa.core.base.dao.BaseDao;
import cn.opencil.oa.core.base.service.impl.BaseServiceImpl;
import cn.opencil.oa.core.domain.User;
import cn.opencil.oa.core.web.basedata.dao.UserDao;
import cn.opencil.oa.core.web.login.service.RegisterService;

/**
 * Project Name:SdutOA
 * File Name:RegisterServiceImpl.java
 * Date:2016-4-16下午3:40:00
 * Author : 王基伟
 * 注册service
 */

@Service(RegisterService.SERVICENAME)
public class RegisterServiceImpl extends BaseServiceImpl<User> implements RegisterService{

	@Resource(name=UserDao.DAONAME)
	private UserDao userDao;
	
	@Override
	public BaseDao getBaseDao() {
		return this.userDao;
	}
	
	@Override
	public void register(User user) throws Exception {
		this.userDao.addEntry(user);
	}

	@Override
	public User validation(String employeenum) {
		
		return this.userDao.validation(employeenum);
	}

}
