package cn.opencil.oa.core.web.paper.dao.impl;

import cn.opencil.oa.core.base.dao.impl.BaseDaoImpl;
import cn.opencil.oa.core.domain.TrainingPaper;
import cn.opencil.oa.core.query.BaseQuery;
import cn.opencil.oa.core.query.PaperQuery;
import cn.opencil.oa.core.web.paper.dao.TPDao;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Project Name:SdutOA
 * File Name:TPQDaoImpl.java
 * Date:2016-4-19下午9:33:57
 * Author: 张树伟
 */
@Repository(TPDao.DAONAME)
public class TPDaoImpl extends BaseDaoImpl<TrainingPaper> implements TPDao {

    @Override
    public Collection<TrainingPaper> getEntrysByQuery(final BaseQuery baseQuery) {

        return this.getHibernateTemplate().execute(
                new HibernateCallback<Collection<TrainingPaper>>() {
                    @Override
                    public Collection<TrainingPaper> doInHibernate(Session session) throws HibernateException {
                        StringBuilder hql = new StringBuilder(
                                "from TrainingPaper where 1=1 ");

                        PaperQuery tquery = (PaperQuery) baseQuery;

                        if (tquery != null && tquery.getShoolYear() != null
                                && !tquery.getShoolYear().trim().equals("")) {
                            hql.append(" and grade = ? ");
                        }

                        Query query = session.createQuery(hql.toString());

                        if (tquery != null && tquery.getShoolYear() != null
                                && !tquery.getShoolYear().trim().equals("")) {
                            query.setParameter(0, tquery.getShoolYear());
                        }

                        return query.list();
                    }
                }
        );
    }
}
