package cn.opencil.oa.core.web.resource.dao.impl;

import cn.opencil.oa.core.base.dao.impl.BaseDaoImpl;
import cn.opencil.oa.core.domain.Resource;
import cn.opencil.oa.core.web.resource.dao.ResourceDao;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by mnzero on 16-9-5.
 */
@Repository
public class ResourceDaoImpl extends BaseDaoImpl<Resource> implements ResourceDao {
    @Override
    public Resource getOne(Long resourceId) {
        return this.getHibernateTemplate().get(Resource.class, resourceId);
    }

    @Override
    public Collection<Resource> getAll() {
        return this.getHibernateTemplate().execute(
                new HibernateCallback<Collection<Resource>>() {
                    @Override
                    public Collection<Resource> doInHibernate(Session session) throws HibernateException {
                        StringBuilder hql = new StringBuilder("from Resource where 1=1 ");
                        Query query = session.createQuery(hql.toString());
                        return query.list();
                    }
                });
    }
}
