package cn.opencil.oa.core.domain;

import java.sql.Date;

/**
 * Created with Sdut-jsj-OA.
 * Package: cn.opencil.oa.core.web.test.action
 * User: 张树伟
 * Date: 16-12-19
 * Time: 下午2:57
 */
public class Topics {
    private String uuid;
    private String name; // 项目名称
    private String type; // 类别
    private String principal; // 负责人
    private String member; // 课题组成员
    private Date startTime; // 立项时间
    private Date endTime; // 结题时间
    private String evaluate; // 结题评价
    private String gradation;// 项目层次
    private String schoolYear;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }

    public String getGradation() {
        return gradation;
    }

    public void setGradation(String gradation) {
        this.gradation = gradation;
    }

    public String getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(String schoolYear) {
        this.schoolYear = schoolYear;
    }

    @Override
    public String toString() {
        return "Topics{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", principal='" + principal + '\'' +
                ", member='" + member + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", evaluate='" + evaluate + '\'' +
                ", gradation='" + gradation + '\'' +
                '}';
    }
}
