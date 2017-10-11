<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	List<String> list = new ArrayList<>();
	list.add("one");
	list.add("two");
	list.add("three");
	list.add("four");
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
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
		}
	 --%>
	 <c:forEach var="i" begin="1" end="10">
	 	<c:out value="${i}" /><br>
	 </c:forEach>
	 
	 생년월일 : 
	 <select>
	 <c:forEach var="i" begin="1970" end="2010">
	 	<option><c:out value="${i}" /></option>
	 </c:forEach>
	 </select>
	 <br>
	 
	 <%--
	 	for (String s : list) {
	 		System.out.println(s)
	 	}
	  --%>
	 <c:forEach var="s" items="${list}">
	 	<c:out value="${s}" /><br>
	 </c:forEach>
	 
	 <c:set var="first" value="true" />
	 <c:forEach var="s" items="${list}">
	 	<c:if test="${not first}">,</c:if>
	 	<c:out value="${s}" />
		<c:set var="first" value="false" />
	 </c:forEach>
	 
	 <br>
	 <c:forEach var="s" items="${list}" varStatus="loop">
	 	${loop.first}:::${loop.last}:::${loop.index}:::${loop.count}<br>
	 </c:forEach>	
	 
	 <c:forEach var="s" items="${list}" varStatus="loop">
	 	<c:if test="${not loop.first}">,</c:if>
	 	<c:out value="${s}" />
	 </c:forEach>
</body>
</html>



















