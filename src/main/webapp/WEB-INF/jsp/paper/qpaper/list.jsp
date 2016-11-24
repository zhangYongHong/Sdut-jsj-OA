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

            <h3>试卷归档管理表</h3>


        </div><!-- End .heading-->

        <!-- Build page from here: Usual with <div class="row-fluid"></div> -->

        <div class="row-fluid">

            <div class="span12">

                <div class="box gradient">

                    <div class="title">
                        <h4>
                            <span>试卷归档管理表</span>
                        </h4>
                    </div>

                    <div class="content noPad clearfix">
                        <div class="form-row row-fluid">
                            <div class="span8">
                                <div class="row-fluid">
                                    <label class="form-label span1">&nbsp;&nbsp;学年:</label>
                                    <div class="span3">
                                        <s:select list="%{#session.schoolYearList}" listKey="ddlCode"
                                                  listValue="ddlName"
                                                  name="schoolYear" headerKey="0" headerValue="请选择"
                                                  cssClass="select2-active" id="schoolYear"
                                                  onchange="selectChange()"></s:select>
                                    </div>
                                </div>
                            </div>
                            <div class="bottom">
                                <shiro:hasPermission name="questionPaper:*">
                                    <a href="qPAction_addUI" class="btn btip marginR10 marginB10">新增</a>
                                    <a href="qPAction_loadingExcelUI" class="btn btip marginR10 marginB10">导入</a>
                                </shiro:hasPermission>
                                <a href="qPAction_exportExcel?schoolYear=<s:property value="schoolYear"/>"
                                   class="btn btip marginR10 marginB10">导出</a>
                            </div>
                        </div>
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
                                <shiro:hasPermission name="questionPaper:*">
                                    <th>管理员操作</th>
                                </shiro:hasPermission>
                            </tr>
                            </thead>
                            <tbody>
                            <s:iterator value="#questionPapers.rows" status="i">
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
                                            <a href="qPAction_updateUI?qid=<s:property value="qid"/>"
                                               class="tip"><span class="icon12 icomoon-icon-pencil"></span></a>
                                        </div>
                                    </td>
                                    <shiro:hasPermission name="questionPaper:*">
                                        <td>
                                            <div class="controls center">
                                                <a href="qPAction_updateAdminUI?qid=<s:property value="qid"/>"
                                                   class="tip"><span class="icon12 icomoon-icon-pencil"></span></a>
                                                <a href="qPAction_delete?qid=<s:property value="qid"/>"
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
<s:include value="/WEB-INF/jsp/index/tail.jsp"/>
<!-- End #wrapper -->

<!-- Le javascript
================================================== -->
<script type="text/javascript">
    function selectChange() {
        var selObj = document.getElementById("schoolYear");
        var i = selObj.selectedIndex;
        window.location.href = "qPAction_list?schoolYear=" + selObj.options[i].value;
    }
</script>
<script type="text/javascript" src="/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="/js/bootstrap/bootstrap.js"></script>
<script type="text/javascript" src="/js/jquery.cookie.js"></script>

<!--Load plugins-->
<script type="text/javascript" src="/plugins/qtip/jquery.qtip.min.js"></script>


<script type="text/javascript" src="/plugins/knob/jquery.knob.js"></script>
<script type="text/javascript" src="/plugins/fullcalendar/fullcalendar.min.js"></script>
<script type="text/javascript" src="/plugins/prettify/prettify.js"></script>

<script type="text/javascript" src="/plugins/watermark/jquery.watermark.min.js"></script>
<script type="text/javascript" src="/plugins/maskedinput/jquery.maskedinput-1.3.min.js"></script>
<script type="text/javascript" src="/plugins/ibutton/jquery.ibutton.min.js"></script>
<script type="text/javascript" src="/plugins/uniform/jquery.uniform.min.js"></script>
<script type="text/javascript" src="/plugins/stepper/ui.stepper.js"></script>
<script type="text/javascript" src="/plugins/color-picker/colorpicker.js"></script>
<script type="text/javascript" src="/plugins/timeentry/jquery.timeentry.min.js"></script>
<script type="text/javascript" src="/plugins/select/select2.min.js"></script>
<script type="text/javascript" src="/plugins/dualselect/jquery.dualListBox-1.3.min.js"></script>
<script type="text/javascript" src="/plugins/tiny_mce/jquery.tinymce.js"></script>
<script type="text/javascript" src="/plugins/validate/jquery.validate.min.js"></script>

<script type="text/javascript" src="/plugins/animated-progress-bar/jquery.progressbar.js"></script>
<script type="text/javascript" src="/plugins/pretty-photo/jquery.prettyPhoto.js"></script>

<script type="text/javascript" src="/plugins/dataTables/jquery.dataTables.min.js"></script>

<!-- Important Place before main.js  -->
<script type="text/javascript" src="/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="/js/main.js"></script>

</body>
</html>

