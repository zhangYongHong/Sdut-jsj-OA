package cn.opencil.oa.core.web.role.dao;

import cn.opencil.oa.core.base.dao.BaseDao;
import cn.opencil.oa.core.domain.Role;

import java.util.Collection;

/**
 * Created by 张树伟 on 16-5-16.
 */
public interface RoleDao extends BaseDao<Role> {

    Role getOne(Long roleId);

    Collection<Role> getAll();
}
