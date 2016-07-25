package cn.opencil.oa.core.web.excel.dao.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import cn.opencil.oa.core.web.excel.dao.ExcelDao;

/**
 * Project Name:SdutOA
 * File Name:ExcelDaoImpl.java
 * Date:2016-5-3下午6:30:18
 * Author : 张树伟
 */
@Repository(ExcelDao.DAONAME)
public class ExcelDaoImpl implements ExcelDao {

	@Override
	public ArrayList<String> getFieldDataNameExcel(ArrayList<String> titleList) {
		ArrayList<String> fieldDataName = new ArrayList<String>();
		for(String str : titleList) {
			fieldDataName.add(str);
		}
		return fieldDataName;
	}

	/**
	 *  功能 ：导入excel 解析获取里面的数据
	 * @param titleList
	 * @return
     */
	@Override
	public ArrayList<String> importFieldData(ArrayList<String> titleList) {
		ArrayList<String> fieldDataName = new ArrayList<String>();
		for(String str : titleList) {
			fieldDataName.add(str);
		}
		return fieldDataName;
	}
	
}
