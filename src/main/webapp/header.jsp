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
                <a class="brand" href="index.jsp">山东理工大学计算机学院协同办公系统</a>
                <div class="nav-no-collapse">
                    <ul class="nav pull-right usernav">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle avatar" data-toggle="dropdown">
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
                    <shiro:hasRole name="admin">
                        <li>
                            <a href="#"><span class="icon16 icomoon-icon-list-view-2"></span>系统管理</a>
                            <ul class="sub">
                                <li>
                                    <a href="#"><span class="icon16 icomoon-icon-list-view"></span>流程管理</a>
                                    <ul class="sub">
                                        <li>
                                            <a href="${pageContext.request.contextPath}/activitiAction_list.action"><span
                                                    class="icon16 icomoon-icon-arrow-right-2"></span>流程列表</a></li>
                                        <li>
                                            <a href="${pageContext.request.contextPath}/activitiAction_newProcessUI.action"><span
                                                    class="input-small"/><span
                                                    class="icon16 icomoon-icon-arrow-right-2"></span>流程部署</a>
                                        </li>
                                        <li><a href="#"><span class="input-small"/><span
                                                class="icon16 icomoon-icon-arrow-right-2"></span>运行的中流程</a></li>
                                    </ul>
                                </li>
                                <shiro:hasPermission name="systemDDLAction:*">
                                    <li>
                                        <a href="#"><span class="icon16 icomoon-icon-list-view"></span>字典管理</a>
                                        <ul class="sub">
                                            <li>
                                                <a href="${pageContext.request.contextPath}/systemDDLAction_list.action"><span
                                                        class="icon16 icomoon-icon-arrow-right-2"></span>字典列表</a></li>
                                            <li><a href="#"><span class="icon16 icomoon-icon-arrow-right-2"></span>字典添加</a>
                                            </li>
                                        </ul>
                                    </li>
                                </shiro:hasPermission>
                                <shiro:hasPermission name="role:*">
                                    <li>
                                        <a href="#"><span class="icon16 icomoon-icon-list-view"></span>角色管理</a>
                                        <ul class="sub">
                                            <li><a href="${pageContext.request.contextPath}/roleAction_list.action"><span class="icon16 icomoon-icon-arrow-right-2"></span>角色列表</a>
                                            </li>
                                            <li><a href="${pageContext.request.contextPath}/roleAction_addUI.action"><span class="icon16 icomoon-icon-arrow-right-2"></span>角色添加</a>
                                            </li>
                                        </ul>
                                    </li>
                                </shiro:hasPermission>
                            </ul>
                        </li>
                    </shiro:hasRole>
                    <li>
                        <a href="#"><span class="icon16 icomoon-icon-grid"></span>个人办公</a>
                        <ul class="sub">
                            <li>
                                <a href="#"><span class="icon16 icomoon-icon-list-view"></span>我的任务</a>
                                <ul class="sub">
                                    <li><a href="${pageContext.request.contextPath}/tasksAction_taskList.action"><span
                                            class="icon16 icomoon-icon-arrow-right-2"></span>待办任务</a>
                                    </li>
                                    <li><a href="#"><span
                                            class="icon16 icomoon-icon-arrow-right-2"></span>已办任务</a>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <a href="#"><span class="icon16 icomoon-icon-list-view"></span>归档管理</a>
                                <ul class="sub">
                                    <shiro:hasPermission name="trainingPaper:view">
                                        <li><a href="${pageContext.request.contextPath}/qPAction_list.action"><span
                                                class="icon16 icomoon-icon-arrow-right-2"></span>试卷归档管理</a>
                                        </li>
                                    </shiro:hasPermission>
                                    <shiro:hasPermission name="questionPaper:view">
                                        <li><a href="${pageContext.request.contextPath}/tPAction_list.action"><span
                                                class="icon16 icomoon-icon-arrow-right-2"></span>实训归档管理</a>
                                        </li>
                                    </shiro:hasPermission>
                                </ul>
                            </li>
                            <shiro:hasPermission name="awards:view">
                                <li><a href="#"><span class="icon16 icomoon-icon-list-view"></span>获奖详情管理</a>
                                    <ul class="sub">
                                        <shiro:hasPermission name="awards:add">
                                            <li>
                                                <a href="${pageContext.request.contextPath}/awardsAction_addUI.action"><span
                                                        class="icon16 icomoon-icon-arrow-right-2"></span>申请</a></li>
                                        </shiro:hasPermission>
                                        <shiro:hasPermission name="awards:view">
                                            <li>
                                                <a href="${pageContext.request.contextPath}/awardsAction_waitForCheckList.action"><span
                                                        class="icon16 icomoon-icon-arrow-right-2"></span>查看</a></li>
                                            <li>
                                                <a href="${pageContext.request.contextPath}/awardsAction_list.action"><span
                                                        class="icon16 icomoon-icon-arrow-right-2"></span>列表</a></li>
                                        </shiro:hasPermission>
                                    </ul>
                                </li>
                            </shiro:hasPermission>
                        </ul>
                    </li>
                    <li>
                        <shiro:hasRole name="admin">
                            <a href="#"><span class="icon16 icomoon-icon-users"></span>人员管理</a>
                        </shiro:hasRole>
                        <shiro:hasRole name="teacher">
                            <a href="#"><span class="icon16 icomoon-icon-users"></span>个人信息管理</a>
                        </shiro:hasRole>
                        <ul class="sub">
                            <shiro:hasPermission name="user:view">
                                <li><a href="userAction_list.action"><span
                                        class="icon16 icomoon-icon-address-2"></span>用户列表</a>
                                </li>
                            </shiro:hasPermission>
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
            </div>
        </div><!-- End sidenav -->

    </div><!-- End #sidebar -->
</div>
