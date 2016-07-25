package cn.opencil.oa.core.web.awards.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.opencil.oa.common.page.PageResult;
import cn.opencil.oa.core.base.dao.BaseDao;
import cn.opencil.oa.core.base.service.impl.BaseServiceImpl;
import cn.opencil.oa.core.domain.Awards;
import cn.opencil.oa.core.query.BaseQuery;
import cn.opencil.oa.core.web.awards.dao.AwardsDao;
import cn.opencil.oa.core.web.awards.service.AwardsService;

/**
 * Project Name:SdutOA
 * File Name:AwardsServiceImpl.java
 * Date:2016-4-15下午1:38:01
 * Author : 王基伟
 */
@Service(AwardsService.SERVICENAME)
public class AwardsServiceImpl extends BaseServiceImpl<Awards> implements AwardsService {

	@Resource(name=AwardsDao.DAONAME)
	private AwardsDao awardsDao;
	
	
	@Override
	public BaseDao getBaseDao() {
		return this.awardsDao;
	}


	@Override
	public PageResult<Awards> getAwaPageResult(BaseQuery baseQuery) {
		
		return this.awardsDao.getAwaPageResult(baseQuery);
	}

}
