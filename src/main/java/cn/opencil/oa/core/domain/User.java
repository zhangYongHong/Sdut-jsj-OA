package cn.opencil.oa.core.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Project Name:SdutOA
 * File Name:User.java
 * Date:2016-4-15下午12:37:11
 * Author : 王基伟
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long uid;
    private String employeenum;
    private String userName;//昵称
    private String password;
    private String salt; //加密密码的盐
    private String role;
    private Integer deptid;//系别
    private String phone;
    private String email;
    private String deptview;//页面显示
    private List<Long> roleIds; //拥有的角色列表
    private String roleIdsStr;
    private Boolean locked = Boolean.FALSE;


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getEmployeenum() {
        return employeenum;
    }

    public void setEmployeenum(String employeenum) {
        this.employeenum = employeenum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public String getDeptview() {
        return deptview;
    }

    public void setDeptview(String deptview) {
        this.deptview = deptview;
    }

    public List<Long> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Long> roleIds) {
        this.roleIds = roleIds;
    }

    public String getRoleIdsStr() {
        return roleIdsStr;
    }

    public void setRoleIdsStr(String roleIdsStr) {
        this.roleIdsStr = roleIdsStr;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public String getCredentialsSalt() {
        return employeenum + salt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (uid != null ? !uid.equals(user.uid) : user.uid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return uid != null ? uid.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", employeenum='" + employeenum + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", deptid=" + deptid +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", deptview='" + deptview + '\'' +
                ", roleIds=" + roleIds +
                ", locked=" + locked +
                '}';
    }
}
