<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>

	<h2>회원가입</h2>
	<form action = "join.do" method = "post">	
		id : <input type = "text" name = "id"> <br>
		password : <input type = "password" name = "password"> <br>
		이름 : <input type = "text" name = "name"> <br>
		<input type = "submit" value = "회원가입">
	</form>

</body>
</html>