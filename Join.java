package movie;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Join extends JFrame {
	
	
	Connection conn;
	PreparedStatement pstmt;
	String sql;
	ResultSet result;

	private JPanel contentPane;
	private JTextField txtUserID;
	private JTextField txtUserPWD;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Join frame = new Join();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Join() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblJoin = new JLabel("join");
		lblJoin.setHorizontalAlignment(SwingConstants.CENTER);
		lblJoin.setFont(new Font("Jura SemiBold", Font.BOLD, 20));
		lblJoin.setBounds(12, 10, 410, 39);
		contentPane.add(lblJoin);
		
		JLabel lblUsername = new JLabel("username");
		lblUsername.setFont(new Font("Jura SemiBold", Font.BOLD, 13));
		lblUsername.setBounds(23, 87, 83, 15);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setFont(new Font("Jura SemiBold", Font.BOLD, 13));
		lblPassword.setBounds(23, 116, 83, 15);
		contentPane.add(lblPassword);
		
		txtUserID = new JTextField();
		txtUserID.setBounds(134, 84, 116, 21);
		contentPane.add(txtUserID);
		txtUserID.setColumns(10);
		
		txtUserPWD = new JTextField();
		txtUserPWD.setBounds(134, 113, 116, 21);
		contentPane.add(txtUserPWD);
		txtUserPWD.setColumns(10);
		
		JButton btnJoin = new JButton("join");
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbconnect();
				String uid = txtUserID.getText();
	            String upwd = txtUserPWD.getText(); 
	            
	             if(!chkDuplicate(uid)) {
	            	 sql =  "insert into memberlist values (?, ?)";


	            	 try {
	            		 pstmt = conn.prepareStatement(sql);
	            		 pstmt.setString(1, uid);
	            		 pstmt.setString(2, upwd);
	            	
	            		 int rst = pstmt.executeUpdate();
	            		 if(rst==1)JOptionPane.showMessageDialog(null, uid + " 님, 회원가입을 축하합니다");

	            	 } 
	            	 catch (SQLException e1) {
	            		 // TODO Auto-generated catch block
	            		 e1.printStackTrace();
	            	 }
	             }else JOptionPane.showMessageDialog(null, " 이미 있는 ID 입니다. ");
		
				
			}
		});
		btnJoin.setBounds(279, 83, 97, 23);
		contentPane.add(btnJoin);
	}
	
	
	void dbconnect() {
		
	     try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "madang", "madang");
			 
		} 
	     catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("드라이버가 로드되지 않았습니다.");
			e.printStackTrace();
		} 
	     catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("데이터베이스 연결에 문제가 있습니다.");
			e.printStackTrace();

		} // end of catch SQL
	}// end of dbconnect
	boolean chkDuplicate(String newID) {
		boolean flag = false;
		dbconnect();
		String uid = newID;
       sql = "SELECT * FROM memberlist WHERE userid=?"; 
       try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uid);

			  //질의 실행 
           result = pstmt.executeQuery();
           
           if(result.next()) flag = true;
           else flag = false;
       }	// end of try 
   
       catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
       } // end of catch			
       return flag;
	}

}// end of class
