<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>지하철 실기간 - 강남</title>
</head>
<body style="text-align: center;">
	<h2>실기간 지하철 교통 상황</h2>
	<form action="${pageContext.servletContext.contextPath }/study/api.do" method="post">
		역명 검색 ▷ 	
		<input type="text" name="station" placeholder="역이름" id="station">
		<button type="submit">검색 </button>
	</form>
	<hr/>
	
<%-- 	<c:forEach var="s" items="#{station }">
		<option value="all">${s.realtimeArrivalList }</option>
		
	
	
	
	</c:forEach> --%>
		


</body>
</html>