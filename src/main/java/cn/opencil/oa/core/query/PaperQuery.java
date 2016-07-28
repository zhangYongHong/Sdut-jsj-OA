package cn.opencil.oa.core.query;

import org.apache.commons.lang.StringUtils;

import java.util.Map;

/**
 * Project Name:SdutOA
 * File Name:PaperQuery.java
 * Date:2016-5-20下午2:28:54
 * Author : 张树伟
 *
 */
public class PaperQuery extends BaseQuery{

	private String teacher;
	private String schoolYear;

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getSchoolYear() {
		return schoolYear;
	}

	public void setSchoolYear(String schoolYear) {
		this.schoolYear = schoolYear;
	}

	@Override
	public Map<String, Object> buildWhere() {

		if(StringUtils.isNotBlank(this.getTeacher())){
			this.getWhereKV().put("teacher", this.getTeacher());
		}

		if (StringUtils.isNotBlank(this.getSchoolYear())) {
			this.getWhereKV().put("schoolYear", this.getSchoolYear());
		}
		return this.getWhereKV();
	}


}
