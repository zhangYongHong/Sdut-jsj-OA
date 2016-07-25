<%@ taglib prefix="s" uri="/struts-tags" %>
<link type="text/css" rel="stylesheet" href="css/blue/pageCommon.css"/>
<link type="text/css" rel="stylesheet" href="css/style.css"/>
<link href="css/elements.css" rel="stylesheet" type="text/css">
<script language="javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.2.js"></script>
<script language="javascript" src="${pageContext.request.contextPath}/js/OAUtils.js"></script>
<link href="/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<%
    String popedomCode = (String) request.getSession().getAttribute("globleUserRole");
    response.setHeader("P3P","CP=CAO PSA OUR");
%>