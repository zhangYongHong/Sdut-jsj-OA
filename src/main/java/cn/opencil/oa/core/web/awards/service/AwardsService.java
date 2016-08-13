package cn.opencil.oa.core.web.awards.service;

import cn.opencil.oa.common.page.PageResult;
import cn.opencil.oa.core.base.service.BaseService;
import cn.opencil.oa.core.domain.Awards;
import cn.opencil.oa.core.query.BaseQuery;

/**
 * Project Name:SdutOA
 * File Name:AwardsService.java
 * Date:2016-4-15下午1:37:01
 * Author : 王基伟
 *
 * 获奖管理的serive
 */
public interface AwardsService  extends BaseService<Awards>{

	PageResult<Awards> getAwardsPageResult(BaseQuery baseQuery);

    void startProcess(Long id);
}
