package cn.opencil.oa.core.web.organization.dao;

import cn.opencil.oa.core.base.dao.BaseDao;
import cn.opencil.oa.core.domain.Organization;

import java.util.List;

/**
 * Created by mnzero on 16-9-7.
 */
public interface OrganizationDao extends BaseDao<Organization> {
    Organization findOne(Long organizationId);
    List<Organization> findAll();

    List<Organization> findAllWithExclude(Organization excludeOraganization);

    void move(Organization source, Organization target);
}
