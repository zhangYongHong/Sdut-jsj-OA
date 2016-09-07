package cn.opencil.oa.core.web.shiro.filter;

import cn.opencil.oa.core.web.basedata.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Created by mnzero on 16-9-5.
 */
public class SysUserFilter extends PathMatchingFilter {

    @Autowired
    private UserService userService;

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {

        String employeenum = (String) SecurityUtils.getSubject().getPrincipal();
        request.setAttribute("user", userService.getUserByEmployeenum(employeenum));
        return true;
    }
}
