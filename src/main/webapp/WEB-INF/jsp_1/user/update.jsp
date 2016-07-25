<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<link href="css/table_add.css" rel="stylesheet" type="text/css">
<html>
<head>
    <title>用户信息</title>
</head>
<body>
<div id="container">
    <h3>用户信息</h3>
    <div style="margin-left:200px;">
        <s:form action="userAction_update.action" method="POST">
            <label><s:fielderror name="userError" cssStyle="color: crimson"/> </label>
            <table cellpadding="4" cellspacing="3">
                <tr>
                    <td> 工号:&nbsp;</td>
                    <td>
                        <s:property value="%{#oldUser.employeenum}"/>
                        <s:set name="employeenum" value="%{#oldUser.employeenum}"/>
                    </td>
                </tr>
                <tr>
                    <td> 姓名:&nbsp;</td>
                    <td><s:property value="%{#oldUser.userName}"/></td>
                    <s:hidden name="userName" value="%{#oldUser.userName}"/>
                </tr>
                <%--<tr>--%>
                    <%--<td> 新密码:&nbsp;</td>--%>
                    <%--<td><s:password name="password" cssClass="inputcss"/></td>--%>
                <%--</tr>--%>
                <%--<s:hidden name="password" value="111111"/>--%>
                <tr>

                    <td> 角色:&nbsp;</td>
                    <td><s:select list="%{#session.roleList}" listKey="ddlCode" listValue="ddlName" name="rid" headerKey="0" headerValue="请选择"
                                  value="rid"></s:select></td>
                </tr>
                <tr>
                    <td> 邮箱:&nbsp;</td>
                    <td><s:textfield name="email" value="%{#oldUser.email}" cssClass="inputcss"/></td>
                </tr>
                <tr>
                    <td> 手机号:&nbsp;</td>
                    <td><s:textfield name="phone" value="%{#oldUser.phone}" cssClass="inputcss"/></td>
                </tr>
                <tr>
                    <td> 系别:&nbsp;</td>
                    <td><s:select list="%{#session.deptList}" listKey="ddlCode" listValue="ddlName" name="deptid"
                                  value="%{#oldUser.deptid}"></s:select></td>
                </tr>
            </table>
            <table>
                <tr>
                <tr height="26px"></tr>
                <td width="44px;"></td>
                <td><s:submit cssStyle="margin-left: 48px;" cssClass="button" value="提交"></s:submit></td>
                <td width="60px;"></td>
                <td></td>
                <td><s:reset cssClass="button" value="重置"></s:reset></td>
                </tr>
            </table>
        </s:form>
    </div>
</div>
</body>
</html>
