package cn.opencil.oa.core.web.awards.dao.impl;

import cn.opencil.oa.common.page.PageResult;
import cn.opencil.oa.core.base.dao.impl.BaseDaoImpl;
import cn.opencil.oa.core.domain.Awards;
import cn.opencil.oa.core.query.BaseQuery;
import cn.opencil.oa.core.web.awards.dao.AwardsDao;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Project Name:SdutOA
 * File Name:AwardsDaoImpl.java
 * Date:2016-4-15下午1:34:50
 * Author : 王基伟
 *
 * 获奖管理的dao
 */

@Repository(AwardsDao.DAONAME)
public class AwardsDaoImpl extends BaseDaoImpl<Awards> implements AwardsDao{

	public int getAwaCount(final BaseQuery baseQuery) {
	
		
		return this.getHibernateTemplate().execute(
				new HibernateCallback<Integer>() {
					@Override
					public Integer doInHibernate(Session session) throws HibernateException {
						StringBuilder hql = new StringBuilder();
						/**
						 * 使用select count(1) 报错?
						 */
						hql.append("select count(aid) from Awards");
						hql.append(" where 1 = 1 ");
						Map<String, Object> buildWhere = baseQuery.buildWhere();


						for(Entry<String, Object> entry : buildWhere.entrySet()){
							hql.append(" and "+entry.getKey() + " like '"+entry.getValue()+"%'");
						}

						Query query = session.createQuery(hql.toString());


						Long count = (Long) query.uniqueResult();

						return count.intValue();
					}
				}
		);
	}
	
	
	public PageResult<Awards> getAwaPageResult(final BaseQuery baseQuery) {
		//找到符合条件的总记录数
		final int count = this.getAwaCount(baseQuery);
		return this.getHibernateTemplate().execute(
				new org.springframework.orm.hibernate4.HibernateCallback<PageResult<Awards>>() {
					@Override
					public PageResult<Awards> doInHibernate(Session session) throws HibernateException {
						StringBuilder hql = new StringBuilder();
						hql.append("from Awards where ");
						Map<String, Object> whereKV = baseQuery.buildWhere();

						for(Entry<String,Object> entry : whereKV.entrySet()){
							hql.append(entry.getKey() + " = '"+entry.getValue()+"'");
						}
						Query query = session.createQuery(hql.toString());
						//分页
						int firstResult = (baseQuery.getCurrentPage()-1)*baseQuery.getPageSize();
						query.setFirstResult(firstResult).setMaxResults(baseQuery.getPageSize());
						PageResult<Awards> pageResult = new PageResult<Awards>(baseQuery.getCurrentPage(),baseQuery.getPageSize(),count);
						List list = query.list();
						pageResult.setRows(list);
						return pageResult;
					}
				}
		);
	
	}
}

