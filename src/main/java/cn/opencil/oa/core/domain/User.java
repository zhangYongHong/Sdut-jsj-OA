package cn.opencil.oa.core.domain;

import java.io.Serializable;

/**
 * Project Name:SdutOA
 * File Name:User.java
 * Date:2016-4-15下午12:37:11
 * Author : 王基伟
 */
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long uid;
	private String employeenum;
	private String userName;//昵称
	private String password;
	private String role;
	private Integer deptid;//系别
	private String phone;
	private String email;
	private String deptview;//页面显示

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
		if(this.getDeptid() != null) {
			switch (this.getDeptid()) {
				case 1:
					deptview = "计算机科学与技术";
					break;
				case 2:
					deptview = "软件工程";
					break;
				case 3:
					deptview = "通信工程";
					break;
				case 4:
					deptview = "数字媒体";
					break;
				case 5:
					deptview = "基础部";
					break;
				default:
					deptview = "";
					break;
			}
		} else {
			this.deptview = "";
		}
		return deptview;
	}

	public void setDeptview(String deptview) {
		this.deptview = deptview;
	}
}
