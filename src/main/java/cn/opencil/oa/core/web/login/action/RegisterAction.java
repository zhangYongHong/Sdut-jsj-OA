package cn.opencil.oa.core.web.login.action;

import org.apache.commons.lang.StringUtils;
import org.hibernate.exception.DataException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.opencil.oa.core.base.action.BaseAction;
import cn.opencil.oa.core.domain.User;
import cn.opencil.oa.core.web.basedata.service.UserService;

/**
 * Project Name:SdutOA File Name:RegisterAction.java Date:2016-4-16下午3:38:45
 * Author : 王基伟
 * 
 */
@Controller("registerAction")
@Scope("prototype")
public class RegisterAction extends BaseAction<User> {

	private static final long serialVersionUID = 1L;

	@Autowired
	private UserService userService;

	/**
	 * 注册
	 * 
	 * @return
	 */
	public String register() {
		boolean flag = true;
		// 验证是否为空
		String employeenum = this.getModel().getEmployeenum();

		if (!StringUtils.isNotBlank(employeenum)) {
			this.addFieldError("uerror", "工号不能为空");
			flag = false;
		}

		String password = this.getModel().getPassword();

		if (!StringUtils.isNotBlank(password)) {
			this.addFieldError("perror", "密码不能为空");
			flag = false;
		}

		// 验证工号是否唯一
		User user = this.userService.validation(this.getModel().getEmployeenum());

		if (null != user) {
			this.addFieldError("uerror", "用户名已存在");
			flag = false;
		}

		if (flag) {
			User newUser = new User();
			BeanUtils.copyProperties(this.getModel(), newUser);
			try {
				this.userService.addEntry(newUser);
			} catch (DataException e) {

			}

		}

		return (flag == true) ? SUCCESS : "register";
	}

}
