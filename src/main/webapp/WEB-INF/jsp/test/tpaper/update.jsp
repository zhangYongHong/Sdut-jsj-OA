<%--
  Created by IntelliJ IDEA.
  User: mnzero
  Date: 16-7-20
  Time: 上午10:44
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
            <h3>实训归档详情表</h3>
        </div><!-- End .heading-->
        <!-- Build page from here: Usual with <div class="row-fluid"></div> -->

        <div class="row-fluid offset2">

            <div class="span8">

                <div class="box">
                    <div class="title center">
                        <h4>
                            <span>实训情况修改</span>
                        </h4>
                    </div>
                    <div class="content">
                        <div class="offset5">
                            <s:fielderror name="qpError" cssStyle="color: crimson"></s:fielderror>
                        </div>
                        <form id="tp-form" class="form-horizontal" action="tp_update" method="post">

                            <div class="form-row row-fluid">
                                <div class="span12">
                                    <div class="row-fluid">
                                        <label class="form-label span4">姓&nbsp;&nbsp;名</label>
                                        <input class="span8" id="normalInput" type="text" name="teacher"
                                               value="<s:property value="#old.teacher"/>" readonly="readonly">
                                    </div>
                                </div>
                            </div>

                            <div class="form-row row-fluid">
                                <div class="span12">
                                    <div class="row-fluid">
                                        <label class="form-label span4" for="focusedInput">授课班级</label>
                                        <input class="span8 focused" id="focusedInput" type="text" name="className"
                                               value="<s:property value="#old.className"/>" readonly="readonly"/>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row row-fluid">
                                <div class="span12">
                                    <div class="row-fluid">
                                        <label class="form-label span4" for="focusedInput">课程名称</label>
                                        <input class="span8 focused" type="text" name="course"
                                               value="<s:property value="#old.course"/>" readonly="readonly"/>
                                    </div>
                                </div>
                            </div>

                            <div class="form-row row-fluid">
                                <div class="span12">
                                    <div class="row-fluid">
                                        <label class="form-label span4">试题来源</label>
                                        <s:if test="#old.psource==1">
                                            <div class="span8 controls">
                                                <div class="left marginT5">
                                                    <input type="radio" name="psource" value="1" checked="checked"/>自拟
                                                    <input type="radio" name="psource" value="2"/>统一命题
                                                </div>
                                            </div>
                                        </s:if>
                                        <s:elseif test="#old.psource==2">
                                            <div class="span8 controls">
                                                <div class="left marginT5">
                                                    <input type="radio" name="psource" value="1"/>自拟
                                                    <input type="radio" name="psource" value="2" checked="checked"/>统一命题
                                                </div>
                                            </div>
                                        </s:elseif>
                                    </div>
                                </div>
                            </div>

                            <div class="form-row row-fluid">

                                <div class="span12">
                                    <div class="row-fluid">
                                        <label class="form-label span4">考核方式</label>
                                        <div class="span8 controls">

                                            <div class="left marginT5">
                                                <input type="radio" name="examineway" checked="checked" value="1"/>答辩
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row row-fluid">
                                <div class="span12">
                                    <div class="row-fluid">
                                        <label class="form-label span4">选课人数</label>
                                        <input class="span8" type="text" name="num"
                                               value="<s:property value="#old.num"/>" readonly="readonly"/>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row row-fluid">
                                <div class="span12">
                                    <div class="row-fluid">
                                        <label class="form-label span4">试卷份数</label>
                                        <input class="span8 tip" type="text" name="tnum"
                                               value="<s:property value="#old.tnum"/>" required/>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row row-fluid">
                                <div class="span12">
                                    <div class="row-fluid">
                                        <label class="form-label span4">课程性质</label>
                                        <input class="span8 tip" type="text" name="nature"
                                               value="<s:property value="#old.nature"/>" required/>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row row-fluid">
                                <div class="span12">
                                    <div class="row-fluid">

                                        <label class="form-label span4">试卷分析</label>
                                        <s:if test="#old.analyzes==0">
                                            <div class="span8 controls">
                                                <div class="left marginT5">
                                                    <input type="radio" name="analyzes" value="1"/>有
                                                    <input type="radio" name="analyzes" value="0" checked="checked"/>无
                                                </div>
                                            </div>
                                        </s:if>
                                        <s:elseif test="#old.analyzes==1">
                                            <div class="span8 controls">
                                                <div class="left marginT5">
                                                    <input type="radio" name="analyzes" value="1" checked="checked"/>有
                                                    <input type="radio" name="analyzes" value="0"/>无
                                                </div>
                                            </div>
                                        </s:elseif>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row row-fluid">
                                <div class="span12">
                                    <div class="row-fluid">

                                        <label class="form-label span4">考试大纲</label>
                                        <s:if test="#old.plan==0">
                                            <div class="span8 controls">
                                                <div class="left marginT5">
                                                    <input type="radio" name="plan" value="1"/>有
                                                    <input type="radio" name="plan" value="0" checked="checked"/>无
                                                </div>
                                            </div>
                                        </s:if>
                                        <s:elseif test="#old.plan==1">
                                            <div class="span8 controls">

                                                <div class="left marginT5">
                                                    <input type="radio" name="plan" value="1" checked="checked"/>有
                                                    <input type="radio" name="plan" value="0"/>无
                                                </div>
                                            </div>
                                        </s:elseif>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row row-fluid">
                                <div class="span12">
                                    <div class="row-fluid">

                                        <label class="form-label span4">评分标准</label>

                                        <div class="span8 controls">
                                            <s:if test="#old.standard==1">
                                                <div class="left marginT5">
                                                    <input type="radio" name="standard" value="1" checked="checked"/>有
                                                    <input type="radio" name="standard" value="0"/>无
                                                </div>
                                            </s:if>
                                            <s:elseif test="#old.standard==0">
                                                <div class="left marginT5">
                                                    <input type="radio" name="standard" value="1"/>有
                                                    <input type="radio" name="standard" value="0" checked="checked"/>无
                                                </div>
                                            </s:elseif>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row row-fluid">
                                <div class="span12">
                                    <div class="row-fluid">

                                        <label class="form-label span4">成绩单</label>
                                        <s:if test="#old.score==0">
                                            <div class="span8 controls">

                                                <div class="left marginT5">
                                                    <input type="radio" name="score" value="1"/>有
                                                    <input type="radio" name="score" value="0" checked="checked"/>无

                                                </div>
                                            </div>
                                        </s:if>
                                        <s:elseif test="#old.score==1">
                                            <div class="span8 controls">

                                                <div class="left marginT5">
                                                    <input type="radio" name="score" value="1" checked="checked"/>有
                                                    <input type="radio" name="score" value="0"/>无

                                                </div>
                                            </div>
                                        </s:elseif>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row row-fluid">
                                <div class="span12">
                                    <div class="row-fluid">
                                        <label class="form-label span4">备注 </label>
                                        <textarea class="span8 elastic" rows="3" name="comment"><s:property
                                                value="#old.comment"/></textarea>
                                    </div>
                                </div>
                            </div>
                            <s:hidden name="tid" value="%{#old.tid}"/>
                            <s:hidden name="fileNum" value="%{#old.fileNum}"/>
                            <s:hidden name="schoolYear" value="%{#old.schoolYear}"/>
                            <s:hidden name="isChange" value="%{#old.isChange}"/>
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

<script type="application/javascript">
    $().ready(function() {
        $("#tp-form").validate({
            rules: {
                num: {
                    min: 0,
                    max: 300
                },
                tnum: {
                    min: 0,
                    max: 300
                }
            }
        });
    });
</script>
</body>
</html>

