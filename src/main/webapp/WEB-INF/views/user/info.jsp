<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	String data1 = (String)request.getAttribute("name");
	int data2 = (Integer)request.getAttribute("age");
	String data3 = (String)request.getAttribute("addr");
	String data4 = (String)request.getAttribute("phone");
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- 이름 : <%=data1 %><br>
나이 : <%=data2 %><br>
주소 : <%=data3 %><br>
연락처 : <%=data4 %><br> --%> 

	이름 : ${vo.name} <br>
	나이 : ${vo.age} <br>
	주소 : ${vo.addr} <br>
	연락처 : ${vo.phone} <br>
	
</body>
</html>