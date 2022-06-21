<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
</head>
<body>
	<h2>게시글 작성</h2>
	<hr>
	
	<form action = "write.do" method = "post">
	<table border = "1">
		<thead>
			<tr>
				<td>글 제목</td>
				<td><input type = "text" name = "title"></td>
			</tr>	
		</thead>
		<tbody>
			<tr>
				<td>내용</td>
				<td><textarea row = "10" cols = "50" name = "content" placeholder = "내용을 입력해주세요."></textarea></td>
			</tr>
		</tbody>
	</table>
	<br>
	<button>저장</button>
	</form>
	
</body>
</html>