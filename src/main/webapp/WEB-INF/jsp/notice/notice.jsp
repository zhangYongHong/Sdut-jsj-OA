<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>计算机学院办公系统</title>

    <link href="css/bootstrap/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="css/icons.css" rel="stylesheet" type="text/css"/>

    <link href="plugins/dataTables/jquery.dataTables.css" type="text/css" rel="stylesheet"/>
    <!-- Main stylesheets -->
    <link href="css/main.css" rel="stylesheet" type="text/css"/>

</head>

<body>
<s:include value="/WEB-INF/jsp/index/header.jsp"/>
<div id="content" style="width: 1000px; padding-left: 200px;padding-top: 100px">
    <div class="contentwrapper" ><!--Content wrapper-->

        <!-- Build page from here: Usual with <div class="row-fluid"></div> -->
        <div class="row-fluid">

            <div class="span12">

                <div class="box gradient">

                    <div class="title center">
                        <h2>
                            <span>通知</span>
                        </h2>
                    </div>
                    <div class="content" style="padding-left: 30px; padding-right: 30px">
                        <div class="center">
                            <h3>
                                <span><s:property value="#notice.title"/> </span>
                            </h3>
                        </div>
                        <div >
                            <s:property value="#notice.content" escape="false"/>
                        </div>
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
