<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="css/table_add.css" rel="stylesheet" type="text/css">
    <title>修改信息界面</title>
</head>
<body>

<div id="container">
    <h4>你当前的位置:期末考试考场详情表>>修改信息</h4>
    <div style="margin-left: 200px;">
        <s:form action="qPAction_update.action" method="post">
            <table cellpadding="4" cellspacing="3">
                <label style="color: red"><s:fielderror name="qpError"></s:fielderror> </label>
                <tr>
                    <td>授课老师:&nbsp;</td>
                    <td>
                        <s:property value="#session.globleUser.userName"/>
                        <s:hidden name="teacher" value="%{#session.globleUser.userName}"/>
                    </td>
                </tr>

                <tr>
                    <td>授课班级:&nbsp;</td>
                    <td>
                        <s:property value="%{#old.className}"/>
                        <s:hidden name="className" value="%{#old.className}"/>
                    </td>
                        <%--<td><s:select list="%{#session.gradeList}" listKey="ddlCode" listValue="ddlName" name="classId" value="%{#old.classId}"/></td>--%>
                </tr>
                <tr>
                    <td>课程名称:&nbsp;</td>
                    <td>
                        <s:property value="#old.course"/>
                        <s:hidden name="course" value="%{#old.course}"/>
                    </td>
                        <%--<td><s:textfield name="course" value="%{#old.course}" cssClass="inputcss"></s:textfield></td>--%>
                </tr>
                <tr>
                    <td>试题来源:&nbsp;</td>
                    <td><s:radio list="#{1:'自拟',2:'统一命题'}" name="psource" value="%{#old.psource}"></s:radio></td>
                </tr>
                <tr>
                    <td>考核方式:&nbsp;</td>
                    <td><s:radio list="#{1:'开卷',2:'闭卷',3:'大作业',4:'上机'}" name="examineway" value="%{#old.examineway}"/></td>
                </tr>
                <tr>
                    <td>考试人数:&nbsp;</td>
                    <td><s:textfield name="num" value="%{#old.num}" cssClass="inputcss"></s:textfield></td>
                </tr>

                <tr>
                    <td>试卷份数:&nbsp;</td>
                    <td><s:textfield name="pnum" value="%{#old.pnum}" cssClass="inputcss"></s:textfield></td>
                </tr>

                <tr>
                    <td>试卷分析:&nbsp;</td>
                    <td><s:radio list="#{1:'有',0:'无'}" name="analyzes" value="%{#old.analyzes}"></s:radio></td>
                </tr>
                <tr>
                    <td>考试大纲:&nbsp;</td>
                    <td><s:radio list="#{1:'有',0:'无' }" name="plan" listKey="key"
                                 listValue="value" value="%{#old.plan}"></s:radio></td>
                </tr>

                <tr>
                    <td>监考记录:&nbsp;</td>
                    <td><s:radio list="#{1:'有',0:'无' }" name="invigilation"
                                 listKey="key" listValue="value" value="%{#old.invigilation}"></s:radio></td>
                </tr>

                <tr>
                    <td>AB卷:&nbsp;</td>
                    <td><s:radio list="#{1:'有',0:'无' }" name="ab"
                                 listKey="key" listValue="value" value="%{#old.ab}"></s:radio></td>
                </tr>
                <tr>
                    <td>标准答案&nbsp;:&nbsp;</td>
                    <td><s:radio list="#{1:'有',0:'无' }" name="answer"
                                 listKey="key" listValue="value" value="%{#old.answer}"></s:radio></td>
                </tr>
                <tr>
                    <td>评分标准&nbsp;:&nbsp;</td>
                    <td><s:radio list="#{1:'有',0:'无' }" name="standard"
                                 listKey="key" listValue="value" value="%{#old.standard}"></s:radio></td>
                </tr>
                <tr>
                    <td>成绩单&nbsp;:&nbsp;</td>
                    <td><s:radio list="#{1:'有',0:'无' }" name="score"
                                 listKey="key" listValue="value" value="%{#old.score}"></s:radio></td>
                </tr>

                    <%--<s:hidden name="deptid" value="%{#session.globleUser.deptid}"/>--%>
                <tr>
                    <td>备&nbsp;注:</td>
                </tr>
            </table>
            <table>
                <br>
                <s:textarea name="comment" value="%{#old.comment}" clos="38" rows="4" cssStyle="margin-left: 90px; width: 60%"></s:textarea>

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
        </s:form>

    </div>
</div>
</body>
</html>