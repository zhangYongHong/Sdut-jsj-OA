<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<html>
<head>
    <title>role</title>
</head>
<body>
    <s:select list="#roleList" id="role" name="role" listKey="ddlCode" listValue="ddlName" headerKey="0" headerValue="请选择">
        
    </s:select>
</body>
</html>
