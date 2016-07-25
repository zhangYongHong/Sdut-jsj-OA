<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="css/table_add.css" rel="stylesheet" type="text/css">

    <title>信息添加</title>
</head>
<body>
<div id="container">
    <div style="margin-left: 200px;">
        <s:fielderror name="qpError" cssStyle="color: crimson"></s:fielderror>
    </div>
    <div style="margin-left: 200px;">
        <s:form name="form" action="qPAction_add" method="post">
            <table cellpadding="4" cellspacing="3">
                <tr>
                    <td>授课教师:&nbsp;</td>
                    <td>
                        <s:property value="#session.globleUser.userName"/>
                        <s:hidden name="teacher" value="%{#session.globleUser.userName}"/>
                    </td>
                </tr>

                <tr>
                    <td>授课班级:&nbsp;</td>
                    <td>
                        <s:select list="%{#session.gradeList}" listKey="ddlCode" listValue="ddlName" name="classId"/>
                    </td>
                </tr>
                <tr>
                    <td>课程名称:&nbsp;</td>
                    <td><input name="course" class="inputcss"/></td>
                </tr>
                <tr>
                    <td>试题来源:&nbsp;</td>
                    <td><s:radio list="#{1:'自拟',2:'统一命题'}" name="psource" value="1"></s:radio></td>
                </tr>
                <tr>
                    <td>考核方式:&nbsp;</td>
                    <td><s:radio list="#{1:'开卷',2:'闭卷',3:'大作业',4:'上机'}" name="examineway" value="2"/></td>
                </tr>
                <tr>
                    <td>考试人数:&nbsp;</td>
                    <td><input name="num" class="inputcss" id = "personNum"></td>
                </tr>

                <tr>
                    <td>试卷份数:&nbsp;</td>
                    <td>
                        <input name="pnum" class="inputcss" id = "paperNum">
                    </td>
                </tr>

                <tr>
                    <td>试卷分析:&nbsp;</td>
                    <td><s:radio list="#{1:'有',0:'无'}" name="analyzes" value="0"/></td>
                </tr>
                <tr>
                    <td>考试大纲:&nbsp;</td>
                    <td><s:radio list="#{1:'有',0:'无' }" name="plan" value="0"/></td>
                </tr>

                <tr>
                    <td>监考记录:&nbsp;</td>
                    <td><s:radio list="#{1:'有',0:'无' }" name="invigilation" value="0"/></td>
                </tr>

                <tr>
                    <td>AB卷:&nbsp;</td>
                    <td><s:radio list="#{1:'有',0:'无' }" name="ab" value="0"/></td>
                </tr>
                <tr>
                    <td>标准答案&nbsp;:&nbsp;</td>
                    <td><s:radio list="#{1:'有',0:'无' }" name="answer" value="0"/></td>
                </tr>
                <tr>
                    <td>评分标准&nbsp;:&nbsp;</td>
                    <td><s:radio list="#{1:'有',0:'无' }" name="standard" value="0"/></td>
                </tr>
                <tr>
                    <td>成绩单&nbsp;:&nbsp;</td>
                    <td><s:radio list="#{1:'有',0:'无' }" name="score" value="0"/></td>
                </tr>
                <s:hidden name="deptid" value="%{#session.globleUser.deptid}"/>
                <tr>
                    <td>备&nbsp;注:</td>
                </tr>
            </table>
            <table>
                <br>
                <s:textarea name="comment"  id="comment" value="%{#old.comment}" clos="38" rows="4"
                            cssStyle="margin-left: 90px; width: 60%">
                </s:textarea>

                <tr>
                <tr height="26px"></tr>
                <td width="44px;"></td>
                <td>
                    <input class = 'button' style="margin-left: 48px;" type="submit" value="提交">
                </td>
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