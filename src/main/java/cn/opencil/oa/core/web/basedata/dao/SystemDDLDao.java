package cn.opencil.oa.core.web.basedata.dao;

import cn.opencil.oa.common.page.PageResult;
import cn.opencil.oa.core.base.dao.BaseDao;
import cn.opencil.oa.core.domain.SystemDDL;
import cn.opencil.oa.core.query.SystemDDLQuery;

import java.util.List;

/**
 * Project Name:SdutOA
 * File Name:SystemDDLDao.java
 * Date:2016-4-15下午8:33:18
 * Author : 王基伟
 * 数据字典的dao
 */
public interface SystemDDLDao extends BaseDao<SystemDDL> {

	PageResult<SystemDDL> getPageResultByKeyword(SystemDDLQuery baseQuery);

	Integer getCodeByKeyword(String keyword);

	void addDDL(SystemDDL systemDDL) throws Exception;

	List<SystemDDL> getDDLs(String keyword);

	SystemDDL getSystenDDL(String keyword,Integer ddlCode);
}
