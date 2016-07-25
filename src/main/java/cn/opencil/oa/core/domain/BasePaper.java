package cn.opencil.oa.core.domain;

import java.io.InputStream;

/**
 * Created by mnzero on 16-7-23.
 */
public class BasePaper {
    private static final long serialVersionUID = 1L;

    private String teacher;//老师
    private String className;//授课班级
    private String course;//课程名称
    private int psource;//试题来源 1.自拟 2.统一命题
    private int examineway;//考核方式  1.开卷  2.闭卷 3.答辩 4.大作业  5.上机
    private int num;//考核人数
    private int analyzes;//试卷分析    1有0无 //注意:analyze,在mysql中是关键字，会无法创建表，且无报错信息
    private int plan;//考试大纲           1有0无
    private int standard;//评分标准	1有0无
    private int score;//成绩单	1有0无
    private String comment; //备注
    private String fileNum; //归档号
    private String schoolYear; // 学年
    private String isChange; //修改标记
    private InputStream inputStream;//导出Excel

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getPsource() {
        return psource;
    }

    public void setPsource(int psource) {
        this.psource = psource;
    }

    public int getExamineway() {
        return examineway;
    }

    public void setExamineway(int examineway) {
        this.examineway = examineway;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getAnalyzes() {
        return analyzes;
    }

    public void setAnalyzes(int analyzes) {
        this.analyzes = analyzes;
    }

    public int getPlan() {
        return plan;
    }

    public void setPlan(int plan) {
        this.plan = plan;
    }

    public int getStandard() {
        return standard;
    }

    public void setStandard(int standard) {
        this.standard = standard;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
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
}
