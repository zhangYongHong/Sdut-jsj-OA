package cn.opencil.oa.core.web.test.dao;

import cn.opencil.oa.core.base.dao.BaseDao;
import cn.opencil.oa.core.domain.QuestionPaper;
import cn.opencil.oa.core.query.BaseQuery;

import java.util.Collection;

/**
 * Project Name:SdutOA
 * File Name:QPDao.java
 * Date:2016-4-19下午9:29:37
 * Author : 张树伟
 *
 */
public interface QPDao extends BaseDao<QuestionPaper>{

	Collection<QuestionPaper> getEntrysByQuery(BaseQuery baseQuery);
}
