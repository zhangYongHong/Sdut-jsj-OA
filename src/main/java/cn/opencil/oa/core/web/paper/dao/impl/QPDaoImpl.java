package cn.opencil.oa.core.web.paper.dao.impl;

import cn.opencil.oa.core.base.dao.impl.BaseDaoImpl;
import cn.opencil.oa.core.domain.QuestionPaper;
import cn.opencil.oa.core.query.BaseQuery;
import cn.opencil.oa.core.query.PaperQuery;
import cn.opencil.oa.core.web.paper.dao.QPDao;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Project Name:SdutOA
 * File Name:QPDaoImpl.java
 * Date:2016-4-19下午9:33:41
 * Author : 王基伟
 *
 */
@Repository(QPDao.DAONAME)
public class QPDaoImpl extends BaseDaoImpl<QuestionPaper> implements QPDao{

	@Override
	public Collection<QuestionPaper> getEntrysByQuery(final BaseQuery baseQuery) {
		return this.getHibernateTemplate().execute(
				new HibernateCallback<Collection<QuestionPaper>>() {
					@Override
					public Collection<QuestionPaper> doInHibernate(Session session) throws HibernateException,SQLException {
						StringBuilder hql = new StringBuilder("from QuestionPaper where 1=1 ");

						PaperQuery qpQuery = (PaperQuery) baseQuery;

						if (qpQuery != null && qpQuery.getShoolYear() != null && !qpQuery.getShoolYear().trim().equals("")) {
							hql.append(" and schoolYear = ? ");
						}

						Query query = session.createQuery(hql.toString());
						if (qpQuery != null && qpQuery.getShoolYear() != null
								&& !qpQuery.getShoolYear().trim().equals("")) {
							query.setParameter(0, qpQuery.getShoolYear());
						}

						return query.list();
					}
				});
	}

}
