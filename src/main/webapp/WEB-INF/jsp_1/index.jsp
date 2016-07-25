<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<!DOCTYPE>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>计算机科学与技术学院OA办公系统</title>
    <link rel="stylesheet" href="css/header.css">
    <script src="js/jquery.min.js"></script>
    <script src="js/js1.js"></script>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>计算机科学与技术学院OA系统</title>
    <link href="/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="/css/metisMenu.min.css" rel="stylesheet" type="text/css">
    <link href="/css/sb-admin-2.css" rel="stylesheet" type="text/css">
    <link href="/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <script src="/js/jquery.min.js" type="text/javascript"></script>
    <script src="/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="/js/metisMenu.min.js" type="text/javascript"></script>
    <script src="/js/sb-admin-2.js" type="text/javascript"></script>
    <script src="/js/calendar.js" type="text/javascript"></script>
    <script src="/js/WdatePicker.js" type="text/javascript"></script>

    <script src="/js/template.js" ></script>


    <style>
        .table-center td,th {text-align:center;}
        .table-no-line>tbody>tr>td {border-top:0}
        .breadcrumb { padding-top:15px;background-color: white; font-size: 12px;margin-bottom: 0}
        .page-header {margin-top: 20px}
    </style>
</head>
<body>
<div  class="form-group">
    <div class="navbar-header">
        <a class="navbar-brand" href="/index/index" style="font-size: 35px;color: #ac2925">计算机科学与技术学院OA办公系统</a>
    </div>
    <div class=" navbar-right" style="margin-left: 65%">
          <span style="size: 25px;"> 当前用户： <s:property value="#session.globleUser.employeenum"/>(<s:property value="#session.globleUser.userName"/>)</span>
          <span style="size: 25px;">  <a href="${pageContext.request.contextPath}/loginAction_signOut.action">退出</a></span>
    </div>
</div>
<div id="container">
    <div class="navbar-default sidebar" role="navigation" >
        <div class="sidebar-nav navbar-collapse">
            <ul class="nav" id="side-menu">
                <!--菜单-->
                <li>
                    <a href="#"><i class=""></i> 个人办公<span class=""></span></a>
                    <ul class="nav nav-second-level">
                        <li><a href="${pageContext.request.contextPath}/awardsAction_list.action" target="iframe">获奖管理</a></li>
                        <li><a href="${pageContext.request.contextPath}/tPAction_list.action" target="iframe">实践管理</a></li>
                        <li><a href="${pageContext.request.contextPath}/qPAction_list.action" target="iframe">试卷管理</a></li>
                    </ul>
                </li>
                <%
                    if(popedomCode.contains("abc")) {
                %>
                <li>
                    <a href="#"><i class=""></i> 系统管理<span class=""></span></a>
                    <ul class="nav nav-second-level">
                        <li><a href="${pageContext.request.contextPath}/userAction_list.action" target="iframe">用户列表</a></li>
                        <li><a href="${pageContext.request.contextPath}/userAction_addUI.action" target="iframe">添加用户</a></li>
                    </ul>
                </li>
                <%
                    }
                %>
                <li>
                    <a href="#"><i class=""></i> 个人设置<span class=""></span></a>
                    <ul class="nav nav-second-level">
                        <li><a href="userAction_personInfoUI.action" target="iframe">个人资料</a></li>
                        <li><a href="userAction_passWordUI.action" target="iframe">密码修改</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <div style="width: 990px; margin-left: 13%;">
        <iframe src="/welcome.html" width="1294" height="1000px" name="iframe" frameborder="no"
                scrolling="auto"></iframe>
    </div>
</div>
<div id="footer">
    © 2016 All rights Reserved 山东理工大学
</div>
</body>
</html>