package cn.opencil.oa.core.web.basedata.dao;

import java.util.List;

import cn.opencil.oa.common.page.PageResult;
import cn.opencil.oa.core.base.dao.BaseDao;
import cn.opencil.oa.core.domain.SystemDDL;
import cn.opencil.oa.core.query.BaseQuery;

/**
 * Project Name:SdutOA
 * File Name:SystemDDLDao.java
 * Date:2016-4-15下午8:33:18
 * Author : 王基伟
 * 数据字典的dao
 */
public interface SystemDDLDao extends BaseDao<SystemDDL> {

	String DAONAME = "cn.opencil.oa.core.web.basedata.dao.impl.SystemDDLDaoImpl";

	PageResult<SystemDDL> getPageResultByKeyword(BaseQuery baseQuery);

	Integer getCodeByKeyword(String keyword);

	void addDDL(SystemDDL systemDDL) throws Exception;

	List<SystemDDL> getDDLs(String keyword);

	SystemDDL getSystenDDL(String keyword,Integer ddlCode);
}
