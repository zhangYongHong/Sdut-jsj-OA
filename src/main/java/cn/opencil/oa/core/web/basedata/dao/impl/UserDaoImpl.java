package cn.opencil.oa.core.web.basedata.dao.impl;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import cn.opencil.oa.common.page.PageResult;
import cn.opencil.oa.common.util.PageUtil;
import cn.opencil.oa.core.query.BaseQuery;
import cn.opencil.oa.core.query.UserQuery;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import cn.opencil.oa.core.base.dao.impl.BaseDaoImpl;
import cn.opencil.oa.core.domain.User;
import cn.opencil.oa.core.web.basedata.dao.UserDao;


/**
 * Project Name:SdutOA
 * File Name:UserDaoImpl.java
 * Date:2016-4-15下午1:34:50
 * Author : 王基伟
 *
 * 用户管理的dao
 */

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{


	/**
	 * 校验用户名是否合法，是否存在
	 */
	@Override
	public User validation(String username) {
		
		List list = this.getHibernateTemplate().find("from User where username = ?",username);
		
		return (User) ((null != list && list.size() > 0)?list.get(0):null);
	}

	@Override
	public Collection<User> getUserByName(final BaseQuery baseQuery) {
		return this.getHibernateTemplate().execute(
				new org.springframework.orm.hibernate4.HibernateCallback<Collection<User>>() {
					@Override
					public Collection<User> doInHibernate(Session session) throws HibernateException {
						StringBuilder hql = new StringBuilder("from QuestionPaper where 1=1 ");

						UserQuery userQuery = (UserQuery) baseQuery;

						if (userQuery != null && userQuery.getUsername() != null && !userQuery.getUsername().trim().equals("")) {
							hql.append(" and username = ? ");
						}

						Query query = session.createQuery(hql.toString());


						return query.list();
					}
				}
		);
	}

	@Override
	public User getUserByEmployeenum(String value) {
		List list = this.getHibernateTemplate().find("from User where employeenum = ?",value);
		User user = (User) ((null != list && list.size() > 0)?list.get(0):null);
		/*
		 * 因为数据库中类型为varchar,而domian中对应的数据类型为list，故将数据库中取出的数据缓存到RoleIdsStr中
		 * 再转换为list
		*/
		user.setRoleIds(PageUtil.StrListTOLongList(PageUtil.getStringList(user.getRoleIdsStr())));
		return user;
	}

}
