package cn.opencil.oa.core.web.awards.service.impl;

import cn.opencil.oa.common.page.PageResult;
import cn.opencil.oa.common.util.PageUtil;
import cn.opencil.oa.core.base.dao.BaseDao;
import cn.opencil.oa.core.base.service.impl.BaseServiceImpl;
import cn.opencil.oa.core.domain.Awards;
import cn.opencil.oa.core.domain.SystemDDL;
import cn.opencil.oa.core.query.BaseQuery;
import cn.opencil.oa.core.web.activiti.service.ActivitiService;
import cn.opencil.oa.core.web.awards.dao.AwardsDao;
import cn.opencil.oa.core.web.awards.service.AwardsService;
import cn.opencil.oa.core.web.basedata.service.SystemDDLService;
import org.activiti.engine.TaskService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * Project Name:SdutOA
 * File Name:AwardsServiceImpl.java
 * Date:2016-4-15下午1:38:01
 * Author : 张树伟
 */
@Service(AwardsService.SERVICENAME)
@Transactional(readOnly = false)
public class AwardsServiceImpl extends BaseServiceImpl<Awards> implements AwardsService {

	@Resource(name=AwardsDao.DAONAME)
	private AwardsDao awardsDao;

	@Autowired
	private SystemDDLService systemDDLService;
	@Autowired
	private ActivitiService activitiService;
	private TaskService taskService;
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
			for (int i = 0; i < awardses.size(); i++) {
				Awards awards = awardses.get(i);
				systemDDL = systemDDLService.getSystenDDL("competitionView", awards.getCompetitionid());
				if (systemDDL != null)
					awards.setCompetitionView(systemDDL.getDdlName());
				else
					awards.setCompetitionView("");
			}
			//对获奖信息按照获奖级别、获奖等级排序
			PageUtil.sortAwards(awardses);
			awardsPageResult.setRows(PageUtil.getListByStuname(awardses));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return awardsPageResult;
	}

    @Override
    public void startProcess(Long id) {
        Awards awards = awardsDao.getEntryById(id);
		if (awards != null) {
			awards.setState(1);
			awardsDao.updateEntry(awards);
			//获取业务对象的类名作为key
			String processDefinitionKey = awards.getClass().getSimpleName();
			String businessKey = processDefinitionKey + ":" + id.toString();
			//设置流程变量
			HashMap<String, Object> value = new HashMap<>();
			//classType: 业务对象类型
			//objId:业务ID
			value.put("classType", processDefinitionKey);
			value.put("objId", awards.getAid());
            //业务对象与流程建立关系
			activitiService.start(processDefinitionKey, businessKey, value);
		}
    }

}
