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
            <h3>角色管理</h3>
        </div><!-- End .heading-->
        <!-- Build page from here: Usual with <div class="row-fluid"></div> -->

        <div class="row-fluid offset2">

            <div class="span8">

                <div class="box">

                    <div class="title center">
                        <h4>
                            <span>角色添加</span>
                        </h4>
                    </div>
                    <div class="content">
                        <div class="offset5">
                            <s:fielderror name="Error" cssStyle="color: crimson"></s:fielderror>
                        </div>
                        <form class="form-horizontal" action="roleAction_add" method="post">
                            <div class="form-row row-fluid">
                                <div class="span9">
                                    <div class="row-fluid">
                                        <label class="form-label span4">角色:</label>
                                        <input class="span6 focused" type="text" name="role"/>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row row-fluid">
                                <div class="span9">
                                    <div class="row-fluid">
                                        <label class="form-label span4">描述:</label>
                                        <input class="span6 focused" type="text" name="description"/>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row row-fluid">
                                <div class="span9">
                                    <div class="row-fluid">

                                        <label class="form-label span4">权限:</label>

                                        <div class="controls">
                                            <div class="left marginT5">
                                                <label>流程管理</label>
                                                <label class="left marginT5">
                                                    <input type="checkbox" value="40" name="resourceIdsStr">
                                                    添加</label>
                                                <label class="left marginT5">
                                                    <input type="checkbox" value="41" name="resourceIdsStr">
                                                    删除</label>
                                                <label class="left marginT5">
                                                    <input type="checkbox" value="39" name="resourceIdsStr">
                                                    查看</label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row-fluid">

                                        <label class="form-label span4"></label>

                                        <div class="controls">
                                            <div class="left marginT5">
                                                <label>字典管理</label>
                                                <label class="left marginT5">
                                                    <input type="checkbox" value="28" name="resourceIdsStr">
                                                    查看</label>
                                                <label class="left marginT5">
                                                    <input type="checkbox" value="29" name="resourceIdsStr">
                                                    添加</label>
                                                <label class="left marginT5">
                                                    <input type="checkbox" value="30" name="resourceIdsStr">
                                                    删除</label>
                                                <label class="left marginT5">
                                                    <input type="checkbox" value="31" name="resourceIdsStr">
                                                    修改</label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row-fluid">

                                        <label class="form-label span4"></label>

                                        <div class="controls">
                                            <div class="left marginT5">
                                                <label>角色管理</label>
                                                <label class="left marginT5">
                                                    <input type="checkbox" value="23" name="resourceIdsStr">
                                                    查看</label>
                                                <label class="left marginT5">
                                                    <input type="checkbox" value="24" name="resourceIdsStr">
                                                    添加</label>
                                                <label class="left marginT5">
                                                    <input type="checkbox" value="25" name="resourceIdsStr">
                                                    删除</label>
                                                <label class="left marginT5">
                                                    <input type="checkbox" value="26" name="resourceIdsStr">
                                                    修改</label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row-fluid">

                                        <label class="form-label span4"></label>

                                        <div class="controls">
                                            <div class="left marginT5">
                                                <label>试卷归档管理</label>
                                                <label class="left marginT5">
                                                    <input type="checkbox" value="9" name="resourceIdsStr">
                                                    添加</label>
                                                <label class="left marginT5">
                                                    <input type="checkbox" value="11" name="resourceIdsStr">
                                                    修改</label>
                                                <label class="left marginT5">
                                                    <input type="checkbox" value="10" name="resourceIdsStr">
                                                    删除</label>
                                                <label class="left marginT5">
                                                    <input type="checkbox" value="8" name="resourceIdsStr">
                                                    查看</label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row-fluid">

                                        <label class="form-label span4"></label>

                                        <div class="controls">
                                            <div class="left marginT5">
                                                <label>实训归档管理</label>
                                                <label class="left marginT5">
                                                    <input type="checkbox" value="13" name="resourceIdsStr">
                                                    查看</label>
                                                <label class="left marginT5">
                                                    <input type="checkbox" value="14" name="resourceIdsStr">
                                                    添加</label>
                                                <label class="left marginT5">
                                                    <input type="checkbox" value="15" name="resourceIdsStr">
                                                    删除</label>
                                                <label class="left marginT5">
                                                    <input type="checkbox" value="16" name="resourceIdsStr">
                                                    修改</label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row-fluid">

                                        <label class="form-label span4"></label>

                                        <div class="controls">
                                            <div class="left marginT5">
                                                <label>获奖详情管理</label>
                                                <label class="left marginT5">
                                                    <input type="checkbox" value="3" name="resourceIdsStr">
                                                    查看</label>
                                                <label class="left marginT5">
                                                    <input type="checkbox" value="4" name="resourceIdsStr">
                                                    添加</label>
                                                <label class="left marginT5">
                                                    <input type="checkbox" value="5" name="resourceIdsStr">
                                                    删除</label>
                                                <label class="left marginT5">
                                                    <input type="checkbox" value="6" name="resourceIdsStr">
                                                    修改</label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row-fluid">

                                        <label class="form-label span4"></label>

                                        <div class="controls">
                                            <div class="left marginT5">
                                                <label>人员管理</label>
                                                <label class="left marginT5">
                                                    <input type="checkbox" value="33" name="resourceIdsStr">
                                                    查看</label>
                                                <label class="left marginT5">
                                                    <input type="checkbox" value="34" name="resourceIdsStr">
                                                    添加</label>
                                                <label class="left marginT5">
                                                    <input type="checkbox" value="35" name="resourceIdsStr">
                                                    删除</label>
                                                <label class="left marginT5">
                                                    <input type="checkbox" value="36" name="resourceIdsStr">
                                                    修改</label>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>
                            <s:hidden name="available" value="false"/>
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
