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
    <title>计算机学院办公系统</title>

    <!-- Le styles -->


    <link href="css/bootstrap/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="css/icons.css" rel="stylesheet" type="text/css"/>

    <link href="plugins/dataTables/jquery.dataTables.css" type="text/css" rel="stylesheet"/>
    <!-- Main stylesheets -->
    <link href="css/main.css" rel="stylesheet" type="text/css"/>


</head>

<body>
<s:include value="/WEB-INF/jsp/index/header.jsp"/>
<!--Body content-->
<div id="content" class="clearfix">
    <div class="contentwrapper"><!--Content wrapper-->

        <div class="heading">

            <h3>数据字典管理</h3>


        </div><!-- End .heading-->

        <!-- Build page from here: Usual with <div class="row-fluid"></div> -->

        <div class="row-fluid">

            <div class="span12">

                <div class="box gradient">

                    <div class="title">
                        <h4>
                            <span>列表</span>
                        </h4>
                    </div>

                    <div class="content noPad clearfix">
                        <div class="form-row row-fluid">
                            <div class="span4">
                                <div class="row-fluid">
                                    <label class="form-label span2">类型:</label>
                                    <div class="span8 controls">
                                        <select name="keyword" id="keyword" onchange="selectChange()">
                                            <option>请选择</option>
                                            <option value="competitionView">竞赛奖项</option>
                                            <option value="dept">系别</option>
                                            <option value="classes">班级</option>
                                            <option value="level">获奖等级</option>
                                            <option value="grade">获奖级别</option>
                                            <option value="state">审核状态</option>
                                            <option value="type">检索类型</option>
                                            <option value="searchLevel">刊物级别</option>
                                            <option value="schoolYear">学年及学期</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="bottom">
                                <a href="systemDDLAction_addUI" class="btn btip marginR10 marginB10">新增</a>
                            </div>
                        </div>
                        <table cellpadding="0" cellspacing="0" border="0"
                               class="responsive dynamicTable display table table-bordered" width="100%">
                            <!-- dynamicTable -->
                            <thead>
                            <tr>
                                <th>序号</th>
                                <th>类型</th>
                                <th>标记</th>
                                <th>名称</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <s:iterator value="#systemDDLs.rows" status="i">
                                <tr class="odd gradeX">
                                    <td><s:property value="#i.index+1"/></td>
                                    <td><s:property value="keyword"/></td>
                                    <td><s:property value="ddlCode"/></td>
                                    <td><s:property value="ddlName"/></td>
                                    <td>
                                        <div class="controls center">
                                            <a href="systemDDLAction_updateUI?uuid=<s:property value="uuid"/>"
                                               class="tip"><span class="icon12 icomoon-icon-pencil"></span></a>
                                            <a href="systemDDLAction_delete?uuid=<s:property value="uuid"/>&keyword=<s:property value="keyword"/>"
                                               onclick="return confirm('你确定要删除？')" class="tip"><span
                                                    class="icon12 icomoon-icon-remove"></span></a>
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
<s:include value="/WEB-INF/jsp/index/tail.jsp"/>
<!-- End #wrapper -->

<!-- Le javascript
================================================== -->
<script type="text/javascript">
    function selectChange() {
        var selObj = document.getElementById("keyword");
        var i = selObj.selectedIndex;
        window.location.href = "systemDDLAction_list?keyword=" + selObj.options[i].value;
    }
</script>
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

