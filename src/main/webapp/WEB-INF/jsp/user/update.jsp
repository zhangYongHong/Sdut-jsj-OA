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
</head>

<body>
<s:include value="/WEB-INF/jsp/index/header.jsp"/>    <!--Body content-->
<div id="content" class="clearfix">
    <div class="contentwrapper"><!--Content wrapper-->

        <div class="heading">

            <h3>个人信息管理</h3>

        </div><!-- End .heading-->

        <!-- Build page from here: -->
        <div class="row-fluid">

            <div class="span12">

                <div class="page-header">
                    <h4>个人信息修改</h4>
                </div>

                <form class="form-horizontal seperator" action="userAction_update" method="post">
                    <div class="offset3">
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
                    <shiro:hasRole name="admin">
                        <div class="form-row row-fluid">
                            <div class="row-fluid">
                                <label class="form-label span3">角&nbsp;&nbsp;&nbsp;色:</label>
                                <div class="span2">
                                    <s:select list="%{#session.roleList}" listKey="ddlCode" listValue="ddlName"
                                              name="role" value="%{#oldUser.role}"
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
                        <div class="form-row row-fluid">
                            <div class="span12">
                                <div class="row-fluid">
                                    <label class="form-label span3" for="email">邮&nbsp&nbsp&nbsp箱:</label>
                                    <input class="span4" type="text" name="email"
                                           value="<s:property value="#oldUser.email"/>"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-row row-fluid">
                            <div class="span12">
                                <div class="row-fluid">
                                    <label class="form-label span3" for="phone">手机号:</label>
                                    <input class="span4" type="text" name="phone"
                                           value="<s:property value="#oldUser.phone "/>"/>
                                </div>
                            </div>
                        </div>
                    </shiro:hasRole>
                    <shiro:hasRole name="teacher">
                        <div class="form-row row-fluid">
                            <div class="row-fluid">
                                <label class="form-label span3">系&nbsp;&nbsp;&nbsp;别:</label>
                                <div class="span2">
                                    <s:select list="%{#session.deptList}" listKey="ddlCode" listValue="ddlName"
                                              name="deptid" value="%{#oldUser.deptid}" readonly="readonly"></s:select>
                                </div>
                            </div>
                        </div>
                        <div class="form-row row-fluid">
                            <div class="span12">
                                <div class="row-fluid">
                                    <label class="form-label span3" for="email">邮&nbsp&nbsp&nbsp箱:</label>
                                    <input class="span4" id="email" type="text" name="email"
                                           value="<s:property value="#oldUser.email"/>" required/>
                                </div>
                            </div>
                        </div>
                        <div class="form-row row-fluid">
                            <div class="span12">
                                <div class="row-fluid">
                                    <label class="form-label span3" for="phone">手机号:</label>
                                    <input class="span4" id="phone" type="text" name="phone"
                                           value="<s:property value="#oldUser.phone "/>" required/>
                                </div>
                            </div>
                        </div>
                    </shiro:hasRole>
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

    </div><!-- End contentwrapper -->
</div><!-- End #content -->
<s:include value="/WEB-INF/jsp/index/tail.jsp"/>
<!-- End #wrapper -->

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

