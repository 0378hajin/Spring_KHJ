<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보 수정</title>
</head>
<body>
	<h2>내 정보 수정</h2>
	
	<form action = "modify.do" method = "post">
		<input type = "hidden" name = "midx" value = "${vo.midx }">
		midx : ${vo.midx } 번<br>
		id : ${vo.id } <br>
		password : <input type = "password" name = "password" value = "${vo.password }"> <br>
		name : <input type = "text" name = "name" value = "${vo.name }"> <br>
		
		<input type = "submit" value = "저장">
	
	</form>
	
	
</body>
</html>