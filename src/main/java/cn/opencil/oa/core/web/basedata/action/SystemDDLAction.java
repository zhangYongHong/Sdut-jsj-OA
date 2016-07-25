package cn.opencil.oa.core.web.basedata.action;


import org.hibernate.exception.DataException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.opencil.oa.common.page.PageResult;
import cn.opencil.oa.core.base.action.BaseAction;
import cn.opencil.oa.core.domain.SystemDDL;
import cn.opencil.oa.core.query.SystemDDLQuery;
import cn.opencil.oa.core.web.basedata.service.SystemDDLService;

/**
 * Project Name:SdutOA
 * File Name:SystemDDLAction.java
 * Date:2016-4-15下午8:35:50
 * Author : 王基伟
 *
 * 
 */
@Controller("systemDDLAction")
@Scope("prototype")
public class SystemDDLAction extends BaseAction<SystemDDL>{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private SystemDDLService systemDDLService;
	
	private SystemDDLQuery baseQuery = new SystemDDLQuery();
	
	public String save(){//ajax

		return SUCCESS;
	}
	
	private Long sid;
	
	public Long getSid() {
		return sid;
	}
	public void setSid(Long sid) {
		this.sid = sid;
	}

	public String list(){
		PageResult<SystemDDL> systemDDLs = this.systemDDLService.getPageResultByKeyword(baseQuery);

		//System.out.println(systemDDLs.size());
		return "";
	}
	
	public String delete(){
		
		SystemDDL ddl = this.systemDDLService.getEntryById(this.getSid());
		if(null!=ddl){
			this.addActionError("该竞赛项目下存在数据,不能删除!");
		}
		
		this.systemDDLService.deleteEntry(this.getSid());
		return "";
	}
	

}
