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

            <h3>通知列表</h3>


        </div><!-- End .heading-->

        <!-- Build page from here: Usual with <div class="row-fluid"></div> -->

        <div class="row-fluid">

            <div class="span12">

                <div class="box gradient">

                    <div class="title">
                        <h4>
                            <span>通知列表</span>
                        </h4>
                    </div>

                    <div class="content noPad clearfix">
                        <div class="bottom center">
                            <a href="noticeAction_addUI" class="btn btip marginR10 marginB10">新增</a>
                        </div>
                        <table cellpadding="0" cellspacing="0" border="0"
                               class="responsive dynamicTable display table table-bordered" width="100%">
                            <!-- dynamicTable -->
                            <thead>
                            <tr>
                                <th>UUID</th>
                                <th>标题</th>
                                <%--<th>内容</th>--%>
                                <th>发布时间</th>
                                <th>发布人</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <s:iterator value="#notices" status="i">
                                <tr class="odd gradeX">
                                    <td><s:property value="uuid"/></td>
                                    <td><s:property value="title"/></td>
                                        <%--<td><s:property value="content"/></td>--%>
                                    <td><s:date name="beginDate" format="yyyy-MM-dd"/></td>
                                    <td><s:property value="user"/></td>
                                    <td>
                                        <div class="controls center">
                                            <a href="noticeAction_delete?uuid=<s:property value="uuid"/>"
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
        var selObj = document.getElementById("schoolYear");
        var i = selObj.selectedIndex;
        window.location.href = "qPAction_list.action?schoolYear=" + selObj.options[i].value;
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

