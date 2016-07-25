<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>课程实践表</title>
    <link href="css/table.css" rel="stylesheet" type="text/css">
    <script type="text/javascript">
        $(function () {
            OAUtils.tpaper.initEvent();
        });
    </script>
</head>

<body>
<div id="container">
    <span style="font-size: 18px;color: #2a6496">当前位置->期末实训详情表</span>
    <div id="txt" class="form-group">
        <div id="txt1">
            <s:form id="queryForm" method="post">
                <s:textfield name="tpQuery.grade" placeholder="请选择要查询的年级"></s:textfield>
            </s:form>
        </div>
        <div id="txt2" style="margin-top: 10px">
            <button id="queryBtn" class="btn btn-primary">查询</button>
            &nbsp;&nbsp;
            <button id="exportBtn" class="btn btn-primary" style="margin-left: 0px;">导出
            </button>
            <a href="tPAction_addUI.action" target="iframe">
                <button
                        class="btn btn-primary" style="margin-left: 20px">新增
                </button>
            </a>
        </div>
    </div>
    <br>
    <table width="1258" border="1" cellspacing="0" cellpadding="0">

        <tr >

            <td height="51">序号</td>

            <td>姓名</td>

            <td>课程</td>

            <td>班级</td>

            <td>试题来源</td>

            <td>考核方式</td>

            <td>选课人数</td>

            <td>试卷份数</td>

            <td>课程性质</td>

            <td>试卷分析</td>

            <td>考核大纲</td>
            <td>评分标准</td>
            <td>成绩单</td>
            <td>备注</td>
            <td>系别</td>
            <td>年级</td>
            <%
                if (popedomCode.contains("ab")) {
            %>
            <td colspan="2">操作</td>
            <%
                }
            %>
        </tr>
        <s:iterator value="#trainingPapers.rows" status="r">
            <tr bgcolor="#f0f6fa">

                <td width="42" height="39"><s:property value="#r.index+1"/></td>

                <td width="48"><s:property value="teacher"/></td>

                <td width="98"><s:property value="course"/></td>

                <td width="86"><s:property value="className"/></td>

                <td width="75"><s:property value="psourceview"/></td>

                <td width="76"><s:property value="examinewayview"/></td>

                <td width="76"><s:property value="num"/></td>

                <td width="69"><s:property value="tnum"/></td>

                <td width="78"><s:property value="nature"/></td>

                <td width="69"><s:if test="analyzes==1">有</s:if> <s:else>无</s:else></td>

                <td width="72"><s:if test="plan==1">有</s:if> <s:else>无</s:else></td>
                <td width="48"><s:if test="standard==1">有</s:if> <s:else>无</s:else></td>
                <td width="67"><s:if test="score==1">有</s:if> <s:else>无</s:else></td>
                <td width="64"><s:property value="comment"/></td>
                <td width="70"><s:property value="deptidview"/></td>
                <td width="68"><s:property value="grade"/></td>
                <%
                    if (popedomCode.contains("ab")) {
                %>
                <td width="57"><a href="tPAction_updateUI.action?tid=<s:property value="tid"/>">修改</a></td>

                <td width="57"><a
                        href="tPAction_delete.action?tid=<s:property value="tid"/>" onclick="return confirm('你确定要删除？')">删除</a></td>
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
                <s:url action="tPAction_list">
                    <s:param name="tpQuery.grade" value="%{#grade}"/>
                    <s:param name="tpQuery.currentPage">1</s:param>
                </s:url>">首页</a>
            <a class="btn btn-primary" href="
                <s:url action="tPAction_list">
                    <s:param name="tpQuery.grade" value="%{#grade}"/>
                    <s:param name="tpQuery.currentPage">
                      ${tpQuery.currentPage-1<=1?1:tpQuery.currentPage-1}
                    </s:param>
                </s:url>">上一页</a>
            <a class="btn btn-primary" href="<s:url action="tPAction_list">
				       <s:param name="tpQuery.grade" value="%{#grade}"/>
                       <s:param name="tpQuery.currentPage">${tpQuery.currentPage+1>=trainingPapers.totalPages?trainingPapers.totalPages:tpQuery.currentPage+1}</s:param>
                     </s:url>">下一页</a>
            <a class="btn btn-primary" href="
                <s:url action="tPAction_list">
                    <s:param name="tpQuery.grade" value="%{#grade}"/>
                    <s:param name="tpQuery.currentPage">
                        ${trainingPapers.totalPages}
                    </s:param>
                </s:url>"> 尾页</a>
            <span class="btn btn-primary">
                <s:property value="%{#trainingPapers.currentPage}"/>
                /<s:property value="%{#trainingPapers.totalPages}"/>页
            </span>
        </div>
    </div>
</div>
</body>

</html>