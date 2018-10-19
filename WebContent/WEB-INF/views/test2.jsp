<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>MVC</h1>
	<small>총방문객: <fmt:formatNumber value="${visit }"/></small>
	<ul>
	<c:forEach var="t" items="${requestScope.arr }">
		<li>${t }</li>
	</c:forEach>
	</ul>
</body>
</html>