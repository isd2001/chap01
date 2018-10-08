<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Multipart / form-data</title>
</head>
<body>
	<h1>MultipartResolver</h1>
	<p>
		같은 이름으로 여러개의 파일을 설정해서 넘길수 있게 뷰 구현을
		해두었다면 MultiparFile[] 로 받아서 처리를 하면된다.<br/>
		같은 이름으로 파일여러개가 넘어온다면 , 배열로 받아야되는데 , 
		파일이 실제 하나도 안넘어오더라도 , 이건 length=1 , 하나가 넘어와도 length =1 / isEmpty 체크 <br/>
		29.do 컨트롤러 작성하는데 , 여기에서 파일 몇개 가 넘어 오는지 확인.
		
	</p>
	
	<h2>다중업로드#1</h2>
	<small>최대 3개 가능</small>
	<form action="29.do" method="post" enctype="multipart/form-data">
		첨부 1 : <input type="file" name="attach" onchange="out(this);"/><br/>
		첨부 2 : <input type="file" name="attach" /><br/>
		첨부 3 : <input type="file" name="attach" /><br/>
		<button type="submit">Upload</button>			
	</form>
	<script>
		var out= function(target){
			window.alert(target.files[0].name);
		}
	</script>
	
	<h2>다중업로드#2</h2>
	<small>upload 하고자 하는 file(들)을 선택해주세요.여러개의 파일은 ctrl 누른상태에서 클릭해주세요.</small>
	<form action="29.do" method="post" enctype="multipart/form-data">
		첨부  : <input type="file" name="attach" multiple onchange="check(this);"/><br/>
		
		<button type="submit">Upload</button>			
	</form>
	
	<script>
	var check = function(target){
		console.log(target.files.length);	
		for (var i = 0; i < target.files.length; i++) {
			console.log(target.files[i].name);
		}		
	}
	</script>
	

</body>
</html>