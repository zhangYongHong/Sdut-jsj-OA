package cn.opencil.oa.core.web.awards.service.impl;

import cn.opencil.oa.common.page.PageResult;
import cn.opencil.oa.common.util.PageUtil;
import cn.opencil.oa.core.base.dao.BaseDao;
import cn.opencil.oa.core.base.service.impl.BaseServiceImpl;
import cn.opencil.oa.core.domain.Awards;
import cn.opencil.oa.core.domain.SystemDDL;
import cn.opencil.oa.core.query.BaseQuery;
import cn.opencil.oa.core.web.awards.dao.AwardsDao;
import cn.opencil.oa.core.web.awards.service.AwardsService;
import cn.opencil.oa.core.web.basedata.service.SystemDDLService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Project Name:SdutOA
 * File Name:AwardsServiceImpl.java
 * Date:2016-4-15下午1:38:01
 * Author : 张树伟
 */
@Service(AwardsService.SERVICENAME)
public class AwardsServiceImpl extends BaseServiceImpl<Awards> implements AwardsService {

	@Resource(name=AwardsDao.DAONAME)
	private AwardsDao awardsDao;

	@Autowired
	private SystemDDLService systemDDLService;

	private Logger logger = Logger.getLogger(AwardsServiceImpl.class);
	
	@Override
	public BaseDao getBaseDao() {
		return this.awardsDao;
	}


	@Override
	public PageResult<Awards> getAwardsPageResult(BaseQuery baseQuery) {
		PageResult<Awards> awardsPageResult = null;
        SystemDDL systemDDL;
		try {
			awardsPageResult = this.awardsDao.getAwaPageResult(baseQuery);
			List<Awards> awardses = awardsPageResult.getRows();
			for (Awards awards : awardses) {
				systemDDL = systemDDLService.getSystenDDL("competitionView", awards.getCompetitionid());
				awards.setCompetitionView(systemDDL.getDdlName());
			}
			//对获奖信息按照获奖级别、获奖等级排序
			PageUtil.sortAwards(awardses);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return awardsPageResult;
	}

}
