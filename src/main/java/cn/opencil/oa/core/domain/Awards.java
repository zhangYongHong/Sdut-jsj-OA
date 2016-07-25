package cn.opencil.oa.core.domain;

import java.io.Serializable;

/**
 * Project Name:SdutOA
 * File Name:Awards.java
 * Date:2016-4-15下午12:58:29
 * Author : 王基伟
 *
 */
public class Awards implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long aid;	//id,自增长
	private Integer competitionid;//竞赛项目
	private String competitionview;//--------view
	private String achievement;//成果名称
	private Integer level;//获奖级别     1.国家级  2.省级  3.校级  4.院级
	private String levelview;//--------view
	private Integer grade;//获奖等级	1.特等奖  2.一等奖   3.二等奖   4.三等级
	private String gradeview;//--------view
	private String stuname;//参赛学生
	private Integer deptid;//专业      1.计算机科学与技术  2.软件工程   3.通信工程  4.数字媒体  5.基础部
	private String deptview;//--------view
	private String classe;//班级
	private String teacher;//指导老师
	private String atime;//获奖时间
	private String prizeunit;//颁奖单位
	
	private String comment;//备注
	private String uri;//附件存储



	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public Long getAid() {
		return aid;
	}
	public void setAid(Long aid) {
		this.aid = aid;
	}
	public Integer getCompetitionid() {
		return competitionid;
	}
	public void setCompetitionid(Integer competitionid) {
		this.competitionid = competitionid;
	}
	public String getCompetitionview() {
		return competitionview;
	}
	public void setCompetitionview(String competitionview) {
		this.competitionview = competitionview;
	}
	public String getAchievement() {
		return achievement;
	}
	public void setAchievement(String achievement) {
		this.achievement = achievement;
	}
	public Integer getLevel() {
		
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public String getLevelview() {
		
		switch (this.getLevel()) {
			// 1.国家级  2.省级  3.校级  4.院级
			case 1:levelview = "国家级";break;
			case 2:levelview = "省级";break;
			case 3:levelview = "校级";break;
			case 4:levelview = "院级";break;
			default:levelview = "";break;
		}
		return levelview;
	}
	public void setLevelview(String levelview) {
		this.levelview = levelview;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public String getGradeview() {
		
		switch (this.getGrade()) {
			// 1.特等奖  2.一等奖   3.二等奖   4.三等级
			case 1:gradeview = "特等奖";break;
			case 2:gradeview = "一等奖";break;
			case 3:gradeview = "二等奖";break;
			case 4:gradeview = "三等级";break;
			default:gradeview = "";break;
		}
		return gradeview;
	}
	public void setGradeview(String gradeview) {
		this.gradeview = gradeview;
	}
	public String getStuname() {
		return stuname;
	}
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}
	public Integer getDeptid() {
		return deptid;
	}
	public void setDeptid(Integer deptid) {
		this.deptid = deptid;
	}
	public String getDeptview() {
		//1.计算机科学与技术  2.软件工程  3.通信工程  4.数字媒体
		switch (this.getDeptid()) {
		case 1:
			deptview = "计算机科学与技术";break;
		case 2:
			deptview = "软件工程";break;
		case 3:
			deptview = "通信工程";break;
		case 4:
			deptview = "数字媒体";break;
		default:
			deptview = "";
			break;
		}
		
		return deptview;
	}
	public void setDeptview(String deptview) {
		this.deptview = deptview;
	}
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	
	public String getAtime() {
		return atime;
	}
	public void setAtime(String atime) {
		this.atime = atime;
	}
	public String getPrizeunit() {
		return prizeunit;
	}
	public void setPrizeunit(String prizeunit) {
		this.prizeunit = prizeunit;
	}
	
}
