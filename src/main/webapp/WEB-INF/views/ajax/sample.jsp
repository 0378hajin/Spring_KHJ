<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax 예제</title>
<!-- servletContextPath 설정을 추가하여 가상 경로를 지정한다. -->
<script src = "<%= request.getContextPath()%>/js/jquery-3.6.0.min.js">
</script>
<script>
function userInfo() {
	var pjtpath = '<%= request.getContextPath()%>';
	$.ajax({
		url : pjtpath+'/ajax/userInfo.do',
		type : "get",
		success : function(data){
			/*$("#result").html(data);*/
			console.log(data);
			$("#result").html(data.id + ", " + data.name +", "+ data.password +", "+ data.midx);
		}
	});
}
function goText(){
	
	$.ajax({
		url : 'goText.do',
		type : "get",
		data : "text="+$("#t1").val(),
		success : function(data) {
			$("#result2").html(data);
		}
	});
}
function callBoard() {
	$.ajax({
		url : "boardList.do",
		type : "get",
		success : function(data) {
			var html = "";
			html += "<table border = '1'>";
			html += "<thead>";
			html += "<tr>";
			html += "<th>글번호</th>";
			html += "<th>제목</th>";
			html += "<th>작성자</th>";
			html += "</tr>";
			html += "</thead>";
			html += "<tbody>";
			for(var i = 0; i <data.length; i++){
				html += "<tr>";
				html += "<td>"+data[i].bidx+"</td>";
				//a 태그에서 javascript실행
				html += "<td><a href = 'javascript:viewBoard("+data[i].bidx+")'>"+data[i].title+"</a></td>";
				html += "<td>"+data[i].name+"</td>";
				html += "</tr>";
			}
			html += "</tbody>";
			html += "</table>";
			
			$("#boardList").html(html);
		}
		
	});
}
function viewBoard(bidx){
	$.ajax({
		url : "BoardView.do",
		type : "get",
		data : "bidx=" + bidx,
		success : function(data){
			var html = ""; 
			html += "글번호 : " + data.bidx + "<br>";
			html += "제목 : " + data.title + "<br>";
			html += "내용 : " + data.content + "<br>";
			html += "작성자 : " + data.name + "<br>";
			html += "작성일 : " + data.wdate + "<br>";
			
			$("#boardView").html(html);
		}
	});
}
function searchGo(){
	$.ajax({
		url : "boardList.do",
		type : "get",
		//serialize() 셀렉터 form 안에 있는 name을 가지고 있는 모든 입력양식 데이터를 파라미터 문자열로 반환
		data : $("#searchFrm").serialize(),
		success : function(data) {
			var html = "";
			html += "<table border = '1'>";
			html += "<thead>";
			html += "<tr>";
			html += "<th>글번호</th>";
			html += "<th>제목</th>";
			html += "<th>작성자</th>";
			html += "</tr>";
			html += "</thead>";
			html += "<tbody>";
			for(var i = 0; i <data.length; i++){
				html += "<tr>";
				html += "<td>"+data[i].bidx+"</td>";
				//a 태그에서 javascript실행
				html += "<td><a href = 'javascript:viewBoard("+data[i].bidx+")'>"+data[i].title+"</a></td>";
				html += "<td>"+data[i].name+"</td>";
				html += "</tr>";
			}
			html += "</tbody>";
			html += "</table>";
			
			$("#boardList").html(html);
		}
	});
}
</script>
</head>
<body>
	<h2>ajax 예제 페이지</h2>
	<hr>
	<!-- css, javaScript,이미지등은 webapp/resources 폴더에 보관한다. -->
	<button onclick = "userInfo()">현재 로그인 유저 정보 확인</button>
	<div id = "result">
		
	</div>
	
	<hr>
	<input type = "text" id = "t1">
	<button onclick = "goText()">click</button>
	<div id = "result2">
	</div>
	<hr>
	<button onclick = "callBoard()">게시글 불러오기</button>
	<br>
	<form id = "searchFrm">
		<select name = "searchType">
			<option value = "title" >제목</option>
			<option value = "contentWriter">내용+작성자</option>
		</select>
		<input type = "text" name = "searchValue">
		<input type = "button" value = "검색" onclick = "searchGo()">
	</form>
	
	<br>
	<div id = "boardList">
	</div>
	
	<div id = "boardView">
	
	</div>
</body>
</html>