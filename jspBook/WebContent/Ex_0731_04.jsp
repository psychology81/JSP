<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>

	<%!
	int count = 0;
	%>
	
	page count is
	<%
	out.print(++count);%>
	<br>
------------------------------------<br>

	<%
		for (int i = 0; i <= 10; i++) {
			if (1 % 2 ==0)
				out.println(i + "<br>");
		}
	%>


</body>
</html>