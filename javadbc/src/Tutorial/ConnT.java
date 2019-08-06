package Tutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnT {

	public static Connection getConnection () {
		String user = "hr";
		String pwd = "hr";
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; //이거는 그냥 외우기, 오라클에 연결하는거임.
		Connection conn=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(url, user, pwd);
			System.out.println("database connected succesfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return conn;
		
	}//end getConnection ()
	
	public static void selectList(Connection conn, PreparedStatement pstmt, ResultSet result) {
		String sql = "SELECT * FROM employees";
		
		try {
			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeQuery(); //질의던지는 구문
		
		
		while(result.next()) {
			int employee_id = result.getInt("employee_id");
			String first_name = result.getString("first_name");
			String last_name = result.getString("last_name");
			String email = result.getString("email");
			String phone_number = result.getString("phone_number");
			String hire_date = result.getString("hire_date");
			String job_id = result.getString("job_id");
			int  salary = result.getInt("salary");
			int  commission_pct = result.getInt("commission_pct");
			int  manager_id = result.getInt("manager_id");
			int  department_id = result.getInt("department_id");
			
			System.out.println(employee_id + " : " + first_name + " : " + last_name + " : " + email + " : " 
			                 + phone_number + " : " + hire_date + " : " + job_id + " : " 
			                 + salary + " : " + commission_pct + " : " + manager_id + " : " + department_id);
		}// end of while 
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static void updateSample(Connection conn) {
		String sql = null;
		PreparedStatement pstmt = null;
		
		String email = "Chungbuk";
		int empid = 100;
		
		sql = "update employees set email= ? WHERE employee_id=?"; 
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setInt(2, empid);
			
			int count = pstmt.executeUpdate();
			
			System.out.println(count + "개의 데이터가 업데이트되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = getConnection(); //이렇게만 하면 겟커넥션에 오류가 뜨기때문에 메인함수 밖에 메소드만들어줌
		PreparedStatement pstmt = null; //sql 구문을 구성을 할때 statement와 preparestatement가 있음. 
		ResultSet result = null;
		String sql;
		
		//selectList(conn);
		updateSample(conn);
		
		/*
		// while loop 이용, CRUD 만들어 보기		
				try {
					selectList(conn, pstmt, result);
				} finally {
					try {
						//result.close();
						//pstmt.close();
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}*/ //이거는 리스트 전체를 볼 때 살려야함.
				
				

	}//end main 

}//end class
