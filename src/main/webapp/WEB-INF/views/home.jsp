<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>
<head>
	<meta charset = "UTF-8">
	<title>Home</title>
</head>
<body>
<h1>
	Hello world! 
	<c:if test = "${login != null }">
		${login.name}님 환영합니당!
	</c:if> 
</h1>

<P>  The time on the server is ${serverTime}. </P>
<a href = "sample1.do">sample01.do</a> |
<a href = "sample2.do">sample02.do</a> |
<a href = "user/register.do">register</a> |
<c:if test = "${login == null}">
	<a href = "user/join.do">회원가입</a> | 
	<a href = "user/login.do">로그인</a> |
</c:if>
<c:if test = "${login != null }">
	<a href = "user/mypage.do">마이페이지</a> |
	<a href = "user/logout.do">로그아웃</a> |
</c:if>
<a href = "board/list.do">게시판으로 이동하기</a> |
<a href = "ajax/sample.do">ajax 예제로 이동하기</a> |
<a href = "file/sample.do">file upload 예제로 이동하기</a>

</body>
</html>
