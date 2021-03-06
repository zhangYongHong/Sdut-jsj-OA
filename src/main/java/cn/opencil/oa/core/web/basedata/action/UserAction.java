package cn.opencil.oa.core.web.basedata.action;

import cn.opencil.oa.common.page.PageResult;
import cn.opencil.oa.common.util.PasswordHelper;
import cn.opencil.oa.core.base.action.BaseAction;
import cn.opencil.oa.core.domain.User;
import cn.opencil.oa.core.query.UserQuery;
import cn.opencil.oa.core.web.basedata.service.UserService;
import cn.opencil.oa.core.web.role.service.RoleService;
import com.opensymphony.xwork2.ActionContext;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Project Name:SdutOA
 * File Name:UserAction.java
 * Date:2016-5-10下午1:39:44
 * Author : 张树伟
 */
@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {

    private static final long serialVersionUID = 1L;

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PasswordHelper passwordHelper;

    private String oldPassword;
    private String newPassword;
    private int rid = 3;
    private UserQuery userQuery = new UserQuery();

    public String list() {
        PageResult<User> userPageResult = this.userService
                .getUserPageResult(userQuery);
        ActionContext.getContext().put("userPapers", userPageResult);
        return listAction;
    }

    public String addUI() {
        return addUI;
    }

    public String add() {
        User user;
        user = this.getModel();
        user.setPassword("000000");
        passwordHelper.encryptPassword(user);
        if (!this.checkInfo(user)) {
            try {
                user.setRoleIdsStr(user.getRole());
                Long[] longs = new Long[]{Long.parseLong(user.getRole())};
                user.setRole(roleService.getRoleName(longs));
                this.userService.addEntry(user);
            } catch (Exception e) {
                e.printStackTrace();
                this.addFieldError("userError", "用户信息保存失败！");
                return INPUT;
            }
            this.addFieldError("userError", "用户信息保存成功！");
            return "redirect";
        } else {
            return INPUT;
        }
    }

    public String updateAdminUI() {
        User user = userService.getEntryById(this.getModel().getUid());
        ActionContext.getContext().put("oldUser", user);
        return "updateAdminUI";
    }

    public String updateAdmin() {
        User user = this.getModel();
        user.setRole(roleService.getOne(Long.parseLong(user.getRoleIdsStr())).getRole());
        user.setDeptid(user.getDeptid());
        this.userService.updateEntry(user);
        return "redirect";
    }

    public String updateUI() {
        User user = userService.getEntryById(this.getModel().getUid());
        ActionContext.getContext().put("oldUser", user);
        return "updateUI";
    }

    public String update() {
        User user = this.getModel();
        try {
//            if (StringUtils.isNotEmpty(this.getModel().getEmail())) {
//                if (!this.checkEmail(this.getModel().getEmail())) {
//                    this.addFieldError("userError", "邮箱格式错误");
//                    return "updateUI";
//                }
//            }
//            if (StringUtils.isNotEmpty(this.getModel().getPhone())) {
//                if (!this.checkPhone(this.getModel().getPhone())) {
//                    this.addFieldError("userError", "手机号格式错误");
//                    return "updateUI";
//                }
//            }
            this.userService.updateEntry(user);
            this.loadingInfoForUser(user.getUid());
            this.addFieldError("userError", "信息更新成功！");
            return "updateUI";
        } catch (Exception e) {
            this.loadingInfoForUser(user.getUid());
            this.addFieldError("userError", "信息保存失败！");
            return "updateUI";
        }
    }

    public String delete() {
        Long uid = this.getModel().getUid();
        this.userService.deleteEntry(uid);
        return "redirect";
    }

    public String resetPassword() {
        Long uid = this.getModel().getUid();
        User user = null;
        try {
            user = userService.getEntryById(uid);
            user.setPassword("000000");
            passwordHelper.encryptPassword(user);
            userService.updateEntry(user);
        } catch (Exception e) {
            return "redirect";
        }
        return "redirect";
    }

    public String passWordUI() {
        return "passWordUI";
    }

    public String passWord() {
        User user = this.getModel();
        User userByDB = userService.getUserByEmployeenum(user.getEmployeenum());
        if (this.checkPassword(newPassword, "新密码")) return "passWordUI";
        if (this.checkPassword(this.getModel().getPassword(), "确认密码")) return "passWordUI";

        if (!user.getPassword().equals(newPassword)) {
            this.addFieldError("userError", "两次输入的密码一致！");
            return "passWordUI";
        }
        try {
            userByDB.setPassword(newPassword);
            passwordHelper.encryptPassword(userByDB);
            userService.updateEntry(userByDB);
        } catch (Exception e) {
            this.addFieldError("userError", "密码修改失败！");
            return "passWordUI";
        }
        this.addFieldError("userError", "密码修改成功！");
        return "passWordUI";
    }

    private boolean checkInfo(User user) {
        if (!StringUtils.isNotEmpty(user.getEmployeenum())) {
            this.addFieldError("userError", "工号不能为空！");
            return true;
        }
        if (!this.checkEmployeenum(user.getEmployeenum())) {
            this.addFieldError("userError", "工号只能包含数字！");
            return true;
        }
        if (!StringUtils.isNotEmpty(user.getUserName())) {
            this.addFieldError("userError", "用户名不能为空！");
            return true;
        }
        if (!this.checkUserName(user.getUserName())) {
            this.addFieldError("userError", "用户名只能为汉字");
            return true;
        }
        if (user.getUserName().trim().length() != user.getUserName().length()) {
            this.addFieldError("userError", "用户名中不能包含空格！");
            return true;
        }
        if (StringUtils.isNotEmpty(user.getEmail()))
            if (!this.checkEmail(user.getEmail())) {
                this.addFieldError("userError", "邮箱格式错误");
                return true;
            }
        if (StringUtils.isNotEmpty(user.getPhone()))
            if (!this.checkPhone(user.getPhone())) {
                this.addFieldError("userError", "手机号格式错误");
                return true;
            }
        return false;
    }

    private void loadingInfoForUser(Long uid) {
        User oldUser = userService.getEntryById(uid);
        ActionContext.getContext().put("oldUser", oldUser);
    }

    private boolean checkUserName(String userName) {
        String check = "^[\\u4e00-\\u9fa5]*$";
        Pattern userNameRegular = Pattern.compile(check);
        Matcher matcher = userNameRegular.matcher(userName);
        return matcher.matches();
    }

    private boolean checkPassword(String password, String name) {
        if (!StringUtils.isNotEmpty(password)) {
            this.addFieldError("userError", name + "不能为空！");
            return true;
        }
        if (password.length() != password.trim().length()) {
            this.addFieldError("userError", name + "中不能包含空格");
        }
        return false;
    }

    private boolean checkEmployeenum(String employeenum) {
        String check = "^[0-9]*$";
        Pattern employeenumRegular = Pattern.compile(check);
        Matcher matcher = employeenumRegular.matcher(employeenum);
        return matcher.matches();
    }

    private boolean checkEmail(String email) {
        String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern emailRegular = Pattern.compile(check);
        Matcher matcher = emailRegular.matcher(email);
        return matcher.matches();
    }

    private boolean checkPhone(String phone) {
        String check = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
        Pattern phoneRegular = Pattern.compile(check);
        Matcher matcher = phoneRegular.matcher(phone);
        return matcher.matches();
    }

    //=====================================================================

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public UserQuery getUserQuery() {
        return userQuery;
    }

    public void setUserQuery(UserQuery userQuery) {
        this.userQuery = userQuery;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

}
