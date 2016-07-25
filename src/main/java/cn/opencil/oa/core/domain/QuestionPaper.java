package cn.opencil.oa.core.domain;

import java.io.Serializable;

/**
 * Project Name:SdutOA
 * File Name:QuestionPaper.java
 * Date:2016-4-19下午7:12:14
 * Author : 张树伟
 * 试卷类   (含注意点)
 */
public class QuestionPaper extends BasePaper implements Serializable {


    private static final long serialVersionUID = 1L;

    private Long qid;//id
    private int pnum;//试卷份数
    private int invigilation;//监考记录   1有0无

    private int ab;//AB卷     1有0无
    private int answer;//标准答案	1有0无

    public Long getQid() {
        return qid;
    }

    public void setQid(Long qid) {
        this.qid = qid;
    }

    public int getPnum() {
        return pnum;
    }

    public void setPnum(int pnum) {
        this.pnum = pnum;
    }

    public int getInvigilation() {
        return invigilation;
    }

    public void setInvigilation(int invigilation) {
        this.invigilation = invigilation;
    }

    public int getAb() {
        return ab;
    }

    public void setAb(int ab) {
        this.ab = ab;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }
}
