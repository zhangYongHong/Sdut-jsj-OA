package cn.opencil.oa.core.web.login.action;

import cn.opencil.oa.common.util.ContantKey;
import cn.opencil.oa.core.base.action.BaseAction;
import cn.opencil.oa.core.domain.SystemDDL;
import cn.opencil.oa.core.domain.User;
import cn.opencil.oa.core.web.basedata.service.SystemDDLService;
import cn.opencil.oa.core.web.basedata.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
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
 */
@Controller
@Scope("prototype")
public class LoginAction extends BaseAction<User> {

    private static final long serialVersionUID = 1L;
    @Autowired
    private SystemDDLService systemDDLService;
    @Autowired
    private UserService userService;

    public String login() {
        return "loginIn";
    }

    public String signIn() {
        User user = null;
        Subject currentUser = SecurityUtils.getSubject();
        try {
            String employeenum = this.getModel().getEmployeenum();
            String passwd = this.getModel().getPassword();
            UsernamePasswordToken token = new UsernamePasswordToken(employeenum, passwd);
            currentUser.login(token);
            user = userService.getUserByEmployeenum(employeenum);
        } catch (UnknownAccountException uae) {
            this.addFieldError("loginError", "用户名错误！");
            return "loginIn";
        } catch (IncorrectCredentialsException ice) {
            this.addFieldError("loginError", "密码错误！");
            return "loginIn";
        } catch (LockedAccountException lae) {
            this.addFieldError("loginError", "您的账号已锁定，请联系管理员解锁！");
            return "loginIn";
        } catch (ExcessiveAttemptsException eae) {
            this.addFieldError("loginError", "登陆错误！");
            return "loginIn";
        } catch (AuthenticationException e) {
            this.addFieldError("loginError", "登陆错误！");
            return "loginIn";
        }

        HttpSession session = this.getRequest().getSession();
        session.setAttribute(ContantKey.GLOBLE_USER_INFO, user);
        //角色
        this.loadSource("role");
        //系别
        this.loadSource("dept");
        //获奖等级
        this.loadSource("grade");
        //获奖级别
        this.loadSource("level");
        //班级
        this.loadSource("classe");
        //竞赛项目
        this.loadSource("competitionView");
        this.loadSource("state");
        this.loadSource("available");
        this.loadSource("schoolYear");

        return SUCCESS;
    }

    public String signOut() {
        HttpSession session = this.getRequest().getSession();
        session.removeAttribute(ContantKey.GLOBLE_USER_INFO);
        return "loginIn";
    }

    public boolean loadSource(String valueName) {
        List<SystemDDL> sourceList = systemDDLService.getDDLs(valueName);
        if (null != sourceList) {
            ActionContext.getContext().getSession().put(valueName + "List", sourceList);
            return true;
        }
        return false;
    }
}
