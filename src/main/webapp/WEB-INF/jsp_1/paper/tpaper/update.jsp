<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="/css/table_add.css" rel="stylesheet" type="text/css">
    <title>修改信息</title>
</head>
<body>
<div id="container">
    <h4>你当前的位置:期末实训详情表>>信息修改</h4>
    <div style="margin-left: 200px;">
        <form action="tPAction_update.action" method="post">
            <table cellpadding="4" cellspacing="3">
                <label><s:fielderror name="tpError" cssStyle="color: crimson"></s:fielderror></label>
                <tr>
                    <td>姓&nbsp;&nbsp;名:</td>
                    <td><s:textarea name="teacher" value="%{#old.teacher}" cssClass="inputcss"/>
                    </td>
                </tr>

                <tr>
                    <td>课&nbsp;&nbsp;程:&nbsp;</td>
                    <td><s:textarea name="course" value="%{#old.course}" cssClass="inputcss"/></td>
                </tr>
                <tr>
                    <td>班&nbsp;&nbsp;级:&nbsp;</td>
                    <td><s:textarea name="className" value="%{#old.className}" cssClass="inputcss"/></td>
                </tr>
                <tr>
                    <td>试题来源:&nbsp;</td>
                    <td><s:radio list="#{1:'自拟',2:'统一命题'}" name="psource" value="%{#old.psource}">
                    </s:radio></td>
                </tr>
                <tr>
                    <td>考核方式:&nbsp;</td>
                    <td><s:radio list="#{1:'答辩'}" name="examineway" value="1"></s:radio></td>
                </tr>
                <tr>
                    <td>选课人数:&nbsp;</td>
                    <td><s:textarea name="num" value="%{#old.num}" cssClass="inputcss"/></td>
                </tr>

                <tr>
                    <td>试卷份数:&nbsp;</td>
                    <td><s:textarea name="tnum" value="%{#old.tnum}" cssClass="inputcss"/></td>
                </tr>

                <tr>
                    <td>课程性质:&nbsp;</td>
                    <td><s:textarea name="nature" value="%{#old.nature}" cssClass="inputcss"/></td>
                </tr>


                <tr>
                    <td>试卷分析:&nbsp;</td>
                    <td><s:radio list="#{1:'有',0:'无' }" name="analyzes" value="%{#old.analyzes}"></s:radio></td>
                </tr>

                <tr>
                    <td>考试大纲:&nbsp;</td>
                    <td><s:radio list="#{1:'有',0:'无' }" name="plan" value="%{#old.plan}"></s:radio></td>
                </tr>

                <tr>
                    <td>评分标准:&nbsp;</td>
                    <td><s:radio list="#{1:'有',0:'无' }" name="standard" value="%{#old.standard}"></s:radio></td>
                </tr>

                <tr>
                    <td>成绩单&nbsp;:&nbsp;</td>
                    <td><s:radio list="#{1:'有',0:'无' }" name="score" value="%{#old.score}"></s:radio></td>
                </tr>

                <tr>
                    <td>系&nbsp;&nbsp;别:&nbsp;</td>
                    <td><s:property value="%{#old.deptidview}"></s:property></td>
                </tr>
                <tr>
                    <td>年&nbsp;&nbsp;级:&nbsp;</td>
                    <td><s:textarea name="grade" value="%{#old.grade}" cssClass="inputcss"/></td>
                </tr>
                <tr>
                    <td>备&nbsp;注:</td>
                </tr>
            </table>
            <table>
                <br>
                <s:textarea name="comment" value="%{#old.comment}" cols="0" rows="4" cssStyle="margin-left: 90px; width: 60%"/>

                <tr>
                <tr height="26px"></tr>
                <td width="44px;"></td>
                <td><s:submit cssStyle="margin-left: 48px;" value="提交"
                              cssClass="button"></s:submit></td>
                <td width="60px;"></td>
                <td></td>
                <td><input type="reset" name="" class="button"></td>
                </tr>
            </table>
        </form>

    </div>
</div>

</body>
</html>