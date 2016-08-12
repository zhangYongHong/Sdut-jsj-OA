<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Supr admin</title>

    <!-- Le styles -->


    <link href="css/bootstrap/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="css/icons.css" rel="stylesheet" type="text/css"/>
    <!-- Plugin stylesheets -->
    <link href="plugins/uniform/uniform.default.css" type="text/css" rel="stylesheet"/>
    <!-- Main stylesheets -->
    <link href="css/main.css" rel="stylesheet" type="text/css"/>

</head>

<body>
<s:include value="/header.jsp"/>
<!--Body content-->
<div id="content" class="clearfix">
    <div class="contentwrapper "><!--Content wrapper-->
        <div class="heading">
            <h3>获奖情况管理</h3>
        </div><!-- End .heading-->
        <!-- Build page from here: Usual with <div class="row-fluid"></div> -->

        <div class="row-fluid offset2">

            <div class="span8">

                <div class="box">

                    <div class="title center">
                        <h4>
                            <span>获奖情况申请</span>
                        </h4>
                    </div>
                    <div class="content">
                        <div class="offset5">
                            <s:fielderror name="qpError" cssStyle="color: crimson"></s:fielderror>
                        </div>
                        <form class="form-horizontal" action="awardsAction_add.action" method="post">
                            <div class="form-row row-fluid">
                                <div class="row-fluid">
                                    <label class="form-label span3">竞赛项目:</label>
                                    <div class="span5">
                                        <s:select list="%{#session.roleList}" listKey="ddlCode" listValue="ddlName"
                                                  name="competitionid" headerKey="0" headerValue="请选择" value="rid"
                                                  cssClass="select2-active"></s:select>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row row-fluid">
                                <div class="row-fluid">
                                    <label class="form-label span3">获奖级别:</label>
                                    <div class="span2">
                                        <s:select list="%{#session.roleList}" listKey="ddlCode" listValue="ddlName"
                                                  name="level" headerKey="0" headerValue="请选择" value="rid"
                                                  cssClass="select2-active"></s:select>
                                    </div>
                                    <label class="form-label span2">获奖等级:</label>
                                    <div class="span2">
                                        <s:select list="%{#session.roleList}" listKey="ddlCode" listValue="ddlName"
                                                  name="grade" headerKey="0" headerValue="请选择" value="rid"
                                                  cssClass="select2-active"></s:select>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row row-fluid">
                                <div class="row-fluid">
                                    <label class="form-label span3">专业:</label>
                                    <div class="span2">
                                        <s:select list="%{#session.roleList}" listKey="ddlCode" listValue="ddlName"
                                                  name="deptid" headerKey="0" headerValue="请选择" value="rid"
                                                  cssClass="select2-active"></s:select>
                                    </div>
                                    <label class="form-label span2">班级:</label>
                                    <div class="span2">
                                        <s:select list="%{#session.roleList}" listKey="ddlCode" listValue="ddlName"
                                                  name="classe" headerKey="0" headerValue="请选择" value="rid"
                                                  cssClass="select2-active"></s:select>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row row-fluid">
                                <div class="span9">
                                    <div class="row-fluid">
                                        <label class="form-label span4">成果展示:</label>
                                        <input class="span6" id="normalInput" type="text" name="achievement"/>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row row-fluid">
                                <div class="span9">
                                    <div class="row-fluid">
                                        <label class="form-label span4" for="focusedInput">参赛学生:</label>
                                        <input class="span6 focused" id="focusedInput" type="text" name="stuname"/>
                                    </div>
                                </div>
                            </div>

                            <div class="form-row row-fluid">
                                <div class="span9">
                                    <div class="row-fluid">
                                        <label class="form-label span4" for="focusedInput">指导老师:</label>
                                        <input class="span6 focused"  type="text" name="teacher"/>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row row-fluid">
                                <div class="span9">
                                    <div class="row-fluid">
                                        <label class="form-label span4" for="focusedInput">获奖时间:</label>
                                        <input class="span6 focused"  type="text" name="atime"/>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row row-fluid">
                                <div class="span9">
                                    <div class="row-fluid">
                                        <label class="form-label span4" for="focusedInput">颁奖单位:</label>
                                        <input class="span6 focused" id="" type="text" name="prizeunit"/>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row row-fluid">
                                <div class="span9">
                                    <div class="row-fluid">
                                        <label class="form-label span4">备注:</label>
                                        <textarea class="span6 elastic" rows="3" name="comment"></textarea>
                                    </div>
                                </div>
                            </div>
                            <s:hidden name="state" value="0"/>
                            <div class="form-actions offset1">
                                <button type="submit" class="btn btn-info">保存</button>
                                <button type="button" class="btn">取消</button>
                            </div>

                        </form>

                    </div>
                </div><!-- End .box -->
            </div><!-- End .span6 -->
        </div>
    </div><!-- End contentwrapper -->
</div><!-- End #content -->

</div><!-- End #wrapper -->

<!-- Le javascript
================================================== -->
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap/bootstrap.js"></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script>


<!-- Load plugins -->
<script type="text/javascript" src="plugins/qtip/jquery.qtip.min.js"></script>

<script type="text/javascript" src="plugins/knob/jquery.knob.js"></script>
<script type="text/javascript" src="plugins/fullcalendar/fullcalendar.min.js"></script>
<script type="text/javascript" src="plugins/prettify/prettify.js"></script>

<script type="text/javascript" src="plugins/watermark/jquery.watermark.min.js"></script>
<script type="text/javascript" src="plugins/elastic/jquery.elastic.js"></script>
<script type="text/javascript" src="plugins/maskedinput/jquery.maskedinput-1.3.min.js"></script>
<script type="text/javascript" src="plugins/ibutton/jquery.ibutton.min.js"></script>
<script type="text/javascript" src="plugins/uniform/jquery.uniform.min.js"></script>
<script type="text/javascript" src="plugins/stepper/ui.stepper.js"></script>
<script type="text/javascript" src="plugins/timeentry/jquery.timeentry.min.js"></script>
<script type="text/javascript" src="plugins/select/select2.min.js"></script>
<script type="text/javascript" src="plugins/dualselect/jquery.dualListBox-1.3.min.js"></script>
<script type="text/javascript" src="plugins/tiny_mce/jquery.tinymce.js"></script>
<script type="text/javascript" src="plugins/validate/jquery.validate.min.js"></script>
<script type="text/javascript" src="plugins/search/tipuesearch_set.js"></script>

<script type="text/javascript" src="plugins/animated-progress-bar/jquery.progressbar.js"></script>
<script type="text/javascript" src="plugins/pretty-photo/jquery.prettyPhoto.js"></script>
<script type="text/javascript" src="plugins/smartWizzard/jquery.smartWizard-2.0.min.js"></script>

<script type="text/javascript" src="plugins/elfinder/elfinder.min.js"></script>
<script type="text/javascript" src="plugins/plupload/jquery.plupload.queue/jquery.plupload.queue.js"></script>
<script type="text/javascript" src="plugins/totop/jquery.ui.totop.min.js"></script>


<!-- Important Place before main.js  -->
<script type="text/javascript" src="js/jquery-ui.min.js"></script>
<script type="text/javascript" src="js/supr-theme/jquery-ui-sliderAccess.js"></script>
<script type="text/javascript" src="js/main.js"></script>


</body>
</html>
