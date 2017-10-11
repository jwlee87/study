<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("msg", "pageContext msg");
	request.setAttribute("msg", "request msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title</title>
</head>
<body>
	msg : ${msg}<br>
	request msg : ${requestScope.msg}<br>
</body>
</html>















