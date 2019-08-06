package Tutorial;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class MemberInfo extends JFrame {
	
	Connection conn;
	PreparedStatement pstmt;
	String sql;
	ResultSet result;
	
	private JPanel contentPane;
	private JTextField txtUserID;
	private JTextField txtUserPWD;
	private JTextField txtAdr;
	private JTextField txtPhone;

																				
	/**
	 * Create the frame.
	 */
	public MemberInfo() {
		setTitle("Member Information Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 445);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMemberInformationForm = new JLabel("MEMBER INFORMATION FORM");
		lblMemberInformationForm.setHorizontalAlignment(SwingConstants.CENTER);
		lblMemberInformationForm.setFont(new Font("Jura SemiBold", Font.PLAIN, 20));
		lblMemberInformationForm.setBounds(0, 27, 588, 15);
		contentPane.add(lblMemberInformationForm);
		
		txtUserID = new JTextField();
		txtUserID.setFont(new Font("Jura SemiBold", Font.PLAIN, 13));
		txtUserID.setBounds(143, 88, 116, 21);
		contentPane.add(txtUserID);
		txtUserID.setColumns(10);
		
		txtUserPWD = new JTextField();
		txtUserPWD.setFont(new Font("Jura SemiBold", Font.PLAIN, 13));
		txtUserPWD.setBounds(143, 119, 116, 21);
		contentPane.add(txtUserPWD);
		txtUserPWD.setColumns(10);
		
		JLabel UserID = new JLabel("USERNAME");
		UserID.setFont(new Font("Jura SemiBold", Font.PLAIN, 13));
		UserID.setBounds(37, 91, 94, 15);
		contentPane.add(UserID);
		
		JLabel UserPWD = new JLabel("PASSWORD");
		UserPWD.setFont(new Font("Jura SemiBold", Font.PLAIN, 13));
		UserPWD.setBounds(37, 122, 94, 15);
		contentPane.add(UserPWD);

	//------------------------------------------	--------------SEARCH---------------------	 -----------------------------------	//
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dbconnect();
			String uid = txtUserID.getText();
            sql = "SELECT * FROM members WHERE userid=?"; 
            try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, uid);
	
				  //질의 실행 
	            result = pstmt.executeQuery();
	            
	            while(result.next()) {
	            	String Vuserid = result.getString("userid");
					String Vuserpwd = result.getString("userpwd");
					String Vads = result.getString("address");
					String Vphone = result.getString("phone");
					txtUserID.setText(Vuserid);
					txtUserPWD.setText(Vuserpwd);
					txtAdr.setText(Vads);
					txtPhone.setText(Vphone);
					
	            } // end of while 
            }	// end of try 
        
            catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
            } // end of catch			
			} // end of void action performed
		});
		btnSearch.setFont(new Font("Jura SemiBold", Font.PLAIN, 12));
		btnSearch.setBounds(283, 88, 94, 23);
		contentPane.add(btnSearch);
		
		
		
		//------------------------------------------	-----------ADD------------------------	 -----------------------------------	//

		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setFont(new Font("Jura SemiBold", Font.PLAIN, 12));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbconnect();
				String uid = txtUserID.getText();
	            String upwd = txtUserPWD.getText(); 
	            String uadr = txtAdr.getText();
	            String uphone = txtPhone.getText();
	            
	             if(!chkDuplicate(uid)) {
	            	 sql =  "insert into members values (?, ?, ?, ?)";


	            	 try {
	            		 pstmt = conn.prepareStatement(sql);
	            		 pstmt.setString(1, upwd);
	            		 pstmt.setString(2, uid);
	            		 pstmt.setString(3, uadr);
	            		 pstmt.setString(4, uphone);
	            		 int rst = pstmt.executeUpdate();
	            		 if(rst==1)JOptionPane.showMessageDialog(null, "1개의 레코드를 추가 하였습니다");

	            	 } 
	            	 catch (SQLException e1) {
	            		 // TODO Auto-generated catch block
	            		 e1.printStackTrace();
	            	 }
	             }else JOptionPane.showMessageDialog(null, "중복된 레코드가 있습니다");
				
			}
		});
		
		
		btnAdd.setBounds(389, 88, 94, 23);
		contentPane.add(btnAdd);
	
		
		//------------------------------------------	-----------UPDATE------------------------	 -----------------------------------	//

		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbconnect();
				String uid = txtUserID.getText();
	            String upwd = txtUserPWD.getText(); 
	            String uadr = txtAdr.getText();
	            String uphone = txtPhone.getText(); 
	            sql =  "UPDATE members SET userpwd=?, address=?, phone=? WHERE userid=?";
	            
	            
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, upwd);
					pstmt.setString(2, uadr);
					pstmt.setString(3, uphone);
					pstmt.setString(4, uid);
					int rst = pstmt.executeUpdate();
					if(rst==1)JOptionPane.showMessageDialog(null, "1개의 레코드를 업데이트 하였습니다");
				
				}   catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnUpdate.setFont(new Font("Jura SemiBold", Font.PLAIN, 12));
		btnUpdate.setBounds(389, 119, 94, 23);
		contentPane.add(btnUpdate);
		
		
		//------------------------------------------	-----------DELETE-----------------------	 -----------------------------------	//

		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dbconnect();
				String uid = txtUserID.getText();
	            sql = "DELETE from members WHERE userid=?";
	            
	            
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, uid);
					int rst = pstmt.executeUpdate();
					if(rst==1)JOptionPane.showMessageDialog(null, "1개의 레코드를 업데이트 하였습니다");
				
				} 
				
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnDelete.setFont(new Font("Jura SemiBold", Font.PLAIN, 12));
		btnDelete.setBounds(389, 152, 94, 23);
		contentPane.add(btnDelete);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 System.exit(0);
				
			}
		});
btnExit.setFont(new Font("Jura SemiBold", Font.PLAIN, 12));
		btnExit.setBounds(389, 218, 94, 23);
		contentPane.add(btnExit);
		
		
		//------------------------------------------	-----------RESET-----------------------	 -----------------------------------	//

		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dbconnect();
				String uid = txtUserID.getText();
	            sql = "SELECT * FROM members WHERE userid=?"; 
	            try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, uid);
		
					  //질의 실행 
		            result = pstmt.executeQuery();
		            
		            while(result.next()) {
		            	String Vuserid = result.getString("userid");
						String Vuserpwd = result.getString("userpwd");
						String Vads = result.getString("address");
						String Vphone = result.getString("phone");
						txtUserID.setText("");
						txtUserPWD.setText("");
						txtAdr.setText("");
						txtPhone.setText("");
						
		            } // end of while 
	            }	// end of try 
	        
	            catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
	            } // end of catch			
	            
			}
		});
		btnReset.setBounds(389, 185, 94, 23);
		contentPane.add(btnReset);
		
		txtAdr = new JTextField();
		txtAdr.setFont(new Font("Jura SemiBold", Font.PLAIN, 13));
		txtAdr.setBounds(143, 150, 116, 21);
		contentPane.add(txtAdr);
		txtAdr.setColumns(10);
		
		
		
		
		
		//------------------------------------------	-----------ADDRESS-----------------------	 -----------------------------------	//

		
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setFont(new Font("Jura SemiBold", Font.PLAIN, 13));
		lblAddress.setBounds(37, 154, 94, 15);
		contentPane.add(lblAddress);
		
		txtPhone = new JTextField();
		txtPhone.setFont(new Font("Jura SemiBold", Font.PLAIN, 13));
		txtPhone.setBounds(143, 181, 116, 21);
		contentPane.add(txtPhone);
		txtPhone.setColumns(10);
		
		
		//------------------------------------------	-----------PHONE-----------------------	 -----------------------------------	//

		
		JLabel lblPhone = new JLabel("PHONE");
		lblPhone.setFont(new Font("Jura SemiBold", Font.PLAIN, 13));
		lblPhone.setBounds(37, 184, 94, 15);
		contentPane.add(lblPhone);
	} // end of memberInfo();
	
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
        sql = "SELECT * FROM members WHERE userid=?"; 
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
	
}// end of
