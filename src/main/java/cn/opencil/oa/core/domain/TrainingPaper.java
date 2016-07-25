package cn.opencil.oa.core.domain;

import java.io.Serializable;

/**
 * Project Name:SdutOA
 * File Name:TrainingPasper.java
 * Date:2016-4-19下午7:12:43
 * Author : 张树伟
 * 实训作业类
 */
public class TrainingPaper extends BasePaper implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long tid;//id,自增
    private int tnum;//试卷份数
    private String nature = "实践";//课程性质 (默认)

    public int getTnum() {
        return tnum;
    }

    public void setTnum(int tnum) {
        this.tnum = tnum;
    }

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

}