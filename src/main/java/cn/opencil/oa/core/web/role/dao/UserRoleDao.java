package cn.opencil.oa.core.web.role.dao;

import cn.opencil.oa.core.base.dao.BaseDao;
import cn.opencil.oa.core.domain.Role;
import cn.opencil.oa.core.domain.UserRole;

import java.util.Collection;

/**
 * Created by 张树伟 on 16-5-16.
 */
public interface UserRoleDao extends BaseDao<UserRole> {

    UserRole getUserRole(final Long uid);

    Role getOne(Long roleId);

    Collection<Role> getAll();

    Collection<UserRole> getUserRoleList();
}
