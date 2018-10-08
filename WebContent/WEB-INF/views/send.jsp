<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring MVC</title>
</head>
<body>
	<button type="button" onclick="send();">AJAX(POST)1</button>
	<button type="button" onclick="send2();">AJAX(POST)2</button>
	<script>
		/*
			Ajax get 은 주소뒤에 ?키=값&키=값 이렇게 해서 보내고 , parameter로만 뽑는다.
			Ajax post 는 JSON 문자열로 보내서 , requestBody 뽑아서 처리하는 방식
			 			?키=값&키=값 의 형태의 문자열을 보내면서 , header 설정해주고 parameter로 처리
		*/
		var send = function() {
			var xhr = new XMLHttpRequest();
			xhr.open("post","${pageContext.servletContext.contextPath}/study/13ajax.do",true);
			var param={
					"talker":"saan",
					"mode":1,
					"ment":"ajax의 Post요청은 send시 문자열을 데이터를 설정해서 전송"
			}
			xhr.send(JSON.stringify(param));
		};
		
		var send2 = function() {
			var xhr = new XMLHttpRequest();
			xhr.open("post","${pageContext.servletContext.contextPath}/study/13ajax.do",true);
			var param=
					"talker=saan";
				param+="mode=1";
				param+="ment=ajax의 Post요청은 send시 문자열을 데이터를 설정해서 전송";
				xhr.setRequestHeader("content-type","application/x-www-form-urlencoded");
				xhr.send(JSON.stringify(param));
			};
		
	
	</script>
	
</body>
</html>