<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
</head>
<body>
	<h2>${vo.name }의 마이페이지</h2>
	회원 번호 : ${vo.midx } 번<br>
	id : ${vo.id}<br>
	password : ${vo.password }<br>
	name : ${vo.name }
	<br>
	
	<button onclick = "location.href = 'modify.do?midx=${vo.midx}'">수정하기</button>
</body>
</html>