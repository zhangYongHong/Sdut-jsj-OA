package cn.opencil.oa.core.web.basedata.dao;

import cn.opencil.oa.core.base.dao.BaseDao;
import cn.opencil.oa.core.domain.User;
import cn.opencil.oa.core.query.BaseQuery;

import java.util.Collection;

/**
 * Project Name:SdutOA
 * File Name:UserDao.java
 * Date:2016-4-15下午1:33:42
 * Author : 张树伟
 *
 * 用户管理的dao
 *
 */
public interface UserDao extends BaseDao<User> {

	User validation(String username);

	Collection<User> getUserByName(final BaseQuery baseQuery);

	User getUserByEmployeenum(String value);
}
