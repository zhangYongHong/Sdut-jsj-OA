package cn.opencil.oa.core.web.resource.dao;

import cn.opencil.oa.core.base.dao.BaseDao;
import cn.opencil.oa.core.domain.Resource;

import java.util.Collection;

/**
 * Created by mnzero on 16-9-5.
 */
public interface ResourceDao extends BaseDao<Resource> {
    Resource getOne(Long resourceId);

    Collection<Resource> getAll();
}
