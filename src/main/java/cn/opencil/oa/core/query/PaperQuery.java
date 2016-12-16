package cn.opencil.oa.core.query;


import org.apache.commons.lang3.StringUtils;

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
	private String author;
	private String particpants;

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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getParticpants() {
		return particpants;
	}

	public void setParticpants(String particpants) {
		this.particpants = particpants;
	}

	@Override
	public Map<String, Object> buildWhere() {

		if(StringUtils.isNotEmpty(this.getTeacher())){
			this.getWhereKV().put("teacher", this.getTeacher());
		}

		if (StringUtils.isNotEmpty(this.getSchoolYear())) {
			this.getWhereKV().put("schoolYear", this.getSchoolYear());
		}

		if (StringUtils.isNotEmpty(this.getAuthor())) {
			this.getWhereKV().put("author", author);
		}
		if (StringUtils.isNotEmpty(this.getParticpants())) {
			this.getWhereKV().put("particpants", particpants);
		}
		return this.getWhereKV();
	}


}
