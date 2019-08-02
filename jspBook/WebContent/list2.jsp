<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import= "java.util.*" %>
<%@ page import= "java.sql.*" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

	<style>
	table {border-collapse : collapse;}
	td.htitle {background-color : yellow;}
		 
	
	</style>


<body>

<%
	Connection conn = null;	//데이터베이스 연결 객체 선언(아직 메모리에 x)
	Statement stmt = null; 	//sql 문장 처리용 객체(아직 메모리에 x)
	ResultSet rs = null;	//조회된 테이블 결과 저장 객체(select 실행시 필요스, 그 외는 불필요)
	String sql = "";		//쿼리작성용 문자열 query = sql 같은 말
	
	 try {
	        Class.forName("org.sqlite.JDBC"); // JDBC 드라이버 로드. 성공하면 ok, 여기서 실패하면, DB 처리 에러라는 문구를 뜨게할거임.
	        out.print("드라이버로드 OK<br>");
	        conn = DriverManager.getConnection("jdbc:sqlite:D:\\sqlite3\\mydb.db");
	        out.print("DB 연결 OK <br>");
	        stmt = conn.createStatement(); //쿼리 실행용 객체 생성
	        
	        sql = "select * from board order by b_num desc"; // 역순으로, 즉 최근글이 맨 위에보이고 옛날글이 맨 아래로 보이게
	        rs = stmt.executeQuery(sql); //쿼리 실행해서 결과를 rs 변수에 반환받음. rs는 굉장히 거대한 변수이다. 그래서 반드시 limit offset 이랑 같이 써야함.	        
	 } 
	   catch(Exception e) {
	        out.print(e.toString() + "db 에러 ");       
   
	 }
%>	


<a href= './WriteJSP.jsp'> 글쓰기 </a>
<h1> 게시판리스트 </h1>
<table border ='1'></table>
<tr>
   <td class='htitle' width='80'> 번호 </td> 
   <td class='htitle' width='300'> 제목 </td>
   <td class='htitle' width='100'> 작성자 </td>
   <td class='htitle' width='80'> 조회수 </td>
   <td class='htitle' width='150'> 작성일 </td>

</tr>
	
	
<%
	while (rs.next()){ // 레코드가 있으면 참, 없으면 거짓. 없으면 끝내버리자. 있는만큼만 반복. // 인덱스보다 필드명으로 불러오는게 더 좋음
		int b_num = rs.getInt("b_num"); // 테이블 필드명을 매개변수로 사용한다
		String b_subject = rs.getString("b_subject");
		String b_name = rs.getString("b_name");
		int b_visit = rs.getInt("b_visit");
		String b_date = rs.getString("b_date");
		String b_contents = rs.getString("b_contents");

%>
	<tr>
		<td align='center'><%=b_num%> </td>
		<td><%=b_subject%> </td>
        <td align='center'><%=b_name%> </td>
		<td align='center'><%=b_visit%> </td>
		<td align='center'><%=b_date%> </td>
	</tr>

<% 

// out.print(b_num + "==" + b_subject + "==" + b_name + "==" + b_visit + "==" + b_date + "==" + b_contents +"<br>");	
}

%>
	
</table>

<%	
	   try {
		   rs.close(); // 얘도 반드시 객체 닫아야함 필수 꼭 출력 후에 닫기.
		   stmt.close(); // 객체닫기
		   conn.close();  // 객체 닫기
	   }
	   catch (Exception e) {
		   out.print(e.toString() + "DB 닫기 에러 ");
	   }
%>
	 
	
</body>
</html>