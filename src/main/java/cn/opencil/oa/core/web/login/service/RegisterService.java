package cn.opencil.oa.core.web.login.service;

import cn.opencil.oa.core.base.service.BaseService;
import cn.opencil.oa.core.domain.User;

/**
 * Project Name:SdutOA
 * File Name:RegisterService.java
 * Date:2016-4-16下午3:39:17
 * Author : 王基伟
 */
public interface RegisterService extends BaseService<User> {

	String SERVICENAME = "cn.opencil.oa.core.web.register.service.impl.RegisterServiceImpl";

	/**
	 * 验证用户名是否唯一，是否合法
	 * @param employeenum
	 * @return
	 */
	User validation(String employeenum);
	
	/**
	 * 注册
	 * @param user
	 */
	void register(User user) throws Exception;

}
