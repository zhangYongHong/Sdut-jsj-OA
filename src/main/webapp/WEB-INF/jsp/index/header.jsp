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
                <a class="brand" href="noticeAction_list">山东理工大学计算机学院协同办公系统</a>
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
                                            <a href="userAction_updateUI?uid=<s:property value="#session.globleUser.uid"/>"><span
                                                    class="icon16 icomoon-icon-user-3"></span>个人信息</a>
                                        </li>
                                        <li>
                                            <a href="userAction_passWordUI"><span
                                                    class="icon16  icomoon-icon-locked-2"></span>密码修改</a>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/loginAction_signOut"><span
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
                    <li><a href="noticeAction_list"><span class="icon16 icomoon-icon-home"></span>首页</a></li>
                    <shiro:hasPermission name="system:*">
                        <li>
                            <a href="#"><span class="icon16 icomoon-icon-list-view-2"></span>系统管理</a>
                            <ul class="sub">
                                <shiro:hasPermission name="activiti:*">
                                    <li>
                                        <a href="#"><span class="icon16 icomoon-icon-list-view"></span>流程管理</a>
                                        <ul class="sub">
                                            <li>
                                                <a href="${pageContext.request.contextPath}/activitiAction_list"><span
                                                        class="icon16 icomoon-icon-arrow-right-2"></span>流程列表</a></li>
                                            <li>
                                                <a href="${pageContext.request.contextPath}/activitiAction_newProcessUI"><span
                                                        class="input-small"/><span
                                                        class="icon16 icomoon-icon-arrow-right-2"></span>流程部署</a>
                                            </li>
                                        </ul>
                                    </li>
                                </shiro:hasPermission>
                                <shiro:hasPermission name="systemDDL:*">
                                    <li>
                                        <a href="#"><span class="icon16 icomoon-icon-list-view"></span>字典管理</a>
                                        <ul class="sub">
                                            <li>
                                                <a href="${pageContext.request.contextPath}/systemDDLAction_list"><span
                                                        class="icon16 icomoon-icon-arrow-right-2"></span>字典列表</a></li>
                                            <li><a href="${pageContext.request.contextPath}/systemDDLAction_addUI"><span
                                                    class="icon16 icomoon-icon-arrow-right-2"></span>字典添加</a>
                                            </li>
                                        </ul>
                                    </li>
                                </shiro:hasPermission>
                                <shiro:hasPermission name="role:*">
                                    <li>
                                        <a href="#"><span class="icon16 icomoon-icon-list-view"></span>角色管理</a>
                                        <ul class="sub">
                                            <li><a href="${pageContext.request.contextPath}/roleAction_list"><span
                                                    class="icon16 icomoon-icon-arrow-right-2"></span>角色列表</a>
                                            </li>
                                            <li><a href="${pageContext.request.contextPath}/roleAction_addUI"><span
                                                    class="icon16 icomoon-icon-arrow-right-2"></span>角色添加</a>
                                            </li>
                                        </ul>
                                    </li>
                                </shiro:hasPermission>
                                <shiro:hasPermission name="notice:*">
                                    <li>
                                        <a href="#"><span class="icon16 icomoon-icon-list-view"></span>通知管理</a>
                                        <ul class="sub">
                                            <li>
                                                <a href="${pageContext.request.contextPath}/noticeAction_noticeList"><span
                                                        class="icon16 icomoon-icon-arrow-right-2"></span>通知列表</a>
                                            </li>
                                            <li><a href="${pageContext.request.contextPath}/noticeAction_addUI"><span
                                                    class="icon16 icomoon-icon-arrow-right-2"></span>添加通知</a>
                                            </li>
                                        </ul>
                                    </li>
                                </shiro:hasPermission>
                            </ul>
                        </li>
                    </shiro:hasPermission>
                    <li>
                        <a href="#"><span class="icon16 icomoon-icon-grid"></span>个人办公</a>
                        <ul class="sub">
                            <li>
                                <a href="#"><span class="icon16 icomoon-icon-list-view"></span>我的任务</a>
                                <ul class="sub">
                                    <li><a href="${pageContext.request.contextPath}/tasksAction_taskList"><span
                                            class="icon16 icomoon-icon-arrow-right-2"></span>待办任务</a>
                                    </li>
                                    <li><a href="${pageContext.request.contextPath}/tasksAction_historyList"><span
                                            class="icon16 icomoon-icon-arrow-right-2"></span>已办任务</a>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <a href="#"><span class="icon16 icomoon-icon-list-view"></span>试卷管理</a>
                                <ul class="sub">
                                    <li><a href="${pageContext.request.contextPath}/qp_list"><span
                                            class="icon16 icomoon-icon-arrow-right-2"></span>试卷归档管理</a>
                                    </li>
                                    <li><a href="${pageContext.request.contextPath}/tp_list"><span
                                            class="icon16 icomoon-icon-arrow-right-2"></span>实训归档管理</a>
                                    </li>
                                    <li><a href="${pageContext.request.contextPath}/tPAction_list"><span
                                            class="icon16 icomoon-icon-arrow-right-2"></span>教研论文管理</a>
                                    </li>
                                    <li><a href="${pageContext.request.contextPath}/tPAction_list"><span
                                            class="icon16 icomoon-icon-arrow-right-2"></span>教研课题管理</a>
                                    </li>
                                </ul>
                            </li>
                            <li><a href="#"><span class="icon16 icomoon-icon-list-view"></span>获奖详情管理</a>
                                <ul class="sub">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/awardsAction_addUI"><span
                                                class="icon16 icomoon-icon-arrow-right-2"></span>申请</a></li>
                                    <li>
                                        <a href="${pageContext.request.contextPath}/awardsAction_waitForCheckList"><span
                                                class="icon16 icomoon-icon-arrow-right-2"></span>查看</a></li>
                                    <shiro:hasPermission name="awards:*">
                                        <li>
                                            <a href="${pageContext.request.contextPath}/awardsAction_list"><span
                                                    class="icon16 icomoon-icon-arrow-right-2"></span>列表</a></li>
                                    </shiro:hasPermission>
                                </ul>
                            </li>
                        </ul>
                    </li>
                    <shiro:hasPermission name="user:*">
                        <li>
                            <a href="#"><span class="icon16 icomoon-icon-users"></span>人员管理</a>
                            <ul class="sub">
                                <li><a href="userAction_list"><span
                                        class="icon16 icomoon-icon-people"></span>用户列表</a>
                                </li>
                                <li><a href="userAction_addUI"><span
                                        class="icon16  icomoon-icon-man"></span>用户添加</a>
                                </li>
                                <li>
                            </ul>
                        </li>
                    </shiro:hasPermission>
                    <li>
                        <a href="#"><span class="icon16 icomoon-icon-users"></span>个人信息管理</a>
                        <ul class="sub">
                            <li>
                                <a href="userAction_updateUI?uid=<s:property value="#session.globleUser.uid"/>"><span
                                        class="icon16 icomoon-icon-user-3"></span>个人信息</a>
                            </li>
                            <li>
                                <a href="userAction_passWordUI"><span
                                        class="icon16  icomoon-icon-locked-2"></span>密码修改</a>
                            </li>

                        </ul>
                    </li>
                </ul>
            </div>
        </div><!-- End sidenav -->

    </div><!-- End #sidebar -->
</div>
