<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>计算机学院办公系统</title>


    <link href="css/bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="css/icons.css" rel="stylesheet" type="text/css"/>
    <!-- Plugin stylesheets -->
    <link href="plugins/fullcalendar/fullcalendar.css" rel="stylesheet" type="text/css"/>

    <!-- Main stylesheets -->
    <link href="css/main.css" rel="stylesheet" type="text/css"/>

</head>

<body>
<s:include value="/header.jsp"/>
<!--Body content-->
<div id="content" class="clearfix">
    <div class="contentwrapper"><!--Content wrapper-->

        <div class="heading">

            <h3>功能</h3>

        </div><!-- End .heading-->

        <div class="row-fluid">

            <div class="span8">
                <div class="box calendar gradient">

                    <div class="title">

                        <h4>
                            <span class="icon16 icomoon-icon-calendar"></span>
                            <span>Calendar</span>
                        </h4>
                        <!-- <a href="#" class="minimize">Minimize</a> -->
                    </div>
                    <div class="content noPad">
                        <div id="calendar">
                        </div>
                    </div>

                </div><!-- End .box -->
            </div><!-- End .span8 -->

            <div class="span4">

                <div class="todo">
                    <h4>To Do List <a href="#" class="icon tip" title="Add task"><span
                            class="icon16 icomoon-icon-plus-2"></span></a></h4>
                    <ul>
                        <li class="clearfix">
                            <div class="txt">
                                Fix some bugs
                                <span class="by label">Admin</span>
                                <span class="date badge badge-important">Today</span>
                            </div>
                            <div class="controls">
                                <a href="#" title="Edit task" class="tip"><span
                                        class="icon12 icomoon-icon-pencil"></span></a>
                                <a href="#" title="Remove task" class="tip"><span
                                        class="icon12 icomoon-icon-remove"></span></a>
                            </div>
                        </li>
                        <li class="clearfix">
                            <div class="txt">
                                Add post about birds
                                <span class="by label">Julia</span>
                                <span class="date badge badge-success">Tomorrow</span>
                            </div>
                            <div class="controls">
                                <a href="#" title="Edit task" class="tip"><span
                                        class="icon12 icomoon-icon-pencil"></span></a>
                                <a href="#" title="Remove task" class="tip"><span
                                        class="icon12 icomoon-icon-remove"></span></a>
                            </div>
                        </li>
                        <li class="clearfix">
                            <div class="txt">
                                Remove some items
                                <span class="by label">Admin</span>
                                <span class="date badge badge-success">Tomorrow</span>
                            </div>
                            <div class="controls">
                                <a href="#" title="Edit task" class="tip"><span
                                        class="icon12 icomoon-icon-pencil"></span></a>
                                <a href="#" title="Remove task" class="tip"><span
                                        class="icon12 icomoon-icon-remove"></span></a>
                            </div>
                        </li>
                        <li class="clearfix">
                            <div class="txt">
                                Staff party
                                <span class="by label">Admin</span>
                                <span class="date badge badge-info">08.08.2012</span>
                            </div>
                            <div class="controls">
                                <a href="#" title="Edit task" class="tip"><span
                                        class="icon12 icomoon-icon-pencil"></span></a>
                                <a href="#" title="Remove task" class="tip"><span
                                        class="icon12 icomoon-icon-remove"></span></a>
                            </div>
                        </li>
                        <li class="clearfix">
                            <div class="txt">
                                Shedule backup
                                <span class="by label">Steve</span>
                                <span class="date badge badge-info">08.08.2012</span>
                            </div>
                            <div class="controls">
                                <a href="#" title="Edit task" class="tip"><span
                                        class="icon12 icomoon-icon-pencil"></span></a>
                                <a href="#" title="Remove task" class="tip"><span
                                        class="icon12 icomoon-icon-remove"></span></a>
                            </div>
                        </li>
                    </ul>
                </div>

            </div><!-- End .span4 -->

        </div><!-- End .row-fluid -->

        <div class="modal fade hide" id="myModal1">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span
                        class="icon12 minia-icon-close"></span></button>
                <h3>Chat layout</h3>
            </div>
            <div class="modal-body">
                <ul class="messages">
                    <li class="user clearfix">
                        <a href="#" class="avatar">
                            <img src="images/avatar2.jpeg" alt=""/>
                        </a>
                        <div class="message">
                            <div class="head clearfix">
                                <span class="name"><strong>Lazar</strong> says:</span>
                                <span class="time">25 seconds ago</span>
                            </div>
                            <p>
                                Time to go i call you tomorrow.
                            </p>
                        </div>
                    </li>
                    <li class="admin clearfix">
                        <a href="#" class="avatar">
                            <img src="images/avatar3.jpeg" alt=""/>
                        </a>
                        <div class="message">
                            <div class="head clearfix">
                                <span class="name"><strong>Sugge</strong> says:</span>
                                <span class="time">just now</span>
                            </div>
                            <p>
                                OK, have a nice day.
                            </p>
                        </div>
                    </li>

                    <li class="sendMsg">
                        <form class="form-horizontal" action="#">
                                <textarea class="elastic" id="textarea1" rows="1" placeholder="Enter your message ..."
                                          style="width:98%;"></textarea>
                            <button type="submit" class="btn btn-info marginT10">Send message</button>
                        </form>
                    </li>

                </ul>
            </div>
        </div>
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
<script type="text/javascript" src="plugins/flot/jquery.flot.js"></script>
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

<script type="text/javascript" src="plugins/animated-progress-bar/jquery.progressbar.js"></script>
<script type="text/javascript" src="plugins/pretty-photo/jquery.prettyPhoto.js"></script>
<script type="text/javascript" src="plugins/smartWizzard/jquery.smartWizard-2.0.min.js"></script>

<script type="text/javascript" src="plugins/elfinder/elfinder.min.js"></script>
<script type="text/javascript" src="plugins/plupload/jquery.plupload.queue/jquery.plupload.queue.js"></script>
<script type="text/javascript" src="plugins/totop/jquery.ui.totop.min.js"></script>

<!-- Init plugins -->
<script type="text/javascript" src="js/statistic.js"></script><!-- Control graphs ( chart, pies and etc) -->

<!-- Important Place before main.js  -->
<script type="text/javascript" src="js/jquery-ui.min.js"></script>
<script type="text/javascript" src="js/main.js"></script>


</body>
</html>
