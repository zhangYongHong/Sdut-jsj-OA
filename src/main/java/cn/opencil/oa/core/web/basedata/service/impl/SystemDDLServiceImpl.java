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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Project Name:SdutOA
 * File Name:SystemDDLServiceImpl.java
 * Date:2016-4-15下午8:35:17
 * Author : 张树伟
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

	@Override
	public Integer getNumberIsNotInDdlCode(String keyword) {
        List<SystemDDL> list = this.getDDLs(keyword);
        if (list != null && list.size() > 0) {
            List<Integer> l = new ArrayList<>();
            for (SystemDDL systemDDL : list) {
                l.add(systemDDL.getDdlCode());
            }
            Integer[] integers = l.toArray(new Integer[l.size()]);
            if (integers.length > 1) {
                Arrays.sort(integers);
                if (integers[0] == 1)
                    for (int i = 0; i < integers.length - 1; i++) {
                        if ((integers[i + 1] - integers[i]) > 1)
                            return integers[i] + 1;
                    }
                    return integers[integers.length - 1] + 1;
            } else {
                if (integers[0] == 1)
                    return 2;
            }
        }
        return 1;
	}

}
