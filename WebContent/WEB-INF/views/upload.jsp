<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MultiPart</title>
</head>
<body>
	<h1>Multipart/form-data</h1>
	<p>
		파일데이터와 같이 전송시키려면
		method="post" enctype를 multipart/form-data 로 설정해야한다.
	</p>
	<a href="<c:url value="/storage/14.SQL"/>" download> 다운로드 </a>
	<form action="27.do" method="post" enctype="multipart/form-data">
		INFO : <input type="text" name="info"/> /
		ATTACH : <input type="file" name="attach"/>
		<br/>
		<button type="submit">전송</button>
	</form>
</body> 
</html>