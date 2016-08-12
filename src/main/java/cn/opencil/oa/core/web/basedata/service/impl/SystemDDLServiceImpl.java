package cn.opencil.oa.core.web.basedata.service.impl;

import cn.opencil.oa.common.page.PageResult;
import cn.opencil.oa.core.base.dao.BaseDao;
import cn.opencil.oa.core.base.service.impl.BaseServiceImpl;
import cn.opencil.oa.core.domain.SystemDDL;
import cn.opencil.oa.core.query.BaseQuery;
import cn.opencil.oa.core.web.basedata.dao.SystemDDLDao;
import cn.opencil.oa.core.web.basedata.service.SystemDDLService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLDataException;
import java.util.List;

/**
 * Project Name:SdutOA
 * File Name:SystemDDLServiceImpl.java
 * Date:2016-4-15下午8:35:17
 * Author : 王基伟
 */
@Service(SystemDDLService.SERVICENAME)
public class SystemDDLServiceImpl extends BaseServiceImpl<SystemDDL> implements SystemDDLService{

	@Resource(name=SystemDDLDao.DAONAME)
	private SystemDDLDao systemDDLDao;
	
	@Override
	public PageResult<SystemDDL> getPageResultByKeyword(BaseQuery baseQuery) {

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
