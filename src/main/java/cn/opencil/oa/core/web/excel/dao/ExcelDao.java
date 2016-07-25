package cn.opencil.oa.core.web.excel.dao;

import java.util.ArrayList;
/**
 * Project Name:SdutOA File Name:ExcelDao.java Date:2016-4-20下午6:08:06 Author :
 * 王基伟
 * 
 */
public interface ExcelDao {

	public static final String DAONAME = "cn.opencil.oa.core.web.excel.dao.impl.ExcelDaoImpl";

	public ArrayList<String> getFieldDataNameExcel(ArrayList<String> titleList);

	public ArrayList<String> importFieldData(ArrayList<String> titleList);
}
