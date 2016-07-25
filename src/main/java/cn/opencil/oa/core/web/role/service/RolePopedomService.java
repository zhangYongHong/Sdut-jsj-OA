package cn.opencil.oa.core.web.role.service;

import cn.opencil.oa.core.base.service.BaseService;
import cn.opencil.oa.core.domain.RolePopedom;

import java.util.List;

/**
 * Created by mnzero on 16-5-20.
 */
public interface RolePopedomService extends BaseService<RolePopedom> {
    String SERVICENAME = "cn.opencil.oa.core.web.role.service.impl.RolePopedomServiceImpl";
    RolePopedom getRolePopedom(Integer rid);

    List<RolePopedom> getRolePopedomList();
}
