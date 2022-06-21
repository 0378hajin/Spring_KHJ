<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 보기</title>
</head>
<body>
	<h2>게시글 보기</h2>
	<hr>
	<table border = "1">
		<tbody>
			<tr>
				<td>글 번호</td>
				<td>${vo.bidx}</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${vo.name}</td>
			</tr>
			<tr>
				<td>작성일</td>
				<td>${vo.wdate}</td>
			</tr>
			<tr>
				<td>제목</td>
				<td>${vo.title}</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>${vo.content}</td>
			</tr>
		</tbody>
	</table> 
	<br>
	<c:if test="${login.midx ne vo.midx}">
		<button>수정</button>
		<button>삭제</button>
	</c:if>
		<button onclick = "location.href = 'list.do'">목록</button>
</body>
</html>