<%--
  Created by IntelliJ IDEA.
  User: mnzero
  Date: 16-7-12
  Time: 下午3:52
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


    <link href="css/bootstrap/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="css/icons.css" rel="stylesheet" type="text/css"/>
    <!-- Plugin stylesheets -->
    <link href="plugins/uniform/uniform.default.css" type="text/css" rel="stylesheet"/>

    <!-- Main stylesheets -->
    <link href="css/main.css" rel="stylesheet" type="text/css"/>

    <!--<script type="text/javascript">-->
    <!--//adding load class to body and hide page-->
    <!--document.documentElement.className += 'loadstate';-->

    <!--</script>-->
    <!---->
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

                <h3>密码修改</h3>

            </div><!-- End .heading-->

            <!-- Build page from here: Usual with <div class="row-fluid"></div> -->

            <div class="row-fluid">

                <div class="span12">

                    <div class="box">

                        <div class="title">

                            <h4>
                                <span>密码修改</span>
                            </h4>

                        </div>
                        <div class="content">

                            <form class="form-horizontal" id="form-validate" action="userAction_passWord.action"
                                  method="post">
                                <div class="offset5">
                                    <s:fielderror name="userError" cssStyle="color: crimson"/>
                                </div>
                                <s:hidden name="employeenum" value="%{#session.globleUser.employeenum}"/>
                                <div class="form-row row-fluid">
                                    <div class="span12">
                                        <div class="row-fluid">
                                            <label class="form-label span3">原密码</label>
                                            <div class="span9 controls">
                                                <input class="span12" name="oldPassword" type="password"
                                                       placeholder="请输入原密码"/>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-row row-fluid">
                                    <div class="span12">
                                        <div class="row-fluid">
                                            <label class="form-label span3">新密码</label>
                                            <div class="span9 controls">
                                                <input class="span12" id="password" name="newPassword" type="password"
                                                       placeholder="请输入新密码"/>
                                                <input class="span12" id="passwordConfirm" name="password"
                                                       type="password" placeholder="重新输入新密码"/>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-row row-fluid">
                                    <div class="span12">
                                        <div class="row-fluid">
                                            <div class="form-actions">
                                                <div class="span3"></div>
                                                <div class="span9 controls">
                                                    <input type="submit" class="btn marginR10" value="保存"/>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form>

                        </div>

                    </div><!-- End .box -->

                </div><!-- End .span12 -->

            </div><!-- End .row-fluid -->
            <!-- Page end here -->
        </div><!-- End contentwrapper -->
    </div><!-- End #content -->

</div><!-- End #wrapper -->

<!-- Le javascript
================================================== -->
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap/bootstrap.js"></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script>
<script type="text/javascript" src="js/jquery.mousewheel.js"></script>

<!-- Load plugins -->
<script type="text/javascript" src="plugins/qtip/jquery.qtip.min.js"></script>
<script type="text/javascript" src="plugins/flot/jquery.flot.tooltip_0.4.4.js"></script>

<script type="text/javascript" src="plugins/fullcalendar/fullcalendar.min.js"></script>
<script type="text/javascript" src="plugins/prettify/prettify.js"></script>

<script type="text/javascript" src="plugins/watermark/jquery.watermark.min.js"></script>
<script type="text/javascript" src="plugins/maskedinput/jquery.maskedinput-1.3.min.js"></script>
<script type="text/javascript" src="plugins/ibutton/jquery.ibutton.min.js"></script>
<script type="text/javascript" src="plugins/stepper/ui.stepper.js"></script>
<script type="text/javascript" src="plugins/color-picker/colorpicker.js"></script>
<script type="text/javascript" src="plugins/timeentry/jquery.timeentry.min.js"></script>
<script type="text/javascript" src="plugins/select/select2.min.js"></script>
<script type="text/javascript" src="plugins/dualselect/jquery.dualListBox-1.3.min.js"></script>
<script type="text/javascript" src="plugins/tiny_mce/jquery.tinymce.js"></script>
<script type="text/javascript" src="plugins/validate/jquery.validate.min.js"></script>

<script type="text/javascript" src="plugins/touch-punch/jquery.ui.touch-punch.min.js"></script>

<!-- Init plugins -->
<script type="text/javascript" src="js/statistic.js"></script><!-- Control graphs ( chart, pies and etc) -->

<!-- Important Place before main.js  -->
<script type="text/javascript" src="js/jquery-ui.min.js"></script>
<script type="text/javascript" src="js/main.js"></script>


</body>
</html>

