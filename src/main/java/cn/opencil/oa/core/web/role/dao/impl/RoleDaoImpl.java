package cn.opencil.oa.core.web.role.dao.impl;

import cn.opencil.oa.common.util.PageUtil;
import cn.opencil.oa.core.base.dao.impl.BaseDaoImpl;
import cn.opencil.oa.core.domain.Role;
import cn.opencil.oa.core.web.role.dao.RoleDao;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * Created by 张树伟 on 16-5-16.
 */
@Repository
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {

    @Override
    public Role getOne(Long roleId) {
        Role role = this.getHibernateTemplate().get(Role.class, roleId);
        role.setResourceIds(PageUtil.strListTOLongList(PageUtil.getStringList(role.getResourceIdsStr())));
        return role;
    }

    @Override
    public Collection<Role> getAll() {
        return this.getHibernateTemplate().execute(
                new HibernateCallback<Collection<Role>>() {
                    @Override
                    public Collection<Role> doInHibernate(Session session) throws HibernateException {
                        StringBuilder hql = new StringBuilder("from Role where 1=1 ");

                        Query query = session.createQuery(hql.toString());
                        List<Role> list = query.list();
                        for (Role role : list) {
                            role.setResourceIds(PageUtil.strListTOLongList(PageUtil.getStringList(role.getResourceIdsStr())));
                        }
                        return list;
                    }
                });
    }

}
