package cn.opencil.oa.core.web.role.dao;

import cn.opencil.oa.core.base.dao.BaseDao;
import cn.opencil.oa.core.domain.RolePopedom;

import java.util.Collection;

/**
 * Created by 张树伟 on 16-5-16.
 */
public interface RolePopedomDao extends BaseDao<RolePopedom> {
    String DAONAME = "cn.opencil.oa.core.web.role.dao.impl.RolePopedomDaoImpl";

    RolePopedom getRolePopedom(final Integer rid);

    Collection<RolePopedom> getRolePopedomList();
}
