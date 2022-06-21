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
<h1>sample02</h1>
<!-- 
	Home.jsp에서 sample02.do 링크 클릭시 sample02.jsp로 포워딩하기
	이때 컨트롤에서는 'hello' 라는 데이터를 받아와서 출력하시오
 -->
  <%= data %>
</body>
</html>