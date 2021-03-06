package cn.opencil.oa.core.domain;

import java.io.File;
import java.io.InputStream;
import java.io.Serializable;

/**
 * Project Name:SdutOA
 * File Name:Awards.java
 * Date:2016-4-15下午12:58:29
 * Author : 张树伟
 *
 */
public class Awards implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long aid;	//id,自增长
	private long id; //用于排序是确定第一位的数字
	private String idView;// 序号
	private Integer competitionid;//竞赛项目
	private String competitionView;
	private String achievement;//成果名称
	private Integer level;//获奖级别     1.国家级  2.省级  3.校级  4.院级
	private Integer grade;//获奖等级	1.特等奖  2.一等奖   3.二等奖   4.三等级
	private String stuname;//参赛学生
	private String specialty;//专业      1.计算机科学与技术  2.软件工程   3.通信工程  4.数字媒体  5.基础部
	private String classes;//班级
	private String teacher;//指导老师
	private String atime;//获奖时间
	private String prizeunit;//颁奖单位
	private String comment;//备注
	private String fileNum; //归档号
	private String schoolYear; // 学年
	private String isChange; //修改标记
	private InputStream inputStream;//导出Excel
	private Integer state; //0.初始录入 1. 开始审批 2.审批通过 3.驳回 4.重新调整 5.重新提交 6.取消重新提交
    private String postil;//审批意见
	private String employeenum; //申请人对应工号
	private String annex; // 附件
	private File annexFile;

	public String getAnnex() {
		return annex;
	}

	public void setAnnex(String annex) {
		this.annex = annex;
	}

	public Long getAid() {
		return aid;
	}

	public void setAid(Long aid) {
		this.aid = aid;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIdView() {
		return idView;
	}

	public void setIdView(String idView) {
		this.idView = idView;
	}

	public Integer getCompetitionid() {
		return competitionid;
	}

	public void setCompetitionid(Integer competitionid) {
		this.competitionid = competitionid;
	}

	public String getCompetitionView() {
		return competitionView;
	}

	public void setCompetitionView(String competitionView) {
		this.competitionView = competitionView;
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

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public String getStuname() {
		return stuname;
	}

	public void setStuname(String stuname) {
		this.stuname = stuname;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

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

	public String getIsChange() {
		return isChange;
	}

	public void setIsChange(String isChange) {
		this.isChange = isChange;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getPostil() {
		return postil;
	}

	public void setPostil(String postil) {
		this.postil = postil;
	}

	public String getEmployeenum() {
		return employeenum;
	}

	public void setEmployeenum(String employeenum) {
		this.employeenum = employeenum;
	}

	public File getAnnexFile() {
		return annexFile;
	}

	public void setAnnexFile(File annexFile) {
		this.annexFile = annexFile;
	}

	public Awards clone() {
		Awards awards = new Awards();
		awards.setAid(this.aid);
		awards.setId(this.id);
		awards.setIdView(this.idView);
		awards.setCompetitionid(this.competitionid);
		awards.setCompetitionView(this.competitionView);
		awards.setAchievement(this.achievement);
		awards.setLevel(this.level);
		awards.setGrade(this.grade);
		awards.setStuname(this.stuname);
		awards.setSpecialty(this.specialty);
		awards.setClasses(this.classes);
		awards.setTeacher(this.teacher);
		awards.setAtime(this.atime);
		awards.setPrizeunit(this.prizeunit);
		awards.setComment(this.comment);
		awards.setFileNum(this.fileNum);
		awards.setSchoolYear(this.schoolYear);
		awards.setIsChange(this.isChange);
		awards.setInputStream(this.inputStream);
		awards.setState(this.state);
        awards.setPostil(this.postil);
		awards.setEmployeenum(this.employeenum);
		awards.setAnnex(this.annex);
		awards.setAnnexFile(this.annexFile);
		return awards;
	}

}
