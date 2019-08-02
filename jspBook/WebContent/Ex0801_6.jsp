<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import = "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%

 	out.print("5초마다 시간이 갱신되는 코드입니다.");
	out.print("<hr>");
	
	response.setIntHeader("Refresh", 5);
	Calendar cal = Calendar.getInstance();

	int hh = cal.get(Calendar.HOUR_OF_DAY);
	int ms = cal.get(Calendar.MINUTE);
	int ss = cal.get(Calendar.SECOND);
	
	out.print(hh + ":" + ms + ":" + ss + "<br>");
%>

</body>
</html>