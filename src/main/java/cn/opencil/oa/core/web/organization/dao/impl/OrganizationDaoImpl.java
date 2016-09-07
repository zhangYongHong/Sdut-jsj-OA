package cn.opencil.oa.core.web.organization.dao.impl;

import cn.opencil.oa.core.base.dao.impl.BaseDaoImpl;
import cn.opencil.oa.core.domain.Organization;
import cn.opencil.oa.core.web.organization.dao.OrganizationDao;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * Created by mnzero on 16-9-7.
 */
@Repository
public class OrganizationDaoImpl extends BaseDaoImpl<Organization> implements OrganizationDao {
    @Override
    public Organization findOne(Long organizationId) {
        return this.getHibernateTemplate().get(Organization.class, organizationId);
    }

    @Override
    public Collection<Organization> findAll() {
        return this.getHibernateTemplate().execute(
                new HibernateCallback<Collection<Organization>>() {
                    @Override
                    public Collection<Organization> doInHibernate(Session session) throws HibernateException {
                        StringBuilder hql = new StringBuilder("from Organization where 1=1 ");
                        Query query = session.createQuery(hql.toString());
                        return query.list();
                    }
                });
    }

    @Override
    public List<Organization> findAllWithExclude(final Organization excludeOraganization) {
        return (List<Organization>) this.getHibernateTemplate().execute(
                new HibernateCallback<Collection<Organization>>() {

                    @Override
                    public Collection<Organization> doInHibernate(Session session) throws HibernateException {
                        StringBuffer hql = new StringBuffer("from Organization where id != ?, parentIds not like ?");
                        Query query = session.createQuery(hql.toString());
                        query.setParameter(0, excludeOraganization.getId());
                        query.setParameter(1, excludeOraganization.getParentIds());
                        return query.list();
                    }
                }
        );
    }

    @Override
    public void move(Organization source, Organization target) {
    }
}
