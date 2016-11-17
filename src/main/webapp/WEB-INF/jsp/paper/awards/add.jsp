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
    <!-- Plugin stylesheets -->
    <link href="plugins/uniform/uniform.default.css" type="text/css" rel="stylesheet"/>
    <!-- Main stylesheets -->
    <link href="css/main.css" rel="stylesheet" type="text/css"/>
</head>

<body>
<s:include value="/WEB-INF/jsp/index/header.jsp"/>
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
                        <form id="form-awards" class="form-horizontal" action="awardsAction_add" method="post"
                              enctype="multipart/form-data">
                            <div class="form-row row-fluid">
                                <div class="row-fluid">
                                    <label class="form-label span3" for="competitionid">竞赛项目:</label>
                                    <div class="span5">
                                        <s:select list="%{#session.competitionViewList}" listKey="ddlCode"
                                                  listValue="ddlName"
                                                  name="competitionid" id="competitionid" headerKey="0"
                                                  headerValue="请选择" value="rid"
                                                  cssClass="select2-active"></s:select>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row row-fluid">
                                <div class="row-fluid">
                                    <label class="form-label span3" for="level">获奖级别:</label>
                                    <div class="span2">
                                        <s:select list="%{#session.levelList}" listKey="ddlCode" listValue="ddlName"
                                                  name="level" id="level" headerKey="0" headerValue="请选择" value="rid"
                                                  cssClass="select2-active"></s:select>
                                    </div>
                                    <label class="form-label span2" for="grade">获奖等级:</label>
                                    <div class="span2">
                                        <s:select list="%{#session.gradeList}" listKey="ddlCode" listValue="ddlName"
                                                  name="grade" id="grade" headerKey="0" headerValue="请选择" value="rid"
                                                  cssClass="select2-active"></s:select>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row row-fluid">
                                <div class="span9">
                                    <div class="row-fluid">
                                        <label class="form-label span4" for="achievement">成果名称:</label>
                                        <input class="span5" id="achievement" type="text" name="achievement" required/>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row row-fluid">
                                <div class="span9">
                                    <div class="row-fluid">
                                        <label class="form-label span4" for="stuname">参赛学生:</label>
                                        <input class="span5 focused" id="stuname" type="text" name="stuname" required/>
                                        <span class="help-inline">(学生姓名之间用逗号分割)</span>
                                    </div>

                                </div>
                            </div>
                            <div class="form-row row-fluid">
                                <div class="span9">
                                    <div class="row-fluid">
                                        <label class="form-label span4" for="specialty">专业:</label>
                                        <input class="span5 focused" id="specialty" type="text" name="specialty" required/>
                                        <span class="help-inline">(专业与学生对应,逗号分割)</span>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row row-fluid">
                                <div class="span9">
                                    <div class="row-fluid">
                                        <label class="form-label span4" for="classes">班级:</label>
                                        <input class="span5 focused" id="classes" type="text" name="classes" required/>
                                        <span class="help-inline">(班级与学生对应,逗号分割)</span>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row row-fluid">
                                <div class="span9">
                                    <div class="row-fluid">
                                        <label class="form-label span4" for="teacher">指导老师:</label>
                                        <input class="span5 focused" id="teacher" type="text" name="teacher" required/>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row row-fluid">
                                <div class="span9">
                                    <div class="row-fluid">
                                        <label class="form-label span4" for="atime">获奖时间:</label>
                                        <input class="laydate-icon span5 focused " id="atime" type="text" name="atime"
                                               onclick="laydate()" required/>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row row-fluid">
                                <div class="span9">
                                    <div class="row-fluid">
                                        <label class="form-label span4" for="prizeunit">颁奖单位:</label>
                                        <input class="span5 focused" id="prizeunit" type="text" name="prizeunit" required/>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row row-fluid">
                                <div class="span9">
                                    <div class="row-fluid">
                                        <label class="form-label span4" for="schoolYear">&nbsp;&nbsp;学年:</label>
                                        <div class="span3">
                                            <s:select list="%{#session.schoolYearList}" listKey="ddlCode"
                                                      listValue="ddlName"
                                                      name="schoolYear" headerKey="0" headerValue="请选择"
                                                      cssClass="select2-active" id="schoolYear"
                                                      onchange="selectChange()"></s:select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row row-fluid">
                                <div class="span9">
                                    <div class="row-fluid">
                                        <label class="form-label span4" for="content">备注:</label>
                                        <textarea class="span5 elastic" rows="3" name="comment"></textarea>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row row-fluid">
                                <div class="span9">
                                    <label class="form-label span4">附件:</label>
                                    <input type="file" name="annexFile" id="annexFile" onchange="fileAnnexChange(this)" required/>
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
<s:include value="/WEB-INF/jsp/index/tail.jsp"/>
<!-- End #wrapper -->

<!-- Le javascript
================================================== -->
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap/bootstrap.js"></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script>
<script type="text/javascript" src="js/laydate/laydate.js"></script>
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
<script type="text/javascript" src="plugins/validate/jquery.validate.js"></script>
<script type="text/javascript" src="plugins/validate/jquery.validate.min.js"></script>
<script type="text/javascript" src="plugins/validate/messages_zh.js"></script>
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
<script type="application/javascript">
    function fileAnnexChange(target) {
        var isIE = /msie/i.test(navigator.userAgent) && !window.opera;
        var fileSize = 0;
        if (isIE && !target.files) {
            var filePath = target.value;
            var fileSystem = new ActiveXObject("Scripting.FileSystemObject");
            var file = fileSystem.GetFile (filePath);
            fileSize = file.Size;
        } else {
            fileSize = target.files[0].size;
        }
        var size = fileSize / 1024;
        if(size>2000){
            alert("附件不能大于2M");
            target.value="";
            return
        }
        var name=target.value;
        var fileName = name.substring(name.lastIndexOf(".")+1).toLowerCase();
        if(fileName !="jpeg"){
            alert("请选择图片格式文件上传(仅限jpeg格式)！");
            target.value="";
            return
        }
    }
</script>

</body>
</html>
