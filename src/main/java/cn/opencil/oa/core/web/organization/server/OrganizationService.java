package cn.opencil.oa.core.web.organization.server;

import cn.opencil.oa.core.base.service.BaseService;
import cn.opencil.oa.core.domain.Organization;

import java.util.Collection;

/**
 * Created by mnzero on 16-9-7.
 */
public interface OrganizationService extends BaseService<Organization> {
    Organization findOne(Long organizationId);
    Collection<Organization> findAll();

    Object findAllWithExclude(Organization excludeOraganization);

    void move(Organization source, Organization target);
}
