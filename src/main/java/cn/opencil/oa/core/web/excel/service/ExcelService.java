package cn.opencil.oa.core.web.excel.service;

import java.util.ArrayList;

/**
 * Project Name: SdutOA File Name: ExcelService.java Date: 2016-5-3下午5:19:21
 * Author : 张树伟
 * 
 */

public interface ExcelService {
	String SERVICENAME = "cn.opencil.oa.core.web.excel.service.impl.ExcelServiceImpl";

	ArrayList<String> getExcelByQPaper();

	ArrayList<String> getExcelByTPaper();

    ArrayList<String> getExcelByAwards();

	ArrayList<String> getExcelByPaper();

	ArrayList<String> getExcelByTopics();
}
