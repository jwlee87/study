<%@ page contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title</title>
<%@ include file="/WEB-INF/jsp/include/basicInclude.jsp" %>
</head>
<body>
<div class="container">
	<div class="header">
		<c:import url="/WEB-INF/jsp/include/topMenu.jsp" />
	</div>
	
	<div class="content">
		<h1>메인 페이지~!</h1>
	</div>
	
	<div class="bottom">
		<c:import url="/WEB-INF/jsp/include/bottom.jsp" />
	</div>
</div>
</body>
</html>