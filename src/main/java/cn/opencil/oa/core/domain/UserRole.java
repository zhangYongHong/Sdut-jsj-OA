package cn.opencil.oa.core.domain;

import java.io.Serializable;

/**
 * Created by 张树伟 on 16-5-16.
 * 用户与权限关联表
 */
public class UserRole implements Serializable {
    private Long uid;   //用户id
    private Integer rid; //角色

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }
}
