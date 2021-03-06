package cn.opencil.oa.core.web.role.service;

import cn.opencil.oa.core.base.service.BaseService;
import cn.opencil.oa.core.domain.Role;

import java.util.Collection;
import java.util.List;
import java.util.Set;


/**
 * Created by 张树伟 on 16-5-16.
 */

public interface RoleService extends BaseService<Role> {
    /**
     * 获取数据字典中的角色名称
     * @param keyWorld
     * @return
     */
    List getDDLs(String keyWorld);

    Role getOne(Long roleId);

    Collection<Role> getAll();

    /**
     * 根据角色编号得到权限字符串列表
     * @param roleIds
     * @return
     */
    Set<String> findPermissions(Long[] roleIds);

    /**
     * 根据角色编号得到角色标识符列表
     * @param roleIds
     * @return
     */
    Set<String> findRoles(Long... roleIds);

    /**
     * 获取角色名称
     */
    String getRoleName(Long[] roleIds);
}
