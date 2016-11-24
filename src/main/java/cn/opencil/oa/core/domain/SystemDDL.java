package cn.opencil.oa.core.domain;

import java.io.Serializable;

/**
 * Project Name:SdutOA
 * File Name:SystemDDL.java
 * Date:2016-4-15下午12:48:09
 * Author : 王基伟
 *
 */
public class SystemDDL implements Serializable{

	private static final long serialVersionUID = 1L;

	private String uuid;		//主键ID(自增长)
	private String keyword;		//数据类型
	private Integer ddlCode;	//数据项的code
	private String ddlName;		//数据项的value

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public Integer getDdlCode() {
		return ddlCode;
	}
	public void setDdlCode(Integer ddlCode) {
		this.ddlCode = ddlCode;
	}
	public String getDdlName() {
		return ddlName;
	}
	public void setDdlName(String ddlName) {
		this.ddlName = ddlName;
	}
	
}
