<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 리스트</title>
</head>
<body>

	<h2>게시판 리스트</h2>
	
	<table border = "1">
		<thead>
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody>
			<c:if test = "${list.size() == 0}">
				<tr>
					<td colspan = "4">등록된 게시글이 없습니다.</td>
				</tr>
			</c:if>
			<c:if test = "${list.size() > 0}">
				<c:forEach var = "vo" items = "${list}">
					<tr>
						<td>${vo.bidx}</td>
						<td><a href = "view.do?bidx=${vo.bidx}">${vo.title}</a></td>
						<td>${vo.name}</td>
						<td>${vo.wdate}</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
	<br>
	<form method = "get" action = "list.do">
		<select name = "searchType">
			<option value = "title" <c:if test = "${!empty searchVo.searchType and searchVo.searchType eq 'title'}">selected</c:if>>제목</option>
			<option value = "contentWriter" <c:if test = "${!empty searchVo.searchType and searchVo.searchType eq 'contentWriter'}">selected</c:if>>내용+작성자</option>
		</select>
		<input type = "text" name = "searchValue" <c:if test = "${!empty searchVo.searchValue}">value = "${serachVo.searchValue}"</c:if>>
		<input type = "submit" value = "검색">
	</form>
	<br>

	<button onclick = "goWrite()">등록</button>

	
	<script>
		function goWrite(){
			//el 그대로 적용이 가능하다. 문자열로 감싸야 오류가 나지 않는다.
			//el은 null을 그대로 출력하지 않는다.
			var login = '${login}';
			console.log(login);
			
			if (login != ""){
				//링크 형식을 무조건 get방식으로 넘어간다.
				location.href = "write.do";
			} else {
				alert("로그인을 해주세요.");
			}
			
		}
		
	</script>
</body>
</html>