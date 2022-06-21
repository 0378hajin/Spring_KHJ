<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "info.do" method = "post">
		이름 : <input type = "text" name = "name"> <br>
		나이 : <input type = "number" name = "age"> <br>
		주소 : <input type = "text" name = "addr"> <br>
		연락처 : <input tyep = "text" name = "phone"> <br>
		<input type = "submit" value = "전송">
	</form>
</body>
</html>