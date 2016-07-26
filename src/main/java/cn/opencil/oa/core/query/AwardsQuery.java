package cn.opencil.oa.core.query;

import cn.opencil.oa.common.util.DateUtil;

import java.util.Date;
import java.util.Map;

/**
 * Project Name:SdutOA
 * File Name:AwardsQuery.java
 * Date:2016-4-16下午4:21:18
 * Author : 王基伟
 *
 */
public class AwardsQuery extends BaseQuery{


	private String fileNum;
	private String schoolYear;

	public String getFileNum() {
		return fileNum;
	}

	public void setFileNum(String fileNum) {
		this.fileNum = fileNum;
	}

	public String getSchoolYear() {
		return schoolYear;
	}

	public void setSchoolYear(String schoolYear) {
		this.schoolYear = schoolYear;
	}

	/**
	 * 根据条件构造where
	 */
	@Override
	public Map<String, Object> buildWhere() {
		if(null != fileNum) {
			this.getWhereKV().put("fileNum", this.getFileNum());
		}

		if(null != schoolYear){
			this.getWhereKV().put("schoolYear", this.schoolYear);
		}else{
			this.getWhereKV().put("schoolYear", DateUtil.dateToYear(new Date()));
		}

		return this.getWhereKV();
	}

}
