package cn.opencil.oa.core.web.resource.dao;

import cn.opencil.oa.core.domain.Resource;

import java.util.Collection;

/**
 * Created by mnzero on 16-9-5.
 */
public interface ResourceDao {
    Resource getOne(Long resourceId);

    Collection<Resource> getAll();
}
