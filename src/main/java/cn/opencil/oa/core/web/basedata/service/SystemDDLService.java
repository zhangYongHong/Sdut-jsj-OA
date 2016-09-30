package cn.opencil.oa.core.web.basedata.service;

import cn.opencil.oa.common.page.PageResult;
import cn.opencil.oa.core.base.service.BaseService;
import cn.opencil.oa.core.domain.SystemDDL;
import cn.opencil.oa.core.query.SystemDDLQuery;

import java.util.List;

/**
 * Project Name:SdutOA
 * File Name:SystemDDLService.java
 * Date:2016-4-15下午8:34:38
 * Author : 王基伟
 * 数据字典的Service
 */

public interface SystemDDLService extends BaseService<SystemDDL>{

	PageResult<SystemDDL> getPageResultByKeyword(SystemDDLQuery baseQuery);

	SystemDDL getSystenDDL(String keyword,Integer ddlCode);

	void addDDL(String keyword, SystemDDL systemDDL) throws Exception;
	
	List<SystemDDL> getDDLs(String keyword);

	/**
	 * 获取不在DdlCode范围中数
	 * @return
     * @param keyword
	 */
    Integer getNumberIsNotInDdlCode(String keyword);
}
