package cn.opencil.oa.core.web.organization.server.impl;

import cn.opencil.oa.core.base.dao.BaseDao;
import cn.opencil.oa.core.base.service.impl.BaseServiceImpl;
import cn.opencil.oa.core.domain.Organization;
import cn.opencil.oa.core.web.organization.dao.OrganizationDao;
import cn.opencil.oa.core.web.organization.server.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by mnzero on 16-9-7.
 */
@Service
public class OrganizationServiceImpl extends BaseServiceImpl<Organization> implements OrganizationService {

    @Autowired
    private OrganizationDao organizationDao;

    @Override
    public Organization findOne(Long organizationId) {
        return organizationDao.findOne(organizationId);
    }

    @Override
    public Collection<Organization> findAll() {
        return organizationDao.findAll();
    }

    @Override
    public Object findAllWithExclude(Organization excludeOraganization) {
        return organizationDao.findAllWithExclude(excludeOraganization);
    }

    @Override
    public void move(Organization source, Organization target) {
        organizationDao.move(source, target);
    }

    @Override
    public BaseDao getBaseDao() {
        return organizationDao;
    }
}
