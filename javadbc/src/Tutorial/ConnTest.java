package Tutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement; //insert into (?,?,?) ?가 PreparedStatement
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnTest {
	
	public static Connection getConnection() {
		String driver = "oracle.jdbc.driver.OracleDriver"; //mysql 커넥팅 com.mysql.jdbc.Driver
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
		//무조건 외우쇼 standard는 xe 대신 ocl로  mysql은 jdbc:myslq://localhost/dev(dev는 DB명임)
		String user = "hr";
		String pwd = "hr";
		Connection conn = null;
		try {
			Class.forName(driver); // 1.오라클 드라이버 로딩 "oracle.jdbc.driver.OracleDriver" 넣어도 된다
		} catch (ClassNotFoundException e) {
			// 
			e.printStackTrace();
		}  
		try {
			conn = DriverManager.getConnection(url, user, pwd);  // 2. DB 연결 
			System.out.println("Database connected successfully...");
		} catch (SQLException e) {
			// 
			e.printStackTrace();
		}
		return conn;
	} //DriverManager end

	public static void updateSample(Connection conn) {
		//String sql = "update employees set email = '"+ email +"'+"'where employee_id"' = ?";
		String sql = "update employees set email = ? where employee_id = ?"; //?는 preparedStatement 의 주요 특징입니다
		PreparedStatement psmt = null;
		String email = "chunkbuk";
		int id = 100; 
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, email);
			psmt.setInt(2, id);
			
			int count = psmt.executeUpdate();
			
			System.out.println(count + " 개의 데이타가 업데이트 되었습니다.");
			
		} catch (Exception e) {
		    e.printStackTrace();
		}

		
	}
	public static void selectList(Connection conn) {
		// 
		String sql = "select * from employees";
		PreparedStatement psmt;
		ResultSet result;
		
		try {
			psmt = conn.prepareStatement(sql);
			result = psmt.executeQuery();
			while(result.next()) {
				int employee_id = result.getInt("employee_id"); //[1] 인덱스로 주어도 출력은 된다
				String first_name = result.getString("first_name"); //[2] 인덱스로 주어도 출력은 된다
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
				
			} // end of while
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Connection conn = getConnection();
		PreparedStatement psmt = null; 
		// sql은 Statement와 PreparedStatement 사용 가능하나 
		// statement 끊어서 쿼리를 만들어야 해서 불편하다
		// 그래서 preparedStatement를 쓴다
		ResultSet result= null;  // 넘어오는 레코드가 한행이 아니라 여러 행일 수 있어서 ResultSet을 쓰며 import 해야 함
		String sql;

		//selectList(conn); //selectList 호출
		updateSample(conn);
		
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} //main end
} //class end
