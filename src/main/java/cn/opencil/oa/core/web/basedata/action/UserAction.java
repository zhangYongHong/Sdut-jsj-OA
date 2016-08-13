package cn.opencil.oa.core.web.basedata.action;

import cn.opencil.oa.common.page.PageResult;
import cn.opencil.oa.core.base.action.BaseAction;
import cn.opencil.oa.core.domain.User;
import cn.opencil.oa.core.domain.UserRole;
import cn.opencil.oa.core.query.UserQuery;
import cn.opencil.oa.core.web.basedata.service.UserService;
import cn.opencil.oa.core.web.role.service.UserRoleService;
import com.opensymphony.xwork2.ActionContext;
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
    private static Long tempUid;
    private static String employeenum;
    private String oldPassword;
    private String newPassword;
    private int rid = 3;
    private UserRole userRole;
    private UserQuery userQuery = new UserQuery();
    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;

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
        String employeenum = user.getEmployeenum();
        user.setPassword("000000");

        if (!this.checkInfo(user)) {

            User userByDataBase = userService.getUserByEmployeenum(employeenum);
            if (userByDataBase != null) {
                this.addFieldError("userError", "该工号已存在，请重新输入！");
                return INPUT;
            }

            try {
                this.userService.addEntry(user);
                if (user.getUid() != null) {
                    userRole = userRoleService.getUserRole(user.getUid());
                    if (userRole == null) {
                        userRole = new UserRole();
                        userRole.setUid(user.getUid());
                        userRole.setRid(rid);
                        userRoleService.addEntry(userRole);
                    } else {
                        userRole.setUid(user.getUid());
                        userRole.setRid(rid);
                        userRoleService.updateEntry(userRole);
                    }
                }
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

    public String updateUI() {
        tempUid = this.getModel().getUid();
        this.loadingInfoForUser();
        return "updateUI";
    }

    public String update() {
        User user = this.getModel();
        try {
            User userByDB = userService.getUserByEmployeenum(employeenum);
            String popedomCode = "";
            if (!this.checkNull(this.getModel().getEmail())) {
                if (!this.checkEmail(this.getModel().getEmail())) {
                    this.loadingInfoForUser();
                    this.addFieldError("userError", "邮箱格式错误");
                    return "updateUI";
                }
            }
            if (!this.checkNull(this.getModel().getPhone()))
                if (!this.checkPhone(this.getModel().getPhone())) {
                    this.loadingInfoForUser();
                    this.addFieldError("userError", "手机号格式错误");
                    return "updateUI";
                }
            popedomCode = userRoleService.getPopedomCode(userByDB.getUid());
            userRole = this.userRoleService.getUserRole(tempUid);
            if (null == userRole) {
                userRole = new UserRole();
                userRole.setUid(tempUid);
                userRole.setRid(rid);
                try {
                    userRoleService.addEntry(userRole);
                } catch (Exception e) {
                    this.loadingInfoForUser();
                    this.addFieldError("userError", "用户权限设置失败！");
                    return "updateUI";
                }
            }
            if (0 == rid) {
                this.loadingInfoForUser();
                this.addFieldError("userError", "用户权限设置失败！");
                return "updateUI";
            }
            userRole.setRid(rid);
            userRoleService.updateEntry(userRole);
            userByDB.setDeptid(user.getDeptid());
            userByDB.setEmail(user.getEmail());
            userByDB.setPhone(user.getPhone());
            this.userService.updateEntry(userByDB);
            this.loadingInfoForUser();
            //若用户为管理员权限，则将跳转到列表页面，否则返回更新成功信息
            if (popedomCode.contains("abc") || popedomCode.contains("ab")) {
                return "redirect";
            }
            this.addFieldError("userError", "信息更新成功！");
            return "updateUI";
        } catch (Exception e) {
            this.loadingInfoForUser();
            this.addFieldError("userError", "信息保存失败！");
            return "updateUI";
        }
    }

    public String delete() {
        Long uid = this.getModel().getUid();
        this.userService.deleteEntry(uid);
        this.userRoleService.deleteEntry(uid);
        return "redirect";
    }

    public String resetPassword() {
        Long uid = this.getModel().getUid();
        User user = null;
        try {
            user = userService.getEntryById(uid);
            user.setPassword("000000");
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
        String password = userByDB.getPassword();

        if(this.checkPassword(oldPassword, "原密码")) return "passWordUI";
        if(this.checkPassword(newPassword, "新密码")) return "passWordUI";
        if(this.checkPassword(this.getModel().getPassword(), "确认密码")) return "passWordUI";

        if(!password.equals(oldPassword)) {
            this.addFieldError("userError", "原密码输入错误！");
            return "passWordUI";
        }
        if(!user.getPassword().equals(newPassword)) {
            this.addFieldError("userError","两次输入的密码一致！");
            return "passWordUI";
        }
        try {
            userByDB.setPassword(user.getPassword());
            userService.updateEntry(userByDB);
        } catch (Exception e) {
            this.addFieldError("userError", "密码修改失败！");
            return "passWordUI";
        }
        this.addFieldError("userError", "密码修改成功！");
        return "passWordUI";
    }
    private boolean checkInfo(User user) {
        if(this.checkNull(user.getEmployeenum())) {
            this.addFieldError("userError", "工号不能为空！");
            return true;
        }
        if(user.getEmployeenum().length() != user.getEmployeenum().trim().length()) {
            this.addFieldError("userError", "工号中不能包含空格！");
            return true;
        }
        if(!this.checkEmployeenum(user.getEmployeenum())) {
            this.addFieldError("userError", "工号只能包含数字！");
            return true;
        }
        if(this.checkNull(user.getUserName())) {
            this.addFieldError("userError", "用户名不能为空！");
            return true;
        }
        if(!this.checkUserName(user.getUserName())) {
            this.addFieldError("userError", "用户名只能为汉字");
            return true;
        }
        if(user.getUserName().trim().length() != user.getUserName().length()) {
            this.addFieldError("userError", "用户名中不能包含空格！");
            return true;
        }
        if(!checkNull(user.getEmail()))
            if(!this.checkEmail(user.getEmail())) {
                this.addFieldError("userError", "邮箱格式错误");
                return true;
            }
        if(!checkNull(user.getPhone()))
            if(!this.checkPhone(user.getPhone())) {
                this.addFieldError("userError", "手机号格式错误");
                return true;
            }
        return false;
    }
    private void loadingInfoForUser() {
        User oldUser = userService.getEntryById(tempUid);
        employeenum = oldUser.getEmployeenum();

        if (oldUser == null) {
        } else {
            ActionContext.getContext().put("oldUser", oldUser);
        }
    }


    private boolean checkNull(String value) {
        return value.trim().equals("") || (value == null);
    }

    private boolean checkUserName(String userName) {
        String check = "^[\\u4e00-\\u9fa5]*$";
        Pattern userNameRegular = Pattern.compile(check);
        Matcher matcher = userNameRegular.matcher(userName);
        return matcher.matches();
    }
    private boolean checkPassword(String password, String name) {
        if(this.checkNull(password)) {
            this.addFieldError("userError", name + "不能为空！");
            return true;
        }
        if(password.length() != password.trim().length()) {
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
}
