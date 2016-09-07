package cn.opencil.oa.core.web.role.dao.impl;

import cn.opencil.oa.core.base.dao.impl.BaseDaoImpl;
import cn.opencil.oa.core.domain.Role;
import cn.opencil.oa.core.domain.UserRole;
import cn.opencil.oa.core.web.role.dao.UserRoleDao;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by 张树伟 on 16-5-16.
 */
@Repository
public class UserRoleDaoImpl extends BaseDaoImpl<UserRole> implements UserRoleDao {

    @Override
    public Collection<UserRole> getUserRoleList() {

        return this.getHibernateTemplate().execute(
                new HibernateCallback<Collection<UserRole>>() {
                    @Override
                    public Collection<UserRole> doInHibernate(Session session) throws HibernateException {
                        StringBuilder hql = new StringBuilder("from UserRole where 1=1 ");

                        Query query = session.createQuery(hql.toString());

                        return query.list();
                    }
                });

    }

    @Override
    public UserRole getUserRole(final Long uid) {
        return this.getHibernateTemplate().get(UserRole.class, uid);
    }

    @Override
    public Role getOne(Long roleId) {
        return this.getHibernateTemplate().get(Role.class, roleId);
    }

    @Override
    public Collection<Role> getAll() {
        return this.getHibernateTemplate().execute(
                new HibernateCallback<Collection<Role>>() {
                    @Override
                    public Collection<Role> doInHibernate(Session session) throws HibernateException {
                        StringBuilder hql = new StringBuilder("from Role where 1=1 ");

                        Query query = session.createQuery(hql.toString());
                        return query.list();
                    }
                });
    }

}
