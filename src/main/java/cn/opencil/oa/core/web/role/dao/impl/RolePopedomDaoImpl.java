package cn.opencil.oa.core.web.role.dao.impl;

import cn.opencil.oa.core.base.dao.impl.BaseDaoImpl;
import cn.opencil.oa.core.domain.RolePopedom;
import cn.opencil.oa.core.web.role.dao.RolePopedomDao;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

/**
 * Created by 张树伟 on 16-5-16.
 */
@Repository
public class RolePopedomDaoImpl extends BaseDaoImpl<RolePopedom> implements RolePopedomDao {

    @Override
    public RolePopedom getRolePopedom(final Integer rid) {
        RolePopedom rolePopedom = this.getHibernateTemplate().get(RolePopedom.class, rid);
        return this.getHibernateTemplate().get(RolePopedom.class, rid);
    }

    @Override
    public Collection<RolePopedom> getRolePopedomList() {
        return this.getHibernateTemplate().execute(
                new HibernateCallback<Collection<RolePopedom>>() {
                    @Override
                    public Collection<RolePopedom> doInHibernate(Session session) throws HibernateException {
                        String hql = "from RolePopedom where 1=1 ";
                        Query query = session.createQuery(hql);
                        List<RolePopedom> rolePopedomList = query.list();
                        return query.list();
                    }
                }
        );
    }


}
