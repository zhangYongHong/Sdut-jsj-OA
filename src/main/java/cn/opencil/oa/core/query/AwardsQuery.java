package cn.opencil.oa.core.query;

import java.util.Map;

/**
 * Project Name:SdutOA
 * File Name:AwardsQuery.java
 * Date:2016-4-16下午4:21:18
 * Author : 张树伟
 */
public class AwardsQuery extends BaseQuery {
    private String employeenum;

    private String schoolYear;

    private Integer state;

    public void setEmployeenum(String employeenum) {
        this.employeenum = employeenum;
    }

    public String getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(String schoolYear) {
        this.schoolYear = schoolYear;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 根据条件构造where
     */
    @Override
    public Map<String, Object> buildWhere() {
        if (null != employeenum)
            this.getWhereKV().put("employeenum", employeenum);
        if (null != schoolYear)
            this.getWhereKV().put("schoolYear", schoolYear);
        if (null!= state) {
            this.getWhereKV().put("state", state);
        }
        return this.getWhereKV();
    }

}
