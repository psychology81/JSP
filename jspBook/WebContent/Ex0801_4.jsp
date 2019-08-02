<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	// response.sendRedirect("./Ex0801_5.jsp"); //이렇게하면 바로 5.jsp로 넘어간다. 근데 얘를 주석처리해줘야 alert 뜸.
	%> 
	
	<script>
	  alert("다른 페이지로 이동합니다"); //메시지 상자
	  location.href='./Ex0801_5.jsp';   // 지정된 url로 이동 하는 함수
	</script>


</body>
</html>