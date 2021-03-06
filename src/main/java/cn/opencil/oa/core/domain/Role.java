package cn.opencil.oa.core.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mnzero on 16-9-5.
 */
public class Role implements Serializable {
    private Long id; //编号
    private String role; //角色标识 程序中判断使用,如"admin"
    private String ddlId; //角色描述,UI界面显示使用
    private List<Long> resourceIds; //拥有的资源
    private String resourceIdsStr;
    private Boolean available = Boolean.FALSE; //是否可用,如果不可用将不会添加给用户

    public Role() {
    }

    public Role(String role, String ddlId, Boolean available) {
        this.role = role;
        this.ddlId = ddlId;
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDdlId() {
        return ddlId;
    }

    public void setDdlId(String ddlId) {
        this.ddlId = ddlId;
    }

    public List<Long> getResourceIds() {
        if(resourceIds == null) {
            resourceIds = new ArrayList<Long>();
        }
        return resourceIds;
    }

    public void setResourceIds(List<Long> resourceIds) {
        this.resourceIds = resourceIds;
    }

    public String getResourceIdsStr() {
        return resourceIdsStr;
    }

    public void setResourceIdsStr(String resourceIdsStr) {
        this.resourceIdsStr = resourceIdsStr;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (id != null ? !id.equals(role.id) : role.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", ddlId='" + ddlId + '\'' +
                ", resourceIds=" + resourceIds +
                ", available=" + available +
                '}';
    }
}

