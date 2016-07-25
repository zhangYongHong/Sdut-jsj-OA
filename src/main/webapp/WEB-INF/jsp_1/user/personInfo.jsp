<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<html>
<head>
    <link href="css/table_add.css" rel="stylesheet" type="text/css">
    <title>个人信息</title>
</head>
<body>
<div id="container">
    <h3>个人信息</h3>
    <div style="margin-left:200px;">
        <label><s:fielderror name="userError" cssStyle="color: crimson"/></label>
        <s:form action="userAction_personInfo.action" method="POST">
            <table cellpadding="4" cellspacing="3">
                <s:hidden name="uid" value="%{#session.globleUser.uid}"/>
                <tr>
                    <td> 工号:&nbsp;</td>
                    <td>
                        <s:property value="%{#session.globleUser.employeenum}"/>
                        <s:hidden name="employeenum" value="%{#session.globleUser.employeenum}"/>
                    </td>
                </tr>
                <tr>
                    <td> 姓名:&nbsp;</td>
                    <td><s:property value="%{#session.globleUser.userName}"/></td>
                </tr>
                <tr>
                    <td> 系别:&nbsp;</td>
                    <td><s:property value="%{#session.globleUser.deptview}"></s:property>
                    </td>
                <tr>
                    <td> 邮箱:&nbsp;</td>
                    <td><s:textfield name="email" value="%{#session.globleUser.email}" cssClass="inputcss"/></td>
                </tr>
                <tr>
                    <td> 手机号:&nbsp;</td>
                    <td><s:textfield name="phone" value="%{#session.globleUser.phone}" cssClass="inputcss"/></td>
                </tr>

            </table>
            <table>
                <tr>
                <tr height="26px"></tr>
                <td width="44px;"></td>
                <td><s:submit cssStyle="margin-left: 20px;" cssClass="button" value="提交"></s:submit></td>
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
