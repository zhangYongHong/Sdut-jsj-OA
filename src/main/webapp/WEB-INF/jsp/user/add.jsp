<%--
  Created by IntelliJ IDEA.
  User: mnzero
  Date: 16-7-12
  Time: 下午3:12
  To change this template use File | Settings | File Templates.
--%>
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
    <title>计算机学院办公系统</title>

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
<s:include value="/header.jsp"/>
<!--Body content-->
<div id="content" class="clearfix">
    <div class="contentwrapper"><!--Content wrapper-->

        <div class="heading">

            <h3>个人信息管理</h3>

        </div><!-- End .heading-->

        <!-- Build page from here: -->
        <div class="row-fluid">

            <div class="span12">

                <div class="page-header">
                    <h4>个人信息添加</h4>
                </div>

                <form class="form-horizontal seperator" action="userAction_add.action" method="post">
                    <div class="offset3">
                        <s:fielderror name="userError" cssStyle="color: crimson"/>
                    </div>
                    <div class="form-row row-fluid">
                        <div class="span12">
                            <div class="row-fluid">
                                <label class="form-label span3" for="employeenum">工&nbsp&nbsp&nbsp号:</label>
                                <input class="span4" id="employeenum" type="text" name="employeenum"/>
                            </div>
                        </div>
                    </div>

                    <div class="form-row row-fluid">
                        <div class="span12">
                            <div class="row-fluid">
                                <label class="form-label span3" for="name">用户名:</label>
                                <input class="span4" id="name" type="text" name="userName"/>
                            </div>
                        </div>
                    </div>
                    <shiro:hasPermission name="role:add">
                        <div class="form-row row-fluid">
                            <div class="row-fluid">
                                <label class="form-label span3">角&nbsp;&nbsp;&nbsp;色:</label>
                                <div class="span2">
                                    <s:select list="%{#session.roleList}" listKey="ddlCode" listValue="ddlName"
                                              name="role" headerValue="请选择"
                                              cssClass="select2-active"></s:select>
                                </div>
                            </div>
                        </div>
                    </shiro:hasPermission>
                    <div class="form-row row-fluid">
                        <div class="row-fluid">
                            <label class="form-label span3">系&nbsp;&nbsp;&nbsp;别:</label>
                            <div class="span2">
                                <s:select list="%{#session.deptList}" listKey="ddlCode" listValue="ddlName"
                                          name="deptid" headerValue="请选择"></s:select>
                            </div>
                        </div>
                    </div>
                    <div class="form-row row-fluid">
                        <div class="span12">
                            <div class="row-fluid">
                                <label class="form-label span3" for="email">邮&nbsp&nbsp&nbsp箱:</label>
                                <input class="span4" id="email" type="text" name="email"
                                       value="<s:property value="%{#oldUser.email}"/>"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-row row-fluid">
                        <div class="span12">
                            <div class="row-fluid">
                                <label class="form-label span3" for="phone">手机号:</label>
                                <input class="span4" id="phone" type="text" name="phone"
                                       value="<s:property value="%{#oldUser.phone}"/>"/>
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


