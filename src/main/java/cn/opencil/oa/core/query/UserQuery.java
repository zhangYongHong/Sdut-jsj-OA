package cn.opencil.oa.core.query;

import org.apache.commons.lang.StringUtils;

import java.util.Map;

/**
 * Created by 张树伟 on 16-5-9.
 */
public class UserQuery extends BaseQuery {
    private String username;
    private String employeenum;

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getEmployeenum() {
        return employeenum;
    }

    public void setEmployeenum(String nickname) {
        this.employeenum = nickname;
    }

    @Override
    public Map<String, Object> buildWhere() {
        if(StringUtils.isNotBlank(this.getUsername())) {
            this.getWhereKV().put("username", this.getUsername());
        }
        if(StringUtils.isNotBlank(this.getEmployeenum())) {
            this.getWhereKV().put("employeenum", this.getEmployeenum());
        }
        return this.getWhereKV();
    }
}
