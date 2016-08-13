package cn.opencil.oa.core.web.role.service.impl;

import cn.opencil.oa.core.base.dao.BaseDao;
import cn.opencil.oa.core.base.service.impl.BaseServiceImpl;
import cn.opencil.oa.core.domain.RolePopedom;
import cn.opencil.oa.core.web.role.dao.RolePopedomDao;
import cn.opencil.oa.core.web.role.service.RolePopedomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mnzero on 16-5-20.
 */
@Service
public class RolePopedomServiceImpl extends BaseServiceImpl<RolePopedom> implements RolePopedomService {

    @Autowired
    private RolePopedomDao rolePopedomDao;



    @Override
    public BaseDao getBaseDao() {
        return this.rolePopedomDao;
    }

    @Override
    public RolePopedom getRolePopedom(Integer rid) {
        RolePopedom rolePopedom = rolePopedomDao.getRolePopedom(rid);
        return rolePopedomDao.getRolePopedom(rid);
    }

    @Override
    public List<RolePopedom> getRolePopedomList() {
        List<RolePopedom> rolePopedomList = (List<RolePopedom>) this.rolePopedomDao.getRolePopedomList();
        return (List<RolePopedom>) this.rolePopedomDao.getRolePopedomList();
    }
}
