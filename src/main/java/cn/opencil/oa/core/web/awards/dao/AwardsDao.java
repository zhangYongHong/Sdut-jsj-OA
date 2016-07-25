package cn.opencil.oa.core.web.awards.dao;

import cn.opencil.oa.common.page.PageResult;
import cn.opencil.oa.core.base.dao.BaseDao;
import cn.opencil.oa.core.domain.Awards;
import cn.opencil.oa.core.query.BaseQuery;

/**
 * Project Name:SdutOA
 * File Name:AwardsDao.java
 * Date:2016-4-15下午1:33:42
 * Author : 王基伟
 *
 * 获奖管理的dao
 *
 */
public interface AwardsDao extends BaseDao<Awards> {

	String DAONAME = "cn.opencil.oa.core.web.awards.dao.impl.AwardsDaoImpl";

	int getAwaCount(final BaseQuery baseQuery) ;
	PageResult<Awards> getAwaPageResult(final BaseQuery baseQuery);
}
