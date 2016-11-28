package cn.opencil.oa.core.web.test.service;

import cn.opencil.oa.common.page.PageResult;
import cn.opencil.oa.core.base.service.BaseService;
import cn.opencil.oa.core.domain.TrainingPaper;
import cn.opencil.oa.core.query.BaseQuery;

import java.io.File;
import java.util.ArrayList;

/**
 * Project Name:SdutOA
 * File Name:TPService.java
 * Date:2016-4-19下午9:31:43
 * Author : 张树伟
 *
 */
public interface TPService extends BaseService<TrainingPaper> {

	ArrayList<String> getFieldDataNameExcel();

	ArrayList<ArrayList<String>> getFieldDataExcel(BaseQuery baseQuery);

	PageResult<TrainingPaper> getPageResultForTP(BaseQuery baseQuery);

	void uploadExcel(File f, String schoolYear);
}
