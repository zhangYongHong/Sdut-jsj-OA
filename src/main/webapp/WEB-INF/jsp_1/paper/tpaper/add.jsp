<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>信息添加</title>
    <link href="css/table_add.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="container">
    <h4>你当前的位置:期末实训详情表>>信息添加</h4>
    <div style="margin-left: 200px;">
        <s:fielderror name="tpError" cssStyle="color: crimson"></s:fielderror>
    </div>
    <div style="margin-left: 200px;">
        <s:form action="tPAction_add.action" method="post">
            <table cellpadding="4" cellspacing="3">
                <tr>
                    <td>姓&nbsp;&nbsp;名:</td>
                    <td><s:property value="#session.globleUser.userName"/>
                        <s:hidden name="teacher" value="%{#session.globleUser.userName}"/>
                    </td>
                </tr>

                <tr>
                    <td>课&nbsp;&nbsp;程:&nbsp;</td>
                    <td><input name="course" class="inputcss"></td>
                </tr>
                <tr>
                    <td>班&nbsp;&nbsp;级:&nbsp;</td>
                    <td><input name="className" class="inputcss"></td>
                </tr>
                <tr>
                    <td>试题来源:&nbsp;</td>
                    <td><s:radio list="#{1:'自拟',2:'统一命题'}" name="psource" value="1">
                    </s:radio></td>
                </tr>
                <tr>
                    <td>考核方式:&nbsp;</td>
                    <td><s:radio list="#{1:'答辩'}" name="examineway" listKey="key"
                                 listValue="value" value="1"></s:radio></td>
                </tr>
                <tr>
                    <td>选课人数:&nbsp;</td>
                    <td><s:textarea name="num" value="" cssClass="inputcss"></s:textarea></td>
                </tr>

                <tr>
                    <td>试卷份数:&nbsp;</td>
                    <td><s:textarea name="tnum" value="" cssClass="inputcss"></s:textarea></td>
                </tr>

                <tr>
                    <td>课程性质:&nbsp;</td>
                    <td><s:textarea name="nature" value="实践" cssClass="inputcss"></s:textarea></td>
                </tr>

                <tr>
                    <td>评分标准:&nbsp;</td>
                    <td><s:radio list="#{1:'有',0:'无' }" name="standard" value="0"></s:radio></td>
                </tr>

                <tr>
                    <td>试卷分析:&nbsp;</td>
                    <td><s:radio list="#{1:'有',0:'无' }" name="analyzes" value="0"></s:radio></td>
                </tr>

                <tr>
                    <td>考试大纲:&nbsp;</td>
                    <td><s:radio list="#{1:'有',0:'无' }" name="plan" value="0"></s:radio></td>
                </tr>

                <tr>
                    <td>成绩单&nbsp;:&nbsp;</td>
                    <td><s:radio list="#{1:'有',0:'无' }" name="score" value="0"></s:radio></td>
                </tr>

                <tr>
                    <td>系&nbsp;&nbsp;别:&nbsp;</td>
                    <td>
                        <s:property value="#session.globleUser.deptview"/>
                        <s:hidden name="deptid" value="%{#session.globleUser.deptid}"></s:hidden></td>
                </tr>
                <tr>
                    <td>年&nbsp;&nbsp;级:&nbsp;</td>
                    <td><input name="grade" value="" class="inputcss"></td>
                </tr>
                <tr>
                    <td>备&nbsp;注:</td>
                </tr>
            </table>
            <table>
                <br>
                <s:textarea name="comment" cols="38" rows="4" cssStyle="margin-left: 90px; width: 60%"></s:textarea>
                <tr>
                <tr height="26px"></tr>
                <td width="44px;"></td>
                <td>
                    <input type="submit" style="margin-left: 48px;" value="提交" class="button">
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