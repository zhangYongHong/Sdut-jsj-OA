package cn.opencil.oa.core.web.paper.service;

import cn.opencil.oa.common.page.PageResult;
import cn.opencil.oa.core.base.service.BaseService;
import cn.opencil.oa.core.domain.QuestionPaper;
import cn.opencil.oa.core.query.BaseQuery;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Project Name:SdutOA
 * File Name:QPService.java
 * Date:2016-4-19下午9:30:05
 * Author : 张树伟
 *
 */
public interface QPService  extends BaseService<QuestionPaper>{

	ArrayList<String> getFieldDataNameExcel();

	PageResult<QuestionPaper> getPageResultForQP(BaseQuery baseQuery);

	void uploadExcel(File uploadfile, String schoolYear);

    InputStream exportExcel(String schoolYear);

	String getExcelName(String schoolYear);
}
