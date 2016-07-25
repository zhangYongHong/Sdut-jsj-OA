package cn.opencil.oa.core.web.excel.service.impl;

import cn.opencil.oa.core.web.excel.dao.ExcelDao;
import cn.opencil.oa.core.web.excel.service.ExcelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * Project Name: SdutOA File Name: ExcelServiceImpl.java Date: 2016-5-3下午5:25:30
 * Author : 张树伟
 * 
 */
@Service(ExcelService.SERVICENAME)
public class ExcelServiceImpl implements ExcelService {

	@Resource(name = ExcelDao.DAONAME)
	private ExcelDao excelDao;

	@Override
	public ArrayList<String> getExcelByQPaper() {
		ArrayList<String> titleList = new ArrayList<>();
		titleList.add("序号");
		titleList.add("讲课老师");
		titleList.add("合班情况");
		titleList.add("课程名称");
		titleList.add("试题来源");
		titleList.add("考核方式");
		titleList.add("人数");
		titleList.add("试卷份数");
		titleList.add("试卷分析");
		titleList.add("考核大纲");
		titleList.add("监考记录");
		titleList.add("AB卷");
		titleList.add("标准答案");
		titleList.add("评分标准");
		titleList.add("成绩单");
		titleList.add("备注");
		titleList.add("橱号（归档号）");
		return excelDao.getFieldDataNameExcel(titleList);
	}

	@Override
	public ArrayList<String> getExcelByTPaper() {
		ArrayList<String> titleList = new ArrayList<>();
		titleList.add("序号");
		titleList.add("姓名");
		titleList.add("课程");
		titleList.add("班级");
		titleList.add("试题来源");
		titleList.add("考核方式");
		titleList.add("选课人数");
		titleList.add("试卷份数");
		titleList.add("课程性质");
		titleList.add("试卷分析");
		titleList.add("考核大纲");
		titleList.add("评分标准");
		titleList.add("成绩单");
		titleList.add("备注");
		titleList.add("橱窗号（归档号）");
		return excelDao.getFieldDataNameExcel(titleList);
	}

}
