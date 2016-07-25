<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>期末考试考场详情表</title>
    <link href="css/table.css" rel="stylesheet" type="text/css">

    <script type="text/javascript">
        $(function () {
            OAUtils.qpaper.initEvent();
        });
    </script>
</head>
<body>

<div id="container">
    <h4>你当前的位置:期末考试考场详情表</h4>
    <div id="txt">
        <div id="txt1">

            <s:form id="queryForm" method="post">
                <s:textfield name="qpQuery.shoolYear" placeholder="请选择要查询的年级"></s:textfield>
            </s:form>
        </div>
        <div id="txt2">
            <button id="queryBtn">查询</button>
            &nbsp;&nbsp;
            <button id="exportBtn" style="margin-left: 0px;">导出</button>
            <a href="qPAction_addUI.action" target="iframe">
                <button style="margin-left: 20px">新增
                </button>
            </a>
        </div>
    </div>
    <br>
    <div id="">
        <form action="qPAction_uploadExcel.action" enctype="multipart/form-data" method="post">
            <input name="uploadfile" type="file">
            <input type="submit" value="上传">
        </form>
    </div>
    <br>

    <table width="1256" border="1" cellspacing="0" cellpadding="0">

        <tr bgcolor="#e6eff5" style="font-weight: bold;">

            <td height="51">序号</td>

            <td>授课教师</td>

            <td>授课班级</td>

            <td>课程名称</td>

            <td>试题来源</td>

            <td>考核方式</td>

            <td>人&nbsp;&nbsp;数</td>

            <td>试卷份数</td>

            <td>试卷考核</td>

            <td>考核大纲</td>

            <td>监考记录</td>
            <td>AB卷</td>
            <td>标准答案</td>
            <td>评分标准</td>

            <td>成绩单</td>
            <td>备注</td>
            <td colspan="2">橱号归档</td>
            <%--<%--%>
            <%--if (popedomCode.contains("ab")) {--%>
            <%--%>--%>
            <td colspan="2">操作</td>
            <%--<%--%>
            <%--}--%>
            <%--%>--%>
        </tr>
        <s:iterator value="#qustionPapers.rows" status="i">
            <tr bgcolor="#f0f6fa">

                <td width="47" height="39"><s:property value="#i.index+1"/></td>

                <td width="69"><s:property value="teacher"/></td>

                <td width="78"><s:property value="className"/></td>

                <td width="71"><s:property value="course"/></td>

                <td width="75"><s:if test="psource==1">自拟</s:if> <s:elseif
                        test="psource==2">统一命题</s:elseif></td>

                <td width="45"><s:property value="examinewayview"/></td>

                <td width="47"><s:property value="num"/></td>

                <td width="46"><s:property value="pnum"/></td>

                <td width="74"><s:if test="analyzes==1">有</s:if> <s:elseif
                        test="analyzes==0">无</s:elseif></td>

                <td width="72"><s:if test="plan==1">有</s:if> <s:elseif
                        test="plan==0">无</s:elseif></td>

                <td width="73"><s:if test="invigilation==1">有</s:if> <s:elseif
                        test="invigilation==0">无</s:elseif></td>
                <td width="50"><s:if test="ab==1">有</s:if> <s:elseif
                        test="ab==0">无</s:elseif></td>
                <td width="42"><s:if test="answer==1">有</s:if> <s:elseif
                        test="answer==0">无</s:elseif></td>
                <td width="45"><s:if test="standard==1">有</s:if> <s:elseif
                        test="standard==0">无</s:elseif></td>

                <td width="76"><s:if test="score==1">有</s:if> <s:elseif
                        test="score==0">无</s:elseif></td>
                <td width="63"><s:property value="comment"/></td>

                <td width="78"><s:property value="deptidview"/></td>
                <td width="58"><s:property value="grade"/></td>

                <td width="52"><a href="qPAction_updateUI.action?qid=<s:property value="qid"/>">修改</a></td>
                <%
                    if (popedomCode.contains("ab")) {
                %>
                <td width="53"><a href="qPAction_delete.action?qid=<s:property value="qid"/>"
                                  onclick="return confirm('你确定要删除？')">删除</a></td>
                <%
                    }
                %>
            </tr>
        </s:iterator>
    </table>
    <br> <br>
    <div id="under">
        <div class="page_normal">
            <a href="
                <s:url action="qPAction_list">
                <s:param name="qpQuery.shoolYear" value="%{#shoolYear}"/>
                    <s:param name="qpQuery.currentPage">1</s:param>
                </s:url>">首页</a>
            <a href="
                <s:url action="qPAction_list">
					<s:param name="qpQuery.shoolYear" value="%{#shoolYear}"/>
                    <s:param name="qpQuery.currentPage">
                      ${qpQuery.currentPage-1<=1?1:qpQuery.currentPage-1}
                    </s:param>
                </s:url>">上一页</a>
            <a href="<s:url action="qPAction_list">
						<s:param name="qpQuery.shoolYear" value="%{#shoolYear}"/>
                       <s:param name="qpQuery.currentPage">${qpQuery.currentPage+1>=qustionPapers.totalPages?qustionPapers.totalPages:qpQuery.currentPage+1}</s:param>
                     </s:url>">下一页</a>
            <a href="
                <s:url action="qPAction_list">
                <s:param name="qpQuery.shoolYear" value="%{#grade}"/>
                    <s:param name="qpQuery.currentPage">
                        ${qustionPapers.totalPages}
                    </s:param>
                </s:url>"> 尾页</a>
            <p>
                <s:property value="%{#qustionPapers.currentPage}"/>
                /<s:property value="%{#qustionPapers.totalPages}"/>页
            </p>
        </div>
    </div>
</div>
</body>
</html>