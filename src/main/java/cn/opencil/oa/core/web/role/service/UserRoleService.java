package cn.opencil.oa.core.web.role.service;

import cn.opencil.oa.core.base.service.BaseService;
import cn.opencil.oa.core.domain.UserRole;

import java.util.List;


/**
 * Created by 张树伟 on 16-5-16.
 */

public interface UserRoleService extends BaseService {
    /**
     * 获取数据字典中的角色名称
     * @param keyWorld
     * @return
     */
    List getDDLs(String keyWorld);

    String getPopedomCode(Long uid);

    UserRole getUserRole(final Long uid);

    List<UserRole> getUserRoleList();

    String getRoleName(final Long uid);
}
