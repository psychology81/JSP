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
	 String aaa = "";
	 int bbb = 3;
	 int ccc = 1164;
	 String ddd = "신펜리";
	 /* 위 변수들을 사용해서 다음과 같은 문자열을 만들고 aaa 에 저장하라 
	    문자열 : '신펜리'의 나이는 '3살' 이고, 주소는 '1164번길' 입니다.
	 */

	
	aaa = " ' " + ddd + " '의 나이는' "+ bbb +" '살이고 주소는' "+ ccc +" ' 번길 입니다. ";
	 
	 
	out.print(aaa+"<br>");
	 // aaa = "";
	 // aaa = " '내용입력' ";
	 // aaa = " ' "내용1" + " '내용2' "
			 
	 
	%>
	<hr><hr>
	<%
	String abc = "";
	int bb = 3;
	String cc = "펜리";
	
	abc = " "'bb'" ";
	%>

</body>
</html>