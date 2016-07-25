package cn.opencil.oa.core.web.paper.dao;

import java.util.Collection;

import cn.opencil.oa.core.base.dao.BaseDao;
import cn.opencil.oa.core.domain.TrainingPaper;
import cn.opencil.oa.core.query.BaseQuery;

/**
 * Project Name:SdutOA
 * File Name:TPDao.java
 * Date:2016-4-19下午9:29:44
 * Author : 张树伟
 *
 */
public interface TPDao  extends BaseDao<TrainingPaper>{

	String DAONAME = "cn.opencil.oa.core.web.paper.dao.impl.TPDaoImpl";

	Collection<TrainingPaper> getEntrysByQuery(BaseQuery baseQuery);
}
