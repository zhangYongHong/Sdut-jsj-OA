package cn.opencil.oa.core.web.login.dao.impl;

import java.util.List;


import org.springframework.stereotype.Repository;

import cn.opencil.oa.core.base.dao.impl.BaseDaoImpl;
import cn.opencil.oa.core.domain.User;
import cn.opencil.oa.core.web.login.dao.LoginDao;

/**
 * Project Name:SdutOA File Name:LoginDaoImpl.java Date:2016-4-15下午1:53:22
 * Author : 王基伟
 */
@Repository(LoginDao.DAONAME)
public class LoginDaoImpl extends BaseDaoImpl<User> implements LoginDao {

	@Override
	public User authentication(String employeenum, String password) {

		List list = this.getHibernateTemplate().find(
				"from User where employeenum = ? and password = ?", employeenum,
				password);
		return (User) ((null != list && list.size() > 0) ? list.get(0) : null);
	}

	@Override
	public int getDeptId(String userName) {
		List list  = this.getHibernateTemplate().find("from User where username = ?",userName);
		if(list.size() == 0){
			return 0;
		}
		User user = (User) ((null != list && list.size() > 0) ? list.get(0) : 0);
		return user.getDeptid();
	}

}
