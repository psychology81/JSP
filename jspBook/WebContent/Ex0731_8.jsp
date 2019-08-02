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
	 for (int i = 0; i < 5; i++) {
		 for (int j =0 ; j < i+1; j++) { // j를 가지고 처리를 해야함
			  out.print("*");  //다음 줄로 자동으로 변환되는 코드가 필요함. 한 행을 마감짓는 단위를 찾아야함, 
	 }
	 	 out.print("<br>"); // 그래서 이렇게 줄바꿈을 해줘야한다네요.ㄴ
	 }
	%>



    <br><br> <br> -------------구분선--------<br><br><br>
		<%
	 for (int i = 0; i < 5; i++) {
     	for (int j = 5; j > i; j--) { // j를 가지고 처리를 해야함
			 out.print("*");  //다음 줄로 자동으로 변환되는 코드가 필요함. 한 행을 마감짓는 단위를 찾아야함, 
	 }
	 	 out.print("<br>"); // 그래서 이렇게 줄바꿈을 해줘야한다네요.ㄴ
	 }
	%>
	

    <br><br> <br> -------------구분선--------<br><br><br>




</body>
</html>