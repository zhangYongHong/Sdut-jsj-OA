<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>计算机学院办公系统</title>

    <!-- Le styles -->
    <link href="../../../css/bootstrap/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="../../../css/icons.css" rel="stylesheet" type="text/css"/>
    <!-- Plugin stylesheets -->
    <link href="../../../plugins/uniform/uniform.default.css" type="text/css" rel="stylesheet"/>
    <!-- Main stylesheets -->
    <link href="../../../css/main.css" rel="stylesheet" type="text/css"/>

    <script type="text/javascript">
        window.UEDITOR_HOME_URL = "/plugins/UEditor/";
    </script>
</head>

<body>
<s:include value="/header.jsp"/>
<!--Body content-->
<div id="content" class="clearfix">
    <div class="contentwrapper "><!--Content wrapper-->
        <div class="heading">
            <h3>通知管理</h3>
        </div><!-- End .heading-->
        <!-- Build page from here: Usual with <div class="row-fluid"></div> -->

        <div class="row-fluid offset2">

            <div class="span8">

                <div class="box">

                    <div class="title center">
                        <h4>
                            <span>添加通知</span>
                        </h4>
                    </div>
                    <div class="content">
                        <div class="offset5">
                            <s:fielderror name="qpError" cssStyle="color: crimson"></s:fielderror>
                        </div>
                        <form class="form-horizontal" action="noticeAction_add" method="post">
                            <div class="form-row row-fluid">
                                <div class="span9">
                                    <div class="row-fluid">
                                        <label class="form-label span4">标题:</label>
                                        <input class="span6" id="normalInput" type="text" name="title"/>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row row-fluid">
                                <div class="span12">
                                    <div class="row-fluid">
                                        <script id="editor" type="text/plain" style="width:1060px;height:500px;"></script>
                                    </div>
                                </div>
                            </div>
                            <div class="form-actions offset1">
                                <button type="submit" class="btn btn-info">发布</button>
                            </div>

                        </form>

                    </div>
                </div><!-- End .box -->
            </div><!-- End .span6 -->
        </div>
    </div><!-- End contentwrapper -->
</div><!-- End #content -->
<s:include value="/tail.jsp"/>
<!-- End #wrapper -->

<!-- Le javascript
================================================== -->
<script type="text/javascript" src="../../../js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="../../../js/bootstrap/bootstrap.js"></script>
<script type="text/javascript" src="../../../js/jquery.cookie.js"></script>
<script type="text/javascript" src="../../../js/laydate/laydate.js"></script>
<!-- Load plugins -->
<script type="text/javascript" src="../../../plugins/qtip/jquery.qtip.min.js"></script>

<script type="text/javascript" src="../../../plugins/knob/jquery.knob.js"></script>
<script type="text/javascript" src="../../../plugins/fullcalendar/fullcalendar.min.js"></script>
<script type="text/javascript" src="../../../plugins/prettify/prettify.js"></script>

<script type="text/javascript" src="../../../plugins/watermark/jquery.watermark.min.js"></script>
<script type="text/javascript" src="../../../plugins/elastic/jquery.elastic.js"></script>
<script type="text/javascript" src="../../../plugins/maskedinput/jquery.maskedinput-1.3.min.js"></script>
<script type="text/javascript" src="../../../plugins/ibutton/jquery.ibutton.min.js"></script>
<script type="text/javascript" src="../../../plugins/uniform/jquery.uniform.min.js"></script>
<script type="text/javascript" src="../../../plugins/stepper/ui.stepper.js"></script>
<script type="text/javascript" src="../../../plugins/timeentry/jquery.timeentry.min.js"></script>
<script type="text/javascript" src="../../../plugins/select/select2.min.js"></script>
<script type="text/javascript" src="../../../plugins/dualselect/jquery.dualListBox-1.3.min.js"></script>
<script type="text/javascript" src="../../../plugins/tiny_mce/jquery.tinymce.js"></script>
<script type="text/javascript" src="../../../plugins/validate/jquery.validate.min.js"></script>
<script type="text/javascript" src="../../../plugins/search/tipuesearch_set.js"></script>

<script type="text/javascript" src="../../../plugins/animated-progress-bar/jquery.progressbar.js"></script>
<script type="text/javascript" src="../../../plugins/pretty-photo/jquery.prettyPhoto.js"></script>
<script type="text/javascript" src="../../../plugins/smartWizzard/jquery.smartWizard-2.0.min.js"></script>

<script type="text/javascript" src="../../../plugins/elfinder/elfinder.min.js"></script>
<script type="text/javascript" src="../../../plugins/plupload/jquery.plupload.queue/jquery.plupload.queue.js"></script>
<script type="text/javascript" src="../../../plugins/totop/jquery.ui.totop.min.js"></script>
<script type="text/javascript" src="../../../plugins/UEditor/ueditor.config.js"></script>
<script type="text/javascript" src="../../../plugins/UEditor/ueditor.all.min.js"></script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" src="../../../plugins/UEditor/lang/zh-cn/zh-cn.js"></script>

<!-- Important Place before main.js  -->
<script type="text/javascript" src="../../../js/jquery-ui.min.js"></script>
<script type="text/javascript" src="../../../js/supr-theme/jquery-ui-sliderAccess.js"></script>
<script type="text/javascript" src="../../../js/main.js"></script>

<script type="text/javascript">

    //实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
    var ue = UE.getEditor('editor');

    function getContent() {
        var arr = [];
        arr.push("使用editor.getContent()方法可以获得编辑器的内容");
        arr.push("内容为：");
        arr.push(UE.getEditor('editor').getContent());
        alert(arr.join("\n"));
    }

</script>

</body>
</html>
