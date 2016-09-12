<%--
  Created by IntelliJ IDEA.
  User: mnzero
  Date: 16-7-20
  Time: 下午12:08
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

    <!-- Le styles -->


    <link href="css/bootstrap/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="css/icons.css" rel="stylesheet" type="text/css"/>

    <link href="plugins/dataTables/jquery.dataTables.css" type="text/css" rel="stylesheet"/>
    <!-- Main stylesheets -->
    <link href="css/main.css" rel="stylesheet" type="text/css"/>


</head>

<body>
<s:include value="/header.jsp"/>
<!--Body content-->
<div id="content" class="clearfix">
    <div class="contentwrapper"><!--Content wrapper-->

        <div class="heading">

            <h3>获奖管理</h3>


        </div><!-- End .heading-->

        <!-- Build page from here: Usual with <div class="row-fluid"></div> -->

        <div class="row-fluid">

            <div class="span12">

                <div class="box gradient">

                    <div class="title">
                        <h4>
                            <span>获奖情况表</span>
                        </h4>
                    </div>
                    <div class="content noPad clearfix">
                        <div class="form-row row-fluid">
                            <div class="span4">
                                <div class="row-fluid">
                                    <label class="form-label span2">学年:</label>
                                    <div class="span8 controls">
                                        <select name="schoolYear" id="schoolYear" onchange="selectChange()">
                                            <option>请选择</option>
                                            <option value="2014-2015-1">2014-2015学年上学期</option>
                                            <option value="2014-2015-2">2014-2015学年下学期</option>
                                            <option value="2015-2016-1">2015-2016学年上学期</option>
                                            <option value="2015-2016-2">2015-2016学年下学期</option>
                                            <option value="2016-2017-1">2016-2017学年上学期</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <shiro:hasRole name="admin">
                                <div class="bottom ">
                                    <a href="qPAction_loadingExcelUI.action" class="btn btip marginR10 marginB10">导入</a>
                                    <a href="qPAction_exportExcel.action" class="btn btip marginR10 marginB10">导出</a>
                                </div>
                            </shiro:hasRole>
                        </div>
                        <table cellpadding="0" cellspacing="0" border="0"
                               class="responsive dynamicTable display table table-bordered" width="100%">
                            <!-- dynamicTable -->
                            <thead>
                            <tr>
                                <th>序号</th>
                                <th>竞赛项目</th>
                                <th>成果展示</th>
                                <th>获奖级别</th>
                                <th>获奖等级</th>
                                <th>参赛学生</th>
                                <th>专业</th>
                                <th>班级</th>
                                <th>指导老师姓名</th>
                                <th>获奖时间</th>
                                <th>颁奖单位</th>
                                <th>备注</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <s:iterator value="#awardsPapers.rows" status="i">
                                <tr class="odd gradeX">
                                    <td><s:property value="idView"/></td>
                                    <td><s:property value="competitionView"/></td>
                                    <td><s:property value="achievement"/></td>
                                    <td>
                                        <s:if test="level == 1">国家级</s:if>
                                        <s:elseif test="level == 2">省级</s:elseif>
                                        <s:elseif test="level == 3">校级</s:elseif>
                                        <s:elseif test="level == 4">院级</s:elseif>
                                        <s:else></s:else>
                                    </td>
                                    <td>
                                        <s:if test="grade == 1">特等奖</s:if>
                                        <s:elseif test="grade == 2">一等奖</s:elseif>
                                        <s:elseif test="grade == 3">二等奖</s:elseif>
                                        <s:elseif test="grade == 4">三等奖</s:elseif>
                                        <s:elseif test="grade == 5">优胜奖</s:elseif>
                                        <s:else></s:else>
                                    </td>
                                    <td><s:property value="stuname"/></td>
                                    <td><s:property value="specialty"/></td>
                                    <td><s:property value="classes"/></td>
                                    <td><s:property value="teacher"/></td>
                                    <td><s:property value="atime"/></td>
                                    <td><s:property value="prizeunit"/></td>
                                    <td><s:property value="comment"/></td>
                                    <shiro:hasPermission name="awards:delete">
                                        <td>
                                            <div class="controls center">

                                                <a href="awardsAction_delete.action?aid=<s:property value="aid"/>"
                                                   onclick="return confirm('你确定要删除？')" class="tip"><span
                                                        class="icon12 icomoon-icon-remove"></span></a>
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

</div><!-- End #wrapper -->
<!-- Le javascript
================================================== -->
<script type="text/javascript">
    function selectChange() {
        var selObj = document.getElementById("schoolYear");
        var i = selObj.selectedIndex;
        window.location.href = "awardsAction_list.action?schoolYear=" + selObj.options[i].value;
    }
</script>
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


