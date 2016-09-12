package cn.opencil.oa.core.web.resource.server.impl;

import cn.opencil.oa.core.base.dao.BaseDao;
import cn.opencil.oa.core.base.service.impl.BaseServiceImpl;
import cn.opencil.oa.core.domain.Resource;
import cn.opencil.oa.core.web.resource.dao.ResourceDao;
import cn.opencil.oa.core.web.resource.server.ResourceServer;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * Created by mnzero on 16-9-5.
 */
@Service
public class ResourceServerImpl extends BaseServiceImpl<Resource> implements ResourceServer {
    @Autowired
    private ResourceDao resourceDao;


    @Override
    public Set<String> getPermissions(Set<Long> resourceIds) {
        Set<String> permissions = new HashSet<String>();
        for(Long resourceId : resourceIds) {
            Resource resource = getOne(resourceId);
            if(resource != null && !StringUtils.isEmpty(resource.getPermission())) {
                permissions.add(resource.getPermission());
            }
        }
        return permissions;
    }

    @Override
    public Resource getOne(Long resourceIds) {
        return resourceDao.getOne(resourceIds);
    }

    @Override
    public Collection<Resource> getAll() {
        return resourceDao.getAll();
    }

//    @Override
//    public List<Resource> findMenus(Set<String> permissions) {
//        List<Resource> allResources = (List<Resource>) getAll();
//        List<Resource> menus = new ArrayList<Resource>();
//        for(Resource resource : allResources) {
//            if(resource.isRootNode()) {
//                continue;
//            }
//            if(resource.getType() != Resource.ResourceType.menu) {
//                continue;
//            }
//            if(!hasPermission(permissions, resource)) {
//                continue;
//            }
//            menus.add(resource);
//        }
//        return menus;
//    }
    private boolean hasPermission(Set<String> permissions, Resource resource) {
        if(StringUtils.isEmpty(resource.getPermission())) {
            return true;
        }
        for(String permission : permissions) {
            WildcardPermission p1 = new WildcardPermission(permission);
            WildcardPermission p2 = new WildcardPermission(resource.getPermission());
            if(p1.implies(p2) || p2.implies(p1)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public BaseDao getBaseDao() {
        return resourceDao;
    }
}
