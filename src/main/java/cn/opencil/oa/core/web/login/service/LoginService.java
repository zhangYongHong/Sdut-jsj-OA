package cn.opencil.oa.core.web.login.service;

import cn.opencil.oa.core.base.service.BaseService;
import cn.opencil.oa.core.domain.User;


/**
 * Project Name:SdutOA
 * File Name:LoginService.java
 * Date:2016-4-15下午1:50:49
 * Author : 张树伟
 *
 */
public interface LoginService extends BaseService<User> {

	/**
	 * 验证用户
	 * @param employeenum
	 * @param password
	 * @return
	 */
	User authentication(String employeenum, String password);
	
}
