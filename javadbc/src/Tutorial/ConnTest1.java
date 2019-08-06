package Tutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;;


public class ConnTest1 {
	//질의구문
	private static Connection getConnection() {
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String pwd = "hr";
		
		Connection conn = null;
		
		// 질의실행
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} // end of try 1
		
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // end of catch
		
		try {
			conn = DriverManager.getConnection(url, user, pwd);
			
			System.out.println("database connected successfully");
			
		} // end of try
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // end of catch
		
		return conn;
	}//end of getConnection 
	
	
	
	public static void selectList(Connection conn, PreparedStatement pstmt, ResultSet result) {
		String sql = "SELECT * FROM employees";
		
		
			
			try {
				pstmt = conn.prepareStatement(sql);
				result = pstmt.executeQuery();

			
			//result 있는 동안 실행할 것 
			while(result.next()) {
				int employee_id = result.getInt("employee_id");
				String first_name = result.getString("first_name");
				String last_name = result.getString("last_name");
				String email = result.getString("email");
				String phone_number = result.getString("phone_number");
				String hire_date = result.getString("hire_date");
				String job_id = result.getString("job_id");
				int salary = result.getInt("salary");
				int commission_pct = result.getInt("commission_pct");
				int manager_id = result.getInt("manager_id");
				int department_id = result.getInt("department_id");
				
				System.out.println(employee_id + " : " + first_name + " : " + last_name + " : " + email + " : " 
				                 + phone_number + " : " + hire_date + " : " + job_id + " : " 
				                 + salary + " : " + commission_pct + " : " + manager_id + " : " + department_id);
			}// end of while	
			
			
			} //end of try
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // end of catch  레코드 출력 완료 
			
	} // end of selectlist
			
			public static void selectList(Connection conn) {
				String sql = null;
				PreparedStatement pstmt =null;
				
				String email = "chungbuk";
				int empid = 100;
				sql= "UPDATE employees set email= ? WHERE employee_id= ?";
					
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt = setString(1, email);
					pstmt = setInt(2, empid);
					
					int count = pstmt.executeUpdate();
					System.out.println(count + "개의 데이터가 업데이트 되었습니다.");
					
					

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
			} //end of update
					
			
		



	private static PreparedStatement setString(int i, String email) {
				// TODO Auto-generated method stub
				return null;
			}



	private static PreparedStatement setInt(int i, int empid) {
				// TODO Auto-generated method stub
				return null;
			}



	public static void main(String[] args) {
		Connection conn = getConnection(); // import java sql connection 클릭\
		PreparedStatement pstmt = null;
		ResultSet result = null;
		String sql;
		
		
	//	selectList(conn, pstmt, result);
		updatesample(conn);
		
		
		
		
		
	} // end of main



	private static void updatesample(Connection conn) {
		// TODO Auto-generated method stub
		
	}



	} // end of GetConnection
	
	

