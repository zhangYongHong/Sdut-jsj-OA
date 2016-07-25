<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<html>
<head>
    <style>
        h3 {
            text-align: center;
        }

        #container {
            width: 800px;
            height: 800px;
        }

        textarea {
            resize: none;
            border-left: solid 1px #bababa;
            border-top: solid 1px #bababa;
            border-right: solid 1px #e9e9e9;
            border-bottom: solid 1px #e9e9e9;
            text-indent: 8px;
            border-radius: 3px;
        }

        .inputcss {
            width: 280px;
            height: 32px;
            border-left: solid 1px #bababa;
            border-top: solid 1px #bababa;
            border-right: solid 1px #e9e9e9;
            border-bottom: solid 1px #e9e9e9;
            text-indent: 8px;
            border-radius: 3px;
        }

        .button {
            width: 107px;
            height: 35px;
            color: #fff;
            font-size: 14px;
            text-align: center;
            font-weight: bold;
            cursor: pointer;
            border-radius: 1px;
            background-color: #24adab;
            border: none;
        }
    </style>
</head>
<body>
<div id="container">
    <h3>密码修改</h3>
    <div style="margin-left:200px;">
        <label><s:fielderror value="userError" cssStyle="color: crimson"/></label>
        <s:form action="userAction_passWord.action" method="POST">
            <table cellpadding="4" cellspacing="3">
                <s:hidden name="employeenum" value="%{#session.globleUser.employeenum}"/>
                <tr>
                    <td> 原密码:&nbsp;</td>
                    <td><s:password name="oldPassword" cssClass="inputcss"/></td>
                </tr>

                <tr>
                    <td> 新密码:&nbsp;</td>
                    <td><s:password name="newPassword" cssClass="inputcss"/></td>
                </tr>
                <tr>
                    <td> 确认密码:&nbsp;</td>
                    <td><s:password name="password" cssClass="inputcss"/></td>
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
