<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>计算机学院办公系统</title>

    <link href="css/bootstrap/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="css/icons.css" rel="stylesheet" type="text/css"/>

    <link href="plugins/dataTables/jquery.dataTables.css" type="text/css" rel="stylesheet"/>
    <!-- Main stylesheets -->
    <link href="css/main.css" rel="stylesheet" type="text/css"/>

</head>

<body>
<s:include value="/header.jsp"/>
<div id="content" class="clearfix">
    <div class="contentwrapper"><!--Content wrapper-->

        <div class="heading">
            <h3>用户管理表</h3>
        </div><!-- End .heading-->
        <!-- Build page from here: Usual with <div class="row-fluid"></div> -->
        <div class="row-fluid">

            <div class="span12">

                <div class="box gradient">

                    <div class="title">
                        <h4>
                            <span>用户信息表</span>
                        </h4>
                    </div>

                    <div class="content noPad clearfix">
                        <div class="form-row row-fluid">
                            <div class="bottom offset10">
                                <a href="userAction_addUI.action" class="btn btip marginR10 marginB10">新增</a>
                            </div>
                        </div>
                        <table cellpadding="0" cellspacing="0" border="0"
                               class="responsive dynamicTable display table table-bordered" width="100%">
                            <!-- dynamicTable -->
                            <thead>
                            <tr>
                                <th>序号</th>
                                <th>工号</th>
                                <th>用户名</th>
                                <th>角色</th>
                                <th>系别</th>
                                <th>邮件</th>
                                <th>手机号</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <s:iterator value="#userPapers.rows" status="i">
                                <tr class="odd gradeX">
                                    <td><s:property value="#i.index+1"/></td>
                                    <td><s:property value="employeenum"/></td>
                                    <td><s:property value="userName"/></td>
                                    <td><s:property value="role"/></td>
                                    <td><s:property value="deptview"/></td>
                                    <td><s:property value="phone"/></td>
                                    <td><s:property value="email"/></td>
                                    <shiro:hasPermission name="user:update,delete,reset">
                                        <td>
                                            <div class="controls center">
                                                <a href="userAction_updateUI.action?uid=<s:property value="uid"/>"
                                                   class="tip"><span
                                                        class="icon12 icomoon-icon-pencil"></span></a>
                                                <a href="userAction_delete.action?uid=<s:property value="uid"/>"
                                                   class="tip" onclick="return confirm('你确定要删除？')"><span
                                                        class="icon12 icomoon-icon-remove"></span></a>
                                                <a href="userAction_resetPassword.action?uid=<s:property value="uid"/>"
                                                   class="tip"
                                                   onclick="return confirm('重置后的密码为000000？')"><span
                                                        class="icon12 icomoon-icon-locked"></span></a>
                                            </div>
                                        </td>
                                    </shiro:hasPermission>
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
<s:include value="/tail.jsp"/>
<!-- End #wrapper -->

<!-- Le javascript
   ================================================== -->
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap/bootstrap.js"></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script>

<!--Load plugins-->
<script type="text/javascript" src="plugins/qtip/jquery.qtip.min.js"></script>


<script type="text/javascript" src="plugins/knob/jquery.knob.js"></script>
<script type="text/javascript" src="plugins/fullcalendar/fullcalendar.min.js"></script>
<script type="text/javascript" src="plugins/prettify/prettify.js"></script>

<script type="text/javascript" src="plugins/watermark/jquery.watermark.min.js"></script>
<script type="text/javascript" src="plugins/maskedinput/jquery.maskedinput-1.3.min.js"></script>
<script type="text/javascript" src="plugins/ibutton/jquery.ibutton.min.js"></script>
<script type="text/javascript" src="plugins/uniform/jquery.uniform.min.js"></script>
<script type="text/javascript" src="plugins/stepper/ui.stepper.js"></script>
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
