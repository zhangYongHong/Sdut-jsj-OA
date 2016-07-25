package cn.opencil.oa.core.web.paper.dao;

import java.util.Collection;

import cn.opencil.oa.core.base.dao.BaseDao;
import cn.opencil.oa.core.domain.QuestionPaper;
import cn.opencil.oa.core.query.BaseQuery;

/**
 * Project Name:SdutOA
 * File Name:QPDao.java
 * Date:2016-4-19下午9:29:37
 * Author : 王基伟
 *
 */
public interface QPDao extends BaseDao<QuestionPaper>{

	public static final String DAONAME = "cn.opencil.oa.core.web.paper.dao.impl.QPDaoImpl";
	
	public Collection<QuestionPaper> getEntrysByQuery(BaseQuery baseQuery);
}
