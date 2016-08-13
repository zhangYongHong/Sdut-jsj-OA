package cn.opencil.oa.core.web.login.action;

import cn.opencil.oa.common.util.ContantKey;
import cn.opencil.oa.core.base.action.BaseAction;
import cn.opencil.oa.core.domain.SystemDDL;
import cn.opencil.oa.core.domain.User;
import cn.opencil.oa.core.web.basedata.service.SystemDDLService;
import cn.opencil.oa.core.web.login.service.LoginService;
import cn.opencil.oa.core.web.role.service.UserRoleService;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * Project Name:SdutOA
 * File Name:LoginAction.java
 * Date:2016-5-15下午1:50:19
 * Author : 张树伟
 *
 */
@Controller
@Scope("prototype")
public class LoginAction extends BaseAction<User>{

	private static final long serialVersionUID = 1L;

	@Autowired
	private LoginService loginService;
	@Autowired
	private UserRoleService userRoleService;
    @Autowired
    private SystemDDLService systemDDLService;

	public String login(){
        User user = null;
        if(this.checkValue(this.getModel())) {
            return "login";
        }
        try {
            String employeenum = this.getModel().getEmployeenum();
            String passwd = this.getModel().getPassword();
            if (employeenum.length() >= 0 && employeenum.length() <= 6) {
                if (passwd.length() >= 0 && passwd.length() <= 15) {
                    user = this.loginService.authentication(employeenum, passwd);
                    if (this.checkValue(user)) {
                        this.addFieldError("loginError", "工号或密码错误！");
                        return "login";
                    }
                } else {
                    this.addFieldError("loginError", "您输入的密码有误！");
                    return "login";
                }
            } else {
                this.addFieldError("loginError", "您输入的用户名有误！");
                return "login";
            }
        } catch (Exception e) {
            this.addFieldError("loginError", "登陆错误！");
            return "login";
        }
        String popedomCode = "";
        try {
            popedomCode = userRoleService.getPopedomCode(user.getUid());
        } catch (Exception e) {
            this.addFieldError("loginError", "您的账号未分配角色，请联系管理员！");
            return "login";
        }
		HttpSession session = this.getRequest().getSession();
		session.setAttribute(ContantKey.GLOBLE_USER_INFO, user);
		session.setAttribute(ContantKey.GLOBLE_USER_ROLE, popedomCode);
        //角色
        this.loadSource("role");
        //系别
        this.loadSource("dept");
        //年纪
        this.loadSource("grade");

		return SUCCESS;
	}

    public String signOut() {
        HttpSession session = this.getRequest().getSession();
        session.removeAttribute(ContantKey.GLOBLE_USER_INFO);
        return "login";
    }
    public boolean loadSource(String valueName) {
        List<SystemDDL> sourceList = systemDDLService.getDDLs(valueName);
        if(null != sourceList) {
            ActionContext.getContext().getSession().put(valueName + "List", sourceList);
            return true;
        }
        return false;
    }
    private boolean checkValue(User user) {
        if(user != null) {
            if(user.getEmployeenum() == null || user.getEmployeenum().trim().equals("")) {
                this.addFieldError("loginEmError", "工号不能为空！");
                return true;
            }
            if(user.getPassword() == null || user.getPassword().trim().equals("")) {
                this.addFieldError("loginPSError", "密码不能为空！");
                return true;
            }
        } else {
            return true;
        }
        return false;

    }
}
