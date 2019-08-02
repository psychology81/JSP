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
<body>

<%-- 예외처리가 필요한 부분이 있는데, 1) 네트워트처리 2) 파일처리 같은 경우 그리고 3)데이터베이스  예외처리를 강제로 해줘야함. 군대보내듯이 --%>
 <% //data base 연동하는 과정에서는 3개의 중요한 변수가 필요함. 1) Connection 2)Statement 3)ResultSet

   request.setCharacterEncoding("UTF-8"); // 폼에서 넘어오는 데이터의 한글처리가 이루어진다 
   String b_subject = request.getParameter("b_subject");
   String b_name = request.getParameter("b_name");
   String b_contents = request.getParameter("b_contents");

   Connection conn = null; // 데이터베이스 연결용 객체 ,선언.. 아직 메모리에 없음(null),  필수, 
   Statement stmt = null;  // SQL 문장 처리(문법처리)용 객체,  선언.. 아직 메모리에 없음(null), 필수
   ResultSet rs = null;   // 조회된 테이블 결과 저장 객체 (select 실행시 필요, 그 외에는 불필요함)
   String sql = ""; //sql 다룰 땐 String으로 . 쿼리작성용 문자열
   
  	 Calendar cal = Calendar.getInstance();
	 int yy = cal.get(Calendar.YEAR);
	 int mm = cal.get(Calendar.MONTH);
	 int dd = cal.get(Calendar.DAY_OF_MONTH);
	 int hh = cal.get(Calendar.HOUR_OF_DAY);
	 int ms = cal.get(Calendar.MINUTE);
	 int ss = cal.get(Calendar.SECOND);
	 String b_date = String.format("%02d-%02d-%02d %02d:%02d:%02d",yy,mm,dd,hh,ms,ss);   
   
   try {
        Class.forName("org.sqlite.JDBC"); // JDBC 드라이버 로드. 성공하면 ok, 여기서 실패하면, DB 처리 에러라는 문구를 뜨게할거임.
        out.print("드라이버로드 OK<br>");
        conn = DriverManager.getConnection("jdbc:sqlite:D:\\sqlite3\\mydb.db");
        out.print("DB 연결 OK <br>");
        
        
       // stmt = conn.createStatement(); //쿼리 실행용 객체 생성
        
        
        sql = "INSERT INTO board (b_subject, b_name, b_visit, b_date, b_contents) ";
        sql += "VALUES ('"+ b_subject + "', ";
        sql += b_name + "',0,'";
        sql += b_date + "','";
        sql += b_contents + "')"; 
         		//('테스트', '홍길동', 0, '" +   b_date    + "', '테스트입니다.')";
        		// 문자열에 대한 패턴 조립을 해서 오류없이 해야한다 
       			//  stmt.executeUpdate(sql);
        		// 큰따옴표는
        out.print(sql+"<br>");
        out.print("쿼리실행OK<br>");
   } 
   catch(Exception e) {
        out.print(e.toString() + "db 에러 ");   
   }
   try {
	   stmt.close(); // 객체닫기
	   conn.close();  // 객체 닫기
   }
   catch (Exception e) {
	   out.print(e.toString() + "DB 닫기 에러 ");
   }
 
 %>
</body>
</html>