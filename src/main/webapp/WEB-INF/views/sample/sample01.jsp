<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String data = (String)request.getAttribute("key");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>sample01</h1>
<!-- 
	Home.jsp에서 sample01.do 링크 클릭시 sample01.jsp로 포워딩하기
	이때 컨트롤에서는 '안녕하세요' 라는 데이터를 받아와서 출력하시오
 -->
 <%= data %>
 	<form action = "sample2.do" method = "post">
		data : <input type = "text" name = "testData"> <br>
 		<input type = "submit">
	 </form>
</body>
</html>