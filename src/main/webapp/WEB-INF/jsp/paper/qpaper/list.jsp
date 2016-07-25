<%--
  Created by IntelliJ IDEA.
  User: mnzero
  Date: 16-7-5
  Time: 下午4:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>计算机学院OA</title>

    <!-- Le styles -->


    <link href="css/bootstrap/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="css/icons.css" rel="stylesheet" type="text/css"/>

    <link href="plugins/dataTables/jquery.dataTables.css" type="text/css" rel="stylesheet"/>
    <!-- Main stylesheets -->
    <link href="css/main.css" rel="stylesheet" type="text/css"/>


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

                <h3>数据表</h3>


            </div><!-- End .heading-->

            <!-- Build page from here: Usual with <div class="row-fluid"></div> -->

            <div class="row-fluid">

                <div class="span12">

                    <div class="box gradient">

                        <div class="title">
                            <h4>
                                <span>数据表</span>
                            </h4>
                        </div>
                        <div class="form-row row-fluid">
                            <div class="span4">
                                <div class="row-fluid">
                                    <label class="form-label span2">学年:</label>
                                    <div class="span8 controls">
                                        <select name="schoolYear" id="schoolYear" onchange="selectChanage()">
                                            <option value="2014-2015-1">2014-2015学年上学期</option>
                                            <option selected="selected" value="2014-2015-2">2014-2015学年下学期</option>
                                            <option value="2015-2016-1">2015-2016学年上学期</option>
                                            <option value="2015-2016-2">2015-2016学年下学期</option>
                                            <option value="2016-2017-1">2016-2017学年上学期</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <%
                                if (popedomCode.contains("abc")) {
                            %>
                            <div class="bottom ">
                                <a href="qPAction_addUI.action" class="btn btip marginR10 marginB10">新增</a>
                                <a href="qPAction_loadingExcelUI.action" class="btn btip marginR10 marginB10">导入</a>
                                <a href="qPAction_exportExcel.action" class="btn btip marginR10 marginB10">导出</a>
                            </div>
                            <%
                                }
                            %>
                        </div>

                        <div class="content noPad clearfix">
                            <table cellpadding="0" cellspacing="0" border="0"
                                   class="responsive dynamicTable display table table-bordered" width="100%">
                                <!-- dynamicTable -->
                                <thead>
                                <tr>
                                    <th>序号</th>
                                    <th>授课老师</th>
                                    <th>授课班级</th>
                                    <th>课程名称</th>
                                    <th>试题来源</th>
                                    <th>考核方式</th>
                                    <th>人数</th>
                                    <th>试卷份数</th>
                                    <th>试卷考核</th>
                                    <th>考核大纲</th>
                                    <th>监考记录</th>
                                    <th>AB卷</th>
                                    <th>标准答案</th>
                                    <th>评分标准</th>
                                    <th>成绩单</th>
                                    <th>备注</th>
                                    <th>归档号</th>
                                    <th>状态</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <s:iterator value="#qustionPapers.rows" status="i">
                                    <tr class="odd gradeX">
                                        <td><s:property value="#i.index+1"/></td>
                                        <td><s:property value="teacher"/></td>
                                        <td><s:property value="className"/></td>
                                        <td><s:property value="course"/></td>
                                        <td>
                                            <s:if test="psource==1">自拟</s:if>
                                            <s:elseif test="psource==2">统一命题</s:elseif>
                                        </td>
                                        <td>
                                            <s:if test="examineway==1">开卷</s:if>
                                            <s:elseif test="examineway==2">闭卷</s:elseif>
                                            <s:elseif test="examineway==3">答辩</s:elseif>
                                            <s:elseif test="examineway==2">大作业</s:elseif>
                                            <s:elseif test="examineway==2">上机</s:elseif>
                                        </td>
                                        <td><s:property value="num"/></td>
                                        <td><s:property value="pnum"/></td>
                                        <td><s:if test="analyzes==1">有</s:if> <s:elseif
                                                test="analyzes==0">无</s:elseif></td>
                                        <td><s:if test="plan==1">有</s:if> <s:elseif
                                                test="plan==0">无</s:elseif></td>
                                        <td><s:if test="invigilation==1">有</s:if> <s:elseif
                                                test="invigilation==0">无</s:elseif></td>
                                        <td><s:if test="ab==1">有</s:if> <s:elseif
                                                test="ab==0">无</s:elseif></td>
                                        <td><s:if test="answer==1">有</s:if> <s:elseif
                                                test="answer==0">无</s:elseif></td>
                                        <td><s:if test="standard==1">有</s:if> <s:elseif
                                                test="standard==0">无</s:elseif></td>
                                        <td><s:if test="score==1">有</s:if> <s:elseif
                                                test="score==0">无</s:elseif></td>
                                        <td><s:property value="comment"/></td>
                                        <td><s:property value="fileNum"/></td>
                                        <td><s:property value="isChange"/></td>
                                        <td>
                                            <div class="controls center">
                                                <a href="qPAction_updateUI.action?qid=<s:property value="qid"/>"
                                                   class="tip"><span class="icon12 icomoon-icon-pencil"></span></a>
                                                <%
                                                    if (popedomCode.contains("abc")) {
                                                %>
                                                <a href="qPAction_delete.action?qid=<s:property value="qid"/>"
                                                   onclick="return confirm('你确定要删除？')" class="tip"><span
                                                        class="icon12 icomoon-icon-remove"></span></a>
                                                <%
                                                    }
                                                %>
                                            </div>
                                        </td>
                                    </tr>
                                </s:iterator>
                                </tbody>
                            </table>
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

<!--Load plugins-->
<script type="text/javascript" src="plugins/qtip/jquery.qtip.min.js"></script>

<script type="text/javascript" src="js/select.js"></script>
<script type="text/javascript" src="plugins/knob/jquery.knob.js"></script>
<script type="text/javascript" src="plugins/fullcalendar/fullcalendar.min.js"></script>
<script type="text/javascript" src="plugins/prettify/prettify.js"></script>

<script type="text/javascript" src="plugins/watermark/jquery.watermark.min.js"></script>
<script type="text/javascript" src="plugins/maskedinput/jquery.maskedinput-1.3.min.js"></script>
<script type="text/javascript" src="plugins/ibutton/jquery.ibutton.min.js"></script>
<script type="text/javascript" src="plugins/uniform/jquery.uniform.min.js"></script>
<script type="text/javascript" src="plugins/stepper/ui.stepper.js"></script>
<script type="text/javascript" src="plugins/color-picker/colorpicker.js"></script>
<script type="text/javascript" src="plugins/timeentry/jquery.timeentry.min.js"></script>
<script type="text/javascript" src="plugins/select/select2.min.js"></script>
<script type="text/javascript" src="plugins/dualselect/jquery.dualListBox-1.3.min.js"></script>
<script type="text/javascript" src="plugins/tiny_mce/jquery.tinymce.js"></script>
<script type="text/javascript" src="plugins/validate/jquery.validate.min.js"></script>

<script type="text/javascript" src="plugins/animated-progress-bar/jquery.progressbar.js"></script>
<script type="text/javascript" src="plugins/pretty-photo/jquery.prettyPhoto.js"></script>

<script type="text/javascript" src="plugins/dataTables/jquery.dataTables.min.js"></script>

<!-- Important Place before main.js  -->
<script type="text/javascript" src="js/jquery-ui.min.js"></script>
<script type="text/javascript" src="js/main.js"></script>


</body>
</html>

