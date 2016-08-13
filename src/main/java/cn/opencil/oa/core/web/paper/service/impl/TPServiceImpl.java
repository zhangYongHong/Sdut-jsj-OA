package cn.opencil.oa.core.web.paper.service.impl;

import cn.opencil.oa.common.page.PageResult;
import cn.opencil.oa.common.util.DateUtil;
import cn.opencil.oa.common.util.ExcelFileGeneratorUtil;
import cn.opencil.oa.common.util.PageUtil;
import cn.opencil.oa.core.base.dao.BaseDao;
import cn.opencil.oa.core.base.service.impl.BaseServiceImpl;
import cn.opencil.oa.core.domain.TrainingPaper;
import cn.opencil.oa.core.query.BaseQuery;
import cn.opencil.oa.core.web.excel.service.ExcelService;
import cn.opencil.oa.core.web.paper.dao.TPDao;
import cn.opencil.oa.core.web.paper.service.TPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Project Name:SdutOA File Name:TPServiceImpl.java Date:2016-4-20下午2:06:00
 * Author : 张树伟
 * 
 */
@Service
public class TPServiceImpl extends BaseServiceImpl<TrainingPaper> implements
		TPService {

	@Autowired
	private TPDao tpDao;

	@Autowired
	private ExcelService excelService;

	@Override
	public BaseDao getBaseDao() {
		return tpDao;
	}

	@Override
	public ArrayList<String> getFieldDataNameExcel() {
		return excelService.getExcelByTPaper();
	}

	@Override
	public ArrayList<ArrayList<String>> getFieldDataExcel(BaseQuery baseQuery) {

		Collection<TrainingPaper> entrys = this.tpDao
				.getEntrysByQuery(baseQuery);
		List<TrainingPaper> tps = new ArrayList<>(entrys);
		ArrayList<ArrayList<String>> datas = new ArrayList<ArrayList<String>>();

		if (null != entrys && tps.size() > 0) {
			for (int i = 0; i < tps.size(); i++) {

				TrainingPaper tp = tps.get(i);
				ArrayList<String> oneData = new ArrayList<String>();

				oneData.add("" + (i + 1));
				oneData.add(tp.getTeacher());
				oneData.add(tp.getCourse());
				oneData.add(tp.getClassName());
				oneData.add(PageUtil.getPsourceToString(tp.getPsource()));
				oneData.add(PageUtil.getExaminewayToString(tp.getExamineway()));
				oneData.add(tp.getNum() + "");
				oneData.add(tp.getTnum() + "");
				oneData.add(tp.getNature());
				oneData.add((tp.getAnalyzes() == 1) ? "有" : "无");
				oneData.add((tp.getPlan() == 1) ? "有" : "无");
				oneData.add((tp.getStandard() == 1) ? "有" : "无");
				oneData.add((tp.getScore() == 1) ? "有" : "无");
				oneData.add(tp.getComment());
				oneData.add(tp.getFileNum());

				datas.add(oneData);
			}
		}

		return datas;
	}

	@Override
	public PageResult<TrainingPaper> getPageResultForTP(BaseQuery baseQuery) {
		PageResult<TrainingPaper> paperPageResult = null;
		paperPageResult = tpDao.getPageResult(baseQuery);
		List paperList = paperPageResult.getRows();
		PageUtil.sortListForQP(paperList);
		return paperPageResult;
	}

	@Override
	public void uploadExcel(File f) {
		if (null != f) {
			String schoolYear = DateUtil.groupSchoolYear();
			List<TrainingPaper> list = ExcelFileGeneratorUtil.getTrainingPaperForExcel(f);
			String fileNum = "";

			for (TrainingPaper tp : list) {
				fileNum = PageUtil.getFileNum(tp.getClassName());
				tp.setFileNum(fileNum);
				tp.setSchoolYear(schoolYear);
				this.addEntry(tp);
			}
		}
	}

}
