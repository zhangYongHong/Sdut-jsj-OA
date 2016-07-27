package cn.opencil.oa.core.web.basedata.dao.impl;

import cn.opencil.oa.common.page.PageResult;
import cn.opencil.oa.core.base.dao.impl.BaseDaoImpl;
import cn.opencil.oa.core.domain.SystemDDL;
import cn.opencil.oa.core.query.BaseQuery;
import cn.opencil.oa.core.web.basedata.dao.SystemDDLDao;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Project Name:SdutOA
 * File Name:SystemDDLDaoImplk.java
 * Date:2016-4-15下午8:33:47
 * Author : 王基伟
 * 数据字典的dao
 */
@Repository(SystemDDLDao.DAONAME)
public class SystemDDLDaoImpl extends BaseDaoImpl<SystemDDL> implements SystemDDLDao {

	@Override
	public PageResult<SystemDDL> getPageResultByKeyword(final BaseQuery baseQuery) {
		
		final Integer count = this.getCount("竞赛项目");
		return this.getHibernateTemplate().execute(new HibernateCallback<PageResult<SystemDDL>>() {

			@Override
			public PageResult<SystemDDL> doInHibernate(Session session)
					throws HibernateException {

				String hql = "from SystemDDL where 1=1 and keyword=:keyword";
				Query query = session.createQuery(hql);
				
				Map<String, Object> whereKV = baseQuery.buildWhere();
				
				query.setParameter("keyword", whereKV.get("keyword"));
				int firstResult = (baseQuery.getCurrentPage()-1)*baseQuery.getPageSize();
				query.setFirstResult(firstResult).setMaxResults(baseQuery.getPageSize());
				PageResult<SystemDDL> pageResult = new PageResult<SystemDDL>(baseQuery.getCurrentPage(),baseQuery.getPageSize(),count);
				List list = query.list();
				pageResult.setRows(list);
				
				
				return pageResult;
			}
		});
	}

	public Integer getCount(final String keyword){
		
		return this.getHibernateTemplate().execute(new HibernateCallback<Integer>() {

			@Override
			public Integer doInHibernate(Session session)
					throws HibernateException {

					String hql = "SELECT COUNT(sid) from systemddl where 1=1 and keyword=:keyword";
					Query query = session.createQuery(hql);
				
					query.setParameter("keyword", keyword);
					Integer count = (Integer) query.uniqueResult();
				return count;
			}

		});

	}



	@Override
	public Integer getCodeByKeyword(final String keyword) {
		
		Integer code =  this.getHibernateTemplate().execute(new HibernateCallback<Integer>() {

			@Override
			public Integer doInHibernate(Session session)
					throws HibernateException {
				String hql = "SELECT MAX(ddlCode) from SystemDDL where keyword=:keyword";
				Query query = session.createQuery(hql);
				query.setParameter("keyword", keyword);
				Integer code = (Integer) query.uniqueResult();
				return code;
			}
		});
		
		return (null != code)?code:0;
		
	}

	@Override
	public void addDDL(SystemDDL systemDDL) throws Exception {
		this.addEntry(systemDDL);
	}

	@Override
	public List<SystemDDL> getDDLs(String keyword) {
		return (List<SystemDDL>) this.getHibernateTemplate().find("from SystemDDL where keyword = ?", keyword);
	}

	@Override
	public SystemDDL getSystenDDL(String keyword, Integer ddlCode) {
		return (SystemDDL) this.getHibernateTemplate().find("from SystemDDL where keyword = ? and ddlCode = ? ", keyword, ddlCode).get(0);
	}


}
