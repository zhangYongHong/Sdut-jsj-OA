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
            <h3>试卷归档管理</h3>
        </div><!-- End .heading-->
        <!-- Build page from here: Usual with <div class="row-fluid"></div> -->

        <div class="row-fluid offset2">

            <div class="span8">

                <div class="box">

                    <div class="title center">
                        <h4>
                            <span>试卷归档信息添加</span>
                        </h4>

                    </div>
                    <div class="content">
                        <div class="offset5">
                            <s:fielderror name="qpError" cssStyle="color: crimson"></s:fielderror>
                        </div>
                        <form id="qp-form" class="form-horizontal" action="qp_add" method="post">

                            <div class="form-row row-fluid">
                                <div class="span12">
                                    <div class="row-fluid">
                                        <label class="form-label span4">授课老师</label>
                                        <input class="span8" id="normalInput" type="text" name="teacher" required/>
                                    </div>
                                </div>
                            </div>

                            <div class="form-row row-fluid">
                                <div class="span12">
                                    <div class="row-fluid">
                                        <label class="form-label span4" for="focusedInput">授课班级</label>
                                        <input class="span8 focused" id="focusedInput" type="text"
                                               name="className" required/>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row row-fluid">
                                <div class="span12">
                                    <div class="row-fluid">
                                        <label class="form-label span4" for="focusedInput">课程名称</label>
                                        <input class="span8 focused" type="text" name="course" required/>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row row-fluid">
                                <div class="span12">
                                    <div class="row-fluid">

                                        <label class="form-label span4">试题来源</label>

                                        <div class="span8 controls">

                                            <div class="left marginT5">
                                                <input type="radio" name="psource" value="1"/>自拟
                                                <input type="radio" name="psource" value="2" checked="checked"/>统一命题
                                            </div>
                                        </div>

                                    </div>
                                </div>
                            </div>
                            <div class="form-row row-fluid">
                                <div class="span12">
                                    <div class="row-fluid">

                                        <label class="form-label span4">考核方式</label>

                                        <div class="span8 controls">

                                            <div class="left marginT5">
                                                <input type="radio" name="examineway" value="1"/>开卷
                                                <input type="radio" name="examineway" checked="checked" value="2"/>闭卷
                                                <input type="radio" name="examineway" value="3"/>答辩
                                                <input type="radio" name="examineway" value="4"/>大作业
                                                <input type="radio" name="examineway" value="5"/>上机
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row row-fluid">
                                <div class="span12">
                                    <div class="row-fluid">
                                        <label class="form-label span4">考试人数</label>
                                        <input class="span8" type="text" name="num"/>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row row-fluid">
                                <div class="span12">
                                    <div class="row-fluid">
                                        <label class="form-label span4">试卷份数</label>
                                        <input class="span8 tip" type="text" name="pnum"/>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row row-fluid">
                                <div class="span12">
                                    <div class="row-fluid">

                                        <label class="form-label span4">试卷分析</label>

                                        <div class="span8 controls">

                                            <div class="left marginT5">
                                                <input type="radio" name="analyzes" value="1"/>有
                                                <input type="radio" name="analyzes" value="0" checked="checked"/>无
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row row-fluid">
                                <div class="span12">
                                    <div class="row-fluid">

                                        <label class="form-label span4">考试大纲</label>

                                        <div class="span8 controls">

                                            <div class="left marginT5">
                                                <input type="radio" name="plan" value="1"/>有
                                                <input type="radio" name="plan" value="0" checked="checked"/>无

                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row row-fluid">
                                <div class="span12">
                                    <div class="row-fluid">

                                        <label class="form-label span4">监考记录</label>

                                        <div class="span8 controls">

                                            <div class="left marginT5">
                                                <input type="radio" name="invigilation" value="1"/>有
                                                <input type="radio" name="invigilation" value="0"
                                                       checked="checked"/>无
                                            </div>

                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row row-fluid">
                                <div class="span12">
                                    <div class="row-fluid">

                                        <label class="form-label span4">AB卷 </label>

                                        <div class="span8 controls">

                                            <div class="left marginT5">
                                                <input type="radio" name="ab" value="1"/>有
                                                <input type="radio" name="ab" value="0" checked="checked"/>无
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row row-fluid">
                                <div class="span12">
                                    <div class="row-fluid">

                                        <label class="form-label span4">标准答案</label>

                                        <div class="span8 controls">

                                            <div class="left marginT5">
                                                <input type="radio" name="answer" value="1"/>有
                                                <input type="radio" name="answer" value="0" checked="checked"/>无

                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row row-fluid">
                                <div class="span12">
                                    <div class="row-fluid">

                                        <label class="form-label span4">评分标准</label>

                                        <div class="span8 controls">

                                            <div class="left marginT5">
                                                <input type="radio" name="standard" value="1"/>有
                                                <input type="radio" name="standard" value="0" checked="checked"/>无
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row row-fluid">
                                <div class="span12">
                                    <div class="row-fluid">

                                        <label class="form-label span4">成绩单</label>

                                        <div class="span8 controls">

                                            <div class="left marginT5">
                                                <input type="radio" name="score" value="1"/>有
                                                <input type="radio" name="score" value="0" checked="checked"/>无
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row row-fluid">
                                <div class="span13">
                                    <div class="row-fluid">
                                        <label class="form-label span4">&nbsp;&nbsp;学年:</label>
                                        <div class="span3">
                                            <s:select list="%{#session.schoolYearList}" listKey="ddlCode" listValue="ddlName"
                                                      name="schoolYear" headerKey="0" headerValue="请选择" cssClass="select2-active" id="schoolYear" onchange="selectChange()"></s:select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row row-fluid">
                                <div class="span12">
                                    <div class="row-fluid">
                                        <label class="form-label span4">备注 </label>
                                        <textarea class="span8 elastic" rows="3" name="comment"></textarea>
                                    </div>
                                </div>
                            </div>

                            <div class="form-actions offset2">
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
    $().ready(function() {
        $("#qp-form").validate({
            rules: {
                num: {
                    min: 0,
                    max: 300
                },
                pnum: {
                    min: 0,
                    max: 300
                }
            }
        });
    });
</script>
</body>
</html>
