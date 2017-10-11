<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title</title>
</head>
<body>
	<c:set var="msg" value="test" />
	<c:set var="msg" value="<h1>test</h1>" />
	
	msg (out 태그) : <c:out value="${msg}" /><br>
	msg (out 태그 escape) : <c:out value="${msg}" escapeXml="false" /><br>
	
	msg (el) : ${msg}<br>
	msg2 : <c:out value="${msg2}" default="msg2 없음" /><br>
</body>
</html>












