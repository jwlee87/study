<%@page import="jsp.Count"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	Count c = new Count();
	c.setNum(100);	
	pageContext.setAttribute("c", c);
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	프로젝트 경로명 : ${pageContext.request.contextPath}<br>
	c.num : ${c.num}<br>
	c["num"] : ${c["num"]}<br>
	
	<%-- 오류 발생
	c.val : ${c.val}<br>   
	 --%>
	<%-- c.getVal() --%>
</body>
</html>














