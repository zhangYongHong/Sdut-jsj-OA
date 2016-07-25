<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
    <title>用户表</title>
    <link href="css/table.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="container">
    你当前的位置:
    <h3>用户信息列表</h3>
    <s:form id="from_1" action="userAction_list.action" method="post">
        <div id="txt">
            <s:textfield name="userQuery.username" id="from_username" placeholder="姓名"/>
            <input type="submit" value="查询" id="button">
        </div>
    </s:form>
    <br>

    <table width="1000" border="1" cellspacing="0" cellpadding="0">

        <tr bgcolor="#e6eff5" style="font-weight: bold;">

            <td height="51">序号</td>

            <td>工号</td>

            <td>用户名</td>

            <td>角色</td>

            <td>系别</td>

            <td>手机号</td>

            <td>邮件</td>

            <td colspan="2">操作</td>
            <td>密码重置</td>
        </tr>
        <s:iterator value="#userPapers.rows" status="i">

            <tr bgcolor="#f0f6fa">

                <td width="94" height="39"><s:property value="#i.index+1"/></td>

                <td width="132"><s:property value="employeenum"/></td>

                <td width="91"><s:property value="userName"/></td>

                <td width="80"><s:property value="role"/></td>
                
                <td width="144"><s:property value="deptview"/></td>

                <td width="152"><s:property value="phone"/></td>

                <td width="177"><s:property value="email"/></td>

                <td width="52"><a href="userAction_updateUI.action?uid=<s:property value="uid"/>">修改</a></td>

                <td width="57"><a href="userAction_delete.action?uid=<s:property value="uid"/>" onclick="return confirm('你确定要删除？')">删除</a></td>
                <td width="80"><a href="userAction_resetPassword.action?uid=<s:property value="uid"/>" onclick="return confirm('重置后的密码为000000？')">重置</a></td>
            </tr>
        </s:iterator>
    </table>
    <br> <br>
    <div id="under">
        <s:hidden id="a" name="userQuery.username" value=""/>
        <div class="page_normal">
            <a href="
                <s:url action="userAction_list">
                    <s:param name="userQuery.currentPage">1</s:param>
                </s:url>">首页</a>
            <a href="
                <s:url action="userAction_list">
                    <s:param name="userQuery.currentPage">
                      ${userQuery.currentPage-1<=1?1:userQuery.currentPage-1}
                    </s:param>
                </s:url>">上一页</a>
            <a href="<s:url action="userAction_list">
                       <s:param name="userQuery.currentPage">${userQuery.currentPage+1>=userPapers.totalPages?userPapers.totalPages:userQuery.currentPage+1}</s:param>
                     </s:url>">下一页</a>
            <a href="
                <s:url action="userAction_list">
                    <s:param name="userQuery.currentPage">
                        ${userPapers.totalPages}
                    </s:param>
                </s:url>"> 尾页</a>
            <p><s:property value="%{#userPapers.currentPage}"/>
                /<s:property value="%{#userPapers.totalPages}"/>页</p>
        </div>

    </div>
</div>
</div>
</body>
</html>
