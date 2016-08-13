package cn.opencil.oa.core.interceptor;

import com.opensymphony.xwork2.ActionContext;

import cn.opencil.oa.common.util.ContantKey;
import cn.opencil.oa.core.domain.User;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;



/**
 * Project Name:SdutOA
 * File Name:LoginInterceptor.java
 * Date:2016-5-16下午9:09:10
 * Author : 张树伟
 * 登录拦截
 */
@Controller
@Scope("prototype")
public class LoginInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;

	/**
	 * 拦截未登录状态的所有操作
	 */
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {

		User user = (User) ActionContext.getContext().getSession().get(ContantKey.GLOBLE_USER_INFO);

		if(user == null|| user.equals("")){
			return "login";//跳转到登录页面
		}
		return invocation.invoke();//放行

	}


}
