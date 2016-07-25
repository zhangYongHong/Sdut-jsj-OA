package cn.opencil.oa.core.domain;

import java.io.Serializable;

/**
 * Created by 张树伟 on 16-5-16.
 * 角色与权限关联表
 */
public class RolePopedom implements Serializable {
    private Integer rid; //角色
    private String popedomCode; //权限


    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getPopedomCode() {
        return popedomCode;
    }

    public void setPopedomCode(String popedomCode) {
        this.popedomCode = popedomCode;
    }
}
