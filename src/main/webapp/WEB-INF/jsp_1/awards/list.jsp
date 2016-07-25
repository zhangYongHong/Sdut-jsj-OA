<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>表格</title>
    <link href="css/table.css" rel="stylesheet" type="text/css">
    <script type="text/javascript">
        $(function() {
            OAUtils.apaper.initEvent();
        });
    </script>
</head>

<body>
<div id="container">
    <span style="font-size: 18px;color: #2a6496">当前位置->大学生研究与创新活动获奖情况表</span>
    <div id="txt" class="form-group">
        <div id="txt1">
            <s:form id="queryForm" method="post">
                <s:textfield name="awardsQuery.grade" placeholder="请输入要查询的年份"></s:textfield>
            </s:form>
        </div>
        <div id="txt2">
            <button id="queryBtn"  class="btn btn-primary">查询</button>
            &nbsp;&nbsp;
            <%
                if(popedomCode.contains("abc")) {
            %>
            <button  id="exportBtn" class="btn btn-primary" style="margin-left: 0px;">导出</button>
            <% }%>
            <a href="awardsAction_addUI.action" target="iframe">
                <button class="btn btn-primary" style="margin-left: 20px">新增
                </button>
            </a>
        </div>
    </div>
    <br>
    <table width="1277" border="1" cellspacing="0" cellpadding="0">

        <tr >

            <td height="51">序号</td>

            <td>竞赛项目</td>

            <td>成果展示</td>

            <td>获奖级别</td>

            <td>获奖等级</td>

            <td>参赛学生</td>

            <td>专业</td>

            <td>班级</td>

            <td>指导老师姓名</td>

            <td>获奖时间</td>

            <td>颁奖单位</td>

            <td>备注</td>
            <%
                if(popedomCode.contains("ab")) {
            %>
            <td colspan="2">操作</td>
            <%
                }
            %>
        </tr>
        <s:iterator value="#awardsPapers.rows" status="i">
            <tr bgcolor="#f0f6fa">

                <td width="36" height="39"><s:property value="#i.index+1"/></td>

                <td width="170"><s:property value="competitionview"/></td>

                <td width="170"><s:property value="achievement"/></td>

                <td width="89"><s:property value="levelview"/></td>

                <td width="75"><s:property value="gradeview"/></td>

                <td width="76"><s:property value="stuname"/></td>

                <td width="93"><s:property value="deptview"/></td>

                <td width="69"><s:property value="classe"/></td>

                <td width="73"><s:property value="teacher"/></td>

                <td width="83"><s:property value="atime"/></td>

                <td width="131"><s:property value="prizeunit"/></td>

                <td width="78"><s:property value="comment"/></td>
                <%
                    if(popedomCode.contains("ab")) {
                %>

                <td width="50"><a href="3.html" target="iframe">修改</a></td>

                <td width="54"><a href="" onclick="location.replace('');">删除</a></td>
                <%
                    }
                %>
            </tr>
        </s:iterator>
    </table>
    <br> <br>
    <div id="under" style="margin-left: 75%">
        <div>
            <a class="btn btn-primary" href="
                <s:url action="awardsAction_list">
                    <s:param name="awardsQuery.currentPage">1</s:param>
                </s:url>">首页</a>
            <a class="btn btn-primary" href="
                <s:url action="awardsAction_list">
                    <s:param name="awardsQuery.currentPage">
                      ${awardsQuery.currentPage-1<=1?1:awardsQuery.currentPage-1}
                    </s:param>
                </s:url>">上一页</a>
            <a class="btn btn-primary" href="
				<s:url action="awardsAction_list">
                       <s:param name="awardsQuery.currentPage">${awardsQuery.currentPage+1>=awardsPapers.totalPages?awardsPapers.totalPages:awardsQuery.currentPage+1}</s:param>
                     </s:url>">下一页</a>
            <a class="btn btn-primary" href="
                <s:url action="awardsAction_list">
                    <s:param name="awardsQuery.currentPage">
                        ${qustionPapers.totalPages}
                    </s:param>
                </s:url>"> 尾页</a>
            <span class="btn btn-primary"><s:property value="%{#awardsPapers .currentPage}"/>/
                <s:property value="%{#awardsPapers.totalPages}"/>页</span>
        </div>
    </div>
</div>

</body>

</html>