package cn.opencil.oa.core.web.role.dao;

import cn.opencil.oa.core.base.dao.BaseDao;
import cn.opencil.oa.core.domain.UserRole;
import cn.opencil.oa.core.query.BaseQuery;

import java.util.Collection;

/**
 * Created by 张树伟 on 16-5-16.
 */
public interface UserRoleDao extends BaseDao<UserRole> {
    String DAONAME = "cn.opencil.oa.core.web.role.dao.impl.UserRoleDaoImpl";

    UserRole getUserRole(final Long uid);

    Collection<UserRole> getUserRoleList();
}
