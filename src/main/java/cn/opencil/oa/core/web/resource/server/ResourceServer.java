package cn.opencil.oa.core.web.resource.server;

import cn.opencil.oa.core.domain.Resource;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by mnzero on 16-9-5.
 */
public interface ResourceServer {
    /**
     * 得到资源对应的权限字符串
     * @param resourceIds
     * @return
     */
    Set<String> getPermissions(Set<Long> resourceIds);

    Resource getOne(Long resourceIds);

    Collection<Resource> getAll();

    /**
     * 根据用户权限得到菜单
     * @param permissions
     * @return
     */
    List<Resource> findMenus(Set<String> permissions);
}
