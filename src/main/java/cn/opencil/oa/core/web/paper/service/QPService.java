package cn.opencil.oa.core.web.paper.service;

import cn.opencil.oa.common.page.PageResult;
import cn.opencil.oa.core.base.service.BaseService;
import cn.opencil.oa.core.domain.QuestionPaper;
import cn.opencil.oa.core.query.BaseQuery;

import java.io.File;
import java.util.ArrayList;

/**
 * Project Name:SdutOA
 * File Name:QPService.java
 * Date:2016-4-19下午9:30:05
 * Author : 王基伟
 *
 */
public interface QPService  extends BaseService<QuestionPaper>{

	String SERVICENAME = "cn.opencil.oa.core.web.paper.service.impl.QPServiceImpl";

	ArrayList<String> getFieldDataNameExcel();

	ArrayList<ArrayList<String>> getFieldDataExcel(BaseQuery baseQuery);

	PageResult<QuestionPaper> getPageResultForQP(BaseQuery baseQuery);

	void uploadExcel(File uploadfile);
}
