<%--
  Created by IntelliJ IDEA.
  User: mnzero
  Date: 16-7-12
  Time: 下午2:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Supr admin</title>

    <link href="css/bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="css/bootstrap/bootstrap-responsive.min.css" rel="stylesheet" type="text/css"/>
    <link href="css/icons.css" rel="stylesheet" type="text/css"/>
    <!-- Main stylesheets -->
    <link href="css/main.css" rel="stylesheet" type="text/css"/>

    <!--<script type="text/javascript">-->
    <!--//adding load class to body and hide page-->
    <!--document.documentElement.className += 'loadstate';-->
    <!--</script>-->

</head>

<body>
<!-- loading animation -->
<div id="qLoverlay"></div>
<div id="qLbar"></div>


<div id="header">
    <div class="navbar">
        <div class="navbar-inner">
            <div class="container-fluid">
                <a class="brand" href="index.jsp"><img src="images/logo.png" alt="logo"/></a>
                <div class="nav-no-collapse">
                    <ul class="nav">
                        <li class="active"><a href="index.jsp"><span class="icon16 icomoon-icon-screen-2"></span>
                            仪表</a></li>
                        <!--信息相关模块-->
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <span class="icon16 icomoon-icon-mail-3"></span>信息 <span class="notification">8</span>
                            </a>
                            <ul class="dropdown-menu">
                                <li class="menu">
                                    <ul class="messages">
                                        <li class="header"><strong>Messages</strong> (10) emails and (2) PM</li>
                                        <li>
                                            <span class="icon"><span class="icon16 icomoon-icon-user-3"></span></span>
                                            <span class="name"><a data-toggle="modal" href="#myModal1"><strong>Sammy
                                                Morerira</strong></a><span class="time">35 min ago</span></span>
                                            <span class="msg">I have question about new function ...</span>
                                        </li>
                                        <li>
                                            <span class="icon avatar"><img src="images/avatar.jpg" alt=""/></span>
                                            <span class="name"><a data-toggle="modal" href="#myModal1"><strong>George
                                                Michael</strong></a><span class="time">1 hour ago</span></span>
                                            <span class="msg">I need to meet you urgent please call me ...</span>
                                        </li>
                                        <li>
                                            <span class="icon"><span class="icon16 icomoon-icon-mail-3"></span></span>
                                            <span class="name"><a data-toggle="modal"
                                                                  href="#myModal1"><strong>Ivanovich</strong></a><span
                                                    class="time">1 day ago</span></span>
                                            <span class="msg">I send you my suggestion, please look and ...</span>
                                        </li>
                                        <li class="view-all"><a href="#">View all messages <span
                                                class="icon16 icomoon-icon-arrow-right-8"></span></a></li>
                                    </ul>
                                </li>
                            </ul>
                        </li>
                    </ul>

                    <ul class="nav pull-right usernav">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <span class="icon16 icomoon-icon-bell-2"></span><span class="notification">3</span>
                            </a>
                            <ul class="dropdown-menu">
                                <li class="menu">
                                    <ul class="notif">
                                        <li class="header"><strong>Notifications</strong> (3) items</li>
                                        <li>
                                            <a href="#">
                                                <span class="icon"><span
                                                        class="icon16 icomoon-icon-user-3"></span></span>
                                                <span class="event">1 User is registred</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#">
                                                <span class="icon"><span class="icon16 icomoon-icon-comments-4"></span></span>
                                                <span class="event">Jony add 1 comment</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#">
                                                <span class="icon"><span
                                                        class="icon16 icomoon-icon-new-2"></span></span>
                                                <span class="event">admin Julia added post with a long description</span>
                                            </a>
                                        </li>
                                        <li class="view-all"><a href="#">View all notifications <span
                                                class="icon16 icomoon-icon-arrow-right-8"></span></a></li>
                                    </ul>
                                </li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle avatar" data-toggle="dropdown">
                                <img src="images/avatar.jpg" alt="" class="image"/>
                                <span class="txt"><s:property value="#session.globleUser.userName"/> </span>
                                <b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu">
                                <li class="menu">
                                    <ul>
                                        <li>
                                            <a href="userAction_updateUI.action?uid=<s:property value="#session.globleUser.uid"/>"><span
                                                    class="icon16 icomoon-icon-user-3"></span>个人信息</a>
                                        </li>
                                        <li>
                                            <a href="userAction_passWordUI.action"><span
                                                    class="icon16  icomoon-icon-locked-2"></span>密码修改</a>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/loginAction_signOut.action"><span
                                class="icon16 icomoon-icon-exit"></span> 登出</a></li>
                    </ul>
                </div><!-- /.nav-collapse -->
            </div>
        </div><!-- /navbar-inner -->
    </div><!-- /navbar -->

</div><!-- End #header -->


<div id="wrapper">

    <!--Responsive navigation button-->
    <div class="resBtn">
        <a href="#"><span class="icon16 minia-icon-list-3"></span></a>
    </div>
    <!--Sidebar content-->
    <div id="sidebar">

        <div class="sidenav">

            <div class="sidebar-widget" style="margin: -1px 0 0 0;">
                <h5 class="title" style="margin-bottom:0">Navigation</h5>
            </div><!-- End .sidenav-widget -->

            <div class="mainnav">
                <ul>
                    <li><a href="index.jsp"><span class="icon16 icomoon-icon-home"></span>首页</a></li>
                    <%
                        if (popedomCode.contains("abc")) {
                    %>
                    <li>
                        <a href="#"><span class="icon16 icomoon-icon-list-view-2"></span>系统管理</a>
                        <%--<ul class="sub">--%>
                        <%--<li><a href="forms.html"><span class="icon16 icomoon-icon-file"></span>Forms Stuff</a></li>--%>
                        <%--<li><a href="password.html"><span class="icon16 icomoon-icon-file"></span>Validation</a>--%>
                        <%--</li>--%>
                        <%--</ul>--%>
                    </li>
                    <%
                        }
                    %>
                    <li>

                        <a href="#"><span class="icon16 icomoon-icon-grid"></span>个人办公</a>
                        <ul class="sub">
                            <li>
                                <a href="#"><span class="icon16 icomoon-icon-arrow-right-2"></span>归档管理</a>
                                <ul class="sub">
                                    <li><a href="${pageContext.request.contextPath}/qPAction_list.action"><span
                                            class="icon16 icomoon-icon-arrow-right-2"></span>试卷归档管理</a>
                                    </li>
                                    <li><a href="${pageContext.request.contextPath}/tPAction_list.action"><span
                                            class="icon16 icomoon-icon-arrow-right-2"></span>实训归档管理</a>
                                    </li>
                                </ul>
                            </li>
                            <li><a href="#"><span class="icon16  icomoon-icon-king"></span>获奖详情管理</a></li>
                        </ul>
                    </li>
                    <%
                        if (popedomCode.contains("abc")) {
                    %>
                    <li>
                        <a href="#"><span class="icon16 icomoon-icon-users"></span>人员管理</a>
                        <ul class="sub">
                            <li><a href="userAction_list.action"><span class="icon16 icomoon-icon-address-2"></span>用户列表</a>
                            </li>
                            <li>
                                <a href="userAction_updateUI.action?uid=<s:property value="#session.globleUser.uid"/>"><span
                                        class="icon16 icomoon-icon-user-3"></span>个人信息</a></li>
                        </ul>
                    </li>
                    <%
                        }
                    %>
                </ul>
            </div>
        </div><!-- End sidenav -->
    </div><!-- End #sidebar -->
    <!--Body content-->
    <div id="content" class="clearfix">
        <div class="contentwrapper"><!--Content wrapper-->

            <div class="heading">

                <h3>个人信息</h3>

            </div><!-- End .heading-->

            <!-- Build page from here: -->
            <div class="row-fluid">

                <div class="span12">

                    <div class="page-header">
                        <h4>个人信息</h4>
                    </div>

                    <form class="form-horizontal seperator" action="userAction_update.action" method="post">
                        <div class="offset5">
                            <s:fielderror name="userError" cssStyle="color: crimson"/>
                        </div>
                        <div class="form-row row-fluid">
                            <div class="span12">
                                <div class="row-fluid">
                                    <label class="form-label span3" for="employeenum">工&nbsp&nbsp&nbsp号:</label>
                                    <input class="span4" id="employeenum" type="text" name="employeenum"
                                           value="<s:property value="#oldUser.employeenum"/>" readonly="readonly"/>
                                </div>
                            </div>
                        </div>

                        <div class="form-row row-fluid">
                            <div class="span12">
                                <div class="row-fluid">
                                    <label class="form-label span3" for="name">用户名:</label>
                                    <input class="span4" id="name" type="text" name="userName"
                                           value="<s:property value="#oldUser.userName"/>" readonly="readonly"/>
                                </div>
                            </div>
                        </div>
                        <%
                            if (popedomCode.contains("abc")) {
                        %>
                        <div class="form-row row-fluid">
                            <div class="row-fluid">
                                <label class="form-label span3">角&nbsp;&nbsp;&nbsp;色:</label>
                                <div class="span2">
                                    <s:select list="%{#session.roleList}" listKey="ddlCode" listValue="ddlName"
                                              name="rid" headerKey="0" headerValue="请选择"
                                              cssClass="select2-active"></s:select>
                                </div>
                            </div>
                        </div>
                        <div class="form-row row-fluid">
                            <div class="row-fluid">
                                <label class="form-label span3">系&nbsp;&nbsp;&nbsp;别:</label>
                                <div class="span2">
                                    <s:select list="%{#session.deptList}" listKey="ddlCode" listValue="ddlName"
                                              name="deptid" value="%{#oldUser.deptid}"></s:select>
                                </div>
                            </div>
                        </div>
                        <%
                        } else {
                        %>
                        <div class="form-row row-fluid">
                            <div class="row-fluid">
                                <label class="form-label span3">系&nbsp;&nbsp;&nbsp;别:</label>
                                <div class="span2">
                                    <s:select list="%{#session.deptList}" listKey="ddlCode" listValue="ddlName"
                                              name="deptid" headerValue="请选择" readonly="readonly"></s:select>
                                </div>
                            </div>
                        </div>
                        <%
                            }
                        %>
                        <div class="form-row row-fluid">
                            <div class="span12">
                                <div class="row-fluid">
                                    <label class="form-label span3" for="email">邮&nbsp&nbsp&nbsp箱:</label>
                                    <input class="span4" id="email" type="text" name="email"
                                           value="<s:property value="#oldUser.email"/>"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-row row-fluid">
                            <div class="span12">
                                <div class="row-fluid">
                                    <label class="form-label span3" for="phone">手机号:</label>
                                    <input class="span4" id="phone" type="text" name="phone"
                                           value="<s:property value="#oldUser.phone "/>"/>
                                </div>
                            </div>
                        </div>

                        <div class="form-row row-fluid">
                            <div class="span12">
                                <div class="row-fluid">
                                    <div class="form-actions">
                                        <div class="span3"></div>
                                        <div class="span4 controls">
                                            <input type="submit" class="btn btn-info marginR10" value="保存"/>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>


                    </form>

                </div><!-- End .span12 -->

            </div><!-- End .row-fluid -->

            <div class="modal fade hide" id="myModal1">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span
                            class="icon12 minia-icon-close"></span></button>
                    <h3>Chat layout</h3>
                </div>
                <div class="modal-body">
                    <ul class="messages">
                        <li class="user clearfix">
                            <a href="#" class="avatar">
                                <img src="images/avatar2.jpeg" alt=""/>
                            </a>
                            <div class="message">
                                <div class="head clearfix">
                                    <span class="name"><strong>Lazar</strong> says:</span>
                                    <span class="time">25 seconds ago</span>
                                </div>
                                <p>
                                    Time to go i call you tomorrow.
                                </p>
                            </div>
                        </li>
                        <li class="admin clearfix">
                            <a href="#" class="avatar">
                                <img src="images/avatar3.jpeg" alt=""/>
                            </a>
                            <div class="message">
                                <div class="head clearfix">
                                    <span class="name"><strong>Sugge</strong> says:</span>
                                    <span class="time">just now</span>
                                </div>
                                <p>
                                    OK, have a nice day.
                                </p>
                            </div>
                        </li>

                        <li class="sendMsg">
                            <form class="form-horizontal" action="#">
                                <textarea class="elastic" id="textarea1" rows="1" placeholder="Enter your message ..."
                                          style="width:98%;"></textarea>
                                <button type="submit" class="btn btn-info marginT10">Send message</button>
                            </form>
                        </li>

                    </ul>
                </div>
                <div class="modal-footer">
                    <a href="#" class="btn" data-dismiss="modal">Close</a>
                </div>
            </div>

        </div><!-- End contentwrapper -->
    </div><!-- End #content -->

</div><!-- End #wrapper -->

<!-- Le javascript
================================================== -->
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap/bootstrap.js"></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script>
<script type="text/javascript" src="js/jquery.mousewheel.js"></script>

<!-- Important Place before main.js  -->
<script type="text/javascript" src="js/jquery-ui.min.js"></script>
<script type="text/javascript" src="js/main.js"></script>


</body>
</html>

