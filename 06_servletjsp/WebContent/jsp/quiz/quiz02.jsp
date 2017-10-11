<%@page import="jsp.Test"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	List<Test> list = new ArrayList<>();
	Test t = new Test();
	t.setMsg("성공");
	list.add(t);
	pageContext.setAttribute("list", list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title</title>
</head>
<body>
	<%--
		실행시 화면에 "성공" 이라고 뜨도록 코딩 작성
	 --%>
	${list[0].msg}	
</body>
</html>