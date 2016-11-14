<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>计算机学院办公系统</title>
    <link href="css/bootstrap/bootstrap.css" rel="stylesheet"/>
    <!-- Main stylesheets -->
    <link href="css/main.css" rel="stylesheet" type="text/css"/>

</head>

<body class="loginPage">

<div class="container-fluid">

    <div id="header">

        <div class="row-fluid">

            <div class="navbar">
                <div class="navbar-inner">
                    <div class="container">
                        <a class="brand" href="#">山东理工大学计算机学院协同办公系统</a>
                    </div>
                </div><!-- /navbar-inner -->
            </div><!-- /navbar -->


        </div><!-- End .row-fluid -->

    </div><!-- End #header -->

</div><!-- End .container-fluid -->

<div class="container-fluid">

    <div class="loginContainer">
        <form class="form-horizontal" action="loginAction_login" id="loginForm" method="post">
            <div class="form-row row-fluid">
                <label style="align-content: center"><s:fielderror name="loginError" cssStyle="color: crimson;"
                                                                   id="error"/></label>
                <div class="span12">
                    <div class="row-fluid">
                        <label class="form-label span12" for="employeenum">
                            工号:
                            <span class="icon16 icomoon-icon-user-3 right gray marginR10"></span>
                        </label>
                        <input class="span12" id="employeenum" type="text" name="employeenum"/>
                    </div>
                </div>
            </div>

            <div class="form-row row-fluid">
                <div class="span12">
                    <div class="row-fluid">
                        <label class="form-label span12" for="password">
                            密码:
                            <span class="icon16 icomoon-icon-locked right gray marginR10"></span>
                        </label>
                        <input class="span12" id="password" type="password" name="password"/>
                    </div>
                </div>
            </div>
            <div class="form-row row-fluid">
                <div class="span12">
                    <div class="row-fluid">
                        <div class="form-actions">
                            <div class="span12 controls">
                                <input type="submit" class="btn btn-info right" id="loginBtn" value="登陆">
                                </input>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </form>
    </div>

</div><!-- End .container-fluid -->

</body>
</html>
