<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드</title>
</head>
<body>
	<h2>파일 업로드</h2>
	<hr>
	<form action = "upload.do" method = "post" enctype = "multipart/form-data">
		파일 : <input type = "file" name = "file">
		
		<br>
		<input type = "submit" value = "업로드">
	</form>
</body>
</html>