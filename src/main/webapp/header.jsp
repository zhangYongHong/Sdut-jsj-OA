<%--
  Created by IntelliJ IDEA.
  User: mnzero
  Date: 16-7-26
  Time: 下午1:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<!-- loading animation -->
<div id="qLoverlay"></div>
<div id="qLbar"></div>

<div id="header">
    <div class="navbar">
        <div class="navbar-inner">
            <div class="container-fluid">
                <a class="brand" href="index.jsp">协同办公系统.<span class="slogan">CS</span></a>
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

</div>
<!-- End #header -->

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
                        <ul class="sub">
                            <li>
                                <a href="#"><span class="icon16 icomoon-icon-list-view"></span>流程管理</a>
                                <ul class="sub">
                                    <li><a href="${pageContext.request.contextPath}/activitiAction_list.action"><span
                                            class="icon16 icomoon-icon-arrow-right-2"></span>流程列表</a></li>
                                    <li><a href="${pageContext.request.contextPath}/activitiAction_newProcessUI.action"><span
                                            class="input-small"/><span class="icon16 icomoon-icon-arrow-right-2"></span>流程部署</a>
                                    </li>
                                    <li><a href="#"><span class="input-small"/><span
                                            class="icon16 icomoon-icon-arrow-right-2"></span>运行的中流程</a></li>
                                </ul>
                            </li>
                            <li>
                                <a href="#"><span class="icon16 icomoon-icon-list-view"></span>字典管理</a>
                                <ul class="sub">
                                    <li><a href="${pageContext.request.contextPath}/systemDDLAction_list.action"><span class="icon16 icomoon-icon-arrow-right-2"></span>字典列表</a></li>
                                    <li><a href="#"><span class="icon16 icomoon-icon-arrow-right-2"></span>字典添加</a></li>
                                </ul>
                            </li>
                            <li>
                                <a href="#"><span class="icon16 icomoon-icon-list-view"></span>角色管理</a>
                                <ul class="sub">
                                    <li><a href="#"><span class="icon16 icomoon-icon-arrow-right-2"></span>角色列表</a></li>
                                    <li><a href="#"><span class="icon16 icomoon-icon-arrow-right-2"></span>角色添加</a></li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                    <%
                        }
                    %>
                    <li>
                        <a href="#"><span class="icon16 icomoon-icon-grid"></span>个人办公</a>
                        <ul class="sub">
                            <li>
                                <a href="#"><span class="icon16 icomoon-icon-list-view"></span>我的任务</a>
                                <ul class="sub">
                                    <li><a href="${pageContext.request.contextPath}/tasksAction_taskList.action"><span
                                            class="icon16 icomoon-icon-arrow-right-2"></span>待办任务<span
                                            class="notification">3</span></a>
                                    </li>
                                    <li><a href="#"><span
                                            class="icon16 icomoon-icon-arrow-right-2"></span>已办任务</a>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <a href="#"><span class="icon16 icomoon-icon-list-view"></span>归档管理</a>
                                <ul class="sub">
                                    <li><a href="${pageContext.request.contextPath}/qPAction_list.action"><span
                                            class="icon16 icomoon-icon-arrow-right-2"></span>试卷归档管理</a>
                                    </li>
                                    <li><a href="${pageContext.request.contextPath}/tPAction_list.action"><span
                                            class="icon16 icomoon-icon-arrow-right-2"></span>实训归档管理</a>
                                    </li>
                                </ul>
                            </li>
                            <li><a href="#"><span class="icon16 icomoon-icon-list-view"></span>获奖详情管理</a>
                                <ul class="sub">
                                    <li><a href="${pageContext.request.contextPath}/awardsAction_addUI.action"><span
                                            class="icon16 icomoon-icon-arrow-right-2"></span>申请</a></li>
                                    <li>
                                        <a href="${pageContext.request.contextPath}/awardsAction_waitForCheckList.action"><span
                                                class="icon16 icomoon-icon-arrow-right-2"></span>查看</a></li>
                                    <li><a href="${pageContext.request.contextPath}/awardsAction_list.action"><span
                                            class="icon16 icomoon-icon-arrow-right-2"></span>列表</a></li>
                                </ul>
                            </li>
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
</div>
