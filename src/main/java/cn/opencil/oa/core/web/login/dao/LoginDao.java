package cn.opencil.oa.core.web.login.dao;

import cn.opencil.oa.core.base.dao.BaseDao;
import cn.opencil.oa.core.domain.User;

/**
 * Project Name:SdutOA File Name:LoginDao.java Date:2016-4-15下午1:52:33 Author :
 * 张树伟
 * 
 */
public interface LoginDao extends BaseDao<User> {
	/**
	 * 验证用户
	 * 
	 * @param employeenum
	 * @param password
	 * @return
	 */
	User authentication(String employeenum, String password);

	int getDeptId(String userName);
}
