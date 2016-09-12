package cn.opencil.oa.core.web.basedata.action;


import cn.opencil.oa.common.page.PageResult;
import cn.opencil.oa.core.base.action.BaseAction;
import cn.opencil.oa.core.domain.SystemDDL;
import cn.opencil.oa.core.query.SystemDDLQuery;
import cn.opencil.oa.core.web.basedata.service.SystemDDLService;
import com.opensymphony.xwork2.ActionContext;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Project Name:SdutOA
 * File Name:SystemDDLAction.java
 * Date:2016-4-15下午8:35:50
 * Author : 张树伟
 *
 * 
 */
@Controller
@Scope("prototype")
public class SystemDDLAction extends BaseAction<SystemDDL>{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private SystemDDLService systemDDLService;

	@RequiresPermissions("systemDDLAction:view")
	public String list(){
		SystemDDLQuery systemDDLQuery = new SystemDDLQuery();
		if (this.getModel().getKeyword() == null)
			systemDDLQuery.setKeyword("role");
		else
			systemDDLQuery.setKeyword(this.getModel().getKeyword());
		try {
			PageResult<SystemDDL> systemDDLs = this.systemDDLService.getPageResultByKeyword(systemDDLQuery);
			ActionContext.getContext().put("systemDDLs", systemDDLs);
		} catch (Exception e) {

		}
		return LISTACTION;
	}

	@RequiresPermissions("systemDDLAction:add")
	public String addUI() {
		return addUI;
	}

	public String add() {
		try {
			systemDDLService.addEntry(this.getModel());
		} catch (Exception e) {

		}
		return REDIRECT;
	}

	@RequiresPermissions("systemDDLAction:update")
	public String updateUI() {
		try {
			SystemDDL systemDDL = systemDDLService.getEntryById(this.getModel().getSid());
			ActionContext.getContext().put("systemDDL", systemDDL);
		} catch (Exception e) {

		}
		return updateUI;
	}

	@RequiresPermissions("systemDDLAction:update")
	public String update() {
		try {
			systemDDLService.updateEntry(this.getModel());
		} catch (Exception e) {

		}
		return REDIRECT;
	}

	@RequiresPermissions("systemDDLAction:delete")
	public String delete(){
		try {
			systemDDLService.deleteEntry(this.getModel().getSid());
		} catch (Exception e) {

		}
		return REDIRECT;
	}

//=======================================================================


}
