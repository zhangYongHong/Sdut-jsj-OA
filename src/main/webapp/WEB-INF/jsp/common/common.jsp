<%--
  Created by IntelliJ IDEA.
  User: mnzero
  Date: 16-7-5
  Time: 下午4:22
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String popedomCode = (String) request.getSession().getAttribute("globleUserRole");
    response.setHeader("P3P","CP=CAO PSA OUR");
%>