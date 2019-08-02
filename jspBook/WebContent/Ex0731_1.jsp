<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<%-- <%! int count = 0; %>  //선언문 --%>
<body>


------ 5번 출력해보기 -------------

<%
 out.print("<h1> jsp Test </h1>");
%>
<h2> jst test2 </h2>
<h2> jst test2 </h2>
<h2> jst test2 </h2>
<h2> jst test2 </h2>
<h2> jst test2 </h2>


---- 반복문으로 위의 것 해보기 ---------------------
<% 
  for (int i = 0; i < 5; i++) {
    out.print("<h1> jsp Test </h1>"); 
  }
%>


 <%--	<% out.println(++count);  %>  스크립틀릿, 새로고침할 떄마다 숫자값이 ++ 됨. --%>
 <% out.print(myMethod(0)); 
 %>
 
 <%!
 	public int myMethod(int count) {
	 return ++count;
 }
 %>

</body>
</html>