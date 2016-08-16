package cn.opencil.oa.core.web.basedata.service.impl;

import cn.opencil.oa.common.page.PageResult;
import cn.opencil.oa.core.base.dao.BaseDao;
import cn.opencil.oa.core.base.service.impl.BaseServiceImpl;
import cn.opencil.oa.core.domain.SystemDDL;
import cn.opencil.oa.core.query.SystemDDLQuery;
import cn.opencil.oa.core.web.basedata.dao.SystemDDLDao;
import cn.opencil.oa.core.web.basedata.service.SystemDDLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Project Name:SdutOA
 * File Name:SystemDDLServiceImpl.java
 * Date:2016-4-15下午8:35:17
 * Author : 王基伟
 */
@Service
public class SystemDDLServiceImpl extends BaseServiceImpl<SystemDDL> implements SystemDDLService{

	@Autowired
	private SystemDDLDao systemDDLDao;
	
	@Override
	public PageResult<SystemDDL> getPageResultByKeyword(SystemDDLQuery baseQuery) {
		return this.systemDDLDao.getPageResultByKeyword(baseQuery);
	}

	@Override
	public SystemDDL getSystenDDL(String keyword, Integer ddlCode) {
		try {
			return this.systemDDLDao.getSystenDDL(keyword, ddlCode);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public BaseDao getBaseDao() {
		return systemDDLDao;
	}



	@Override
	public void addDDL(String keyword, SystemDDL systemDDL) throws Exception {
		
		//查询当前keyword的最大DDLcode
		Integer maxCode = this.getCodeByKeyword(keyword);
		systemDDL.setDdlCode((maxCode+1));
		systemDDL.setKeyword(keyword);
		this.systemDDLDao.addDDL(systemDDL);
		
	}

	public Integer getCodeByKeyword(String keyword) {

		return this.systemDDLDao.getCodeByKeyword(keyword);
	}

	@Override
	public List<SystemDDL> getDDLs(String keyword) {
		// TODO Auto-generated method stub
		return  this.systemDDLDao.getDDLs(keyword);
	}

}
