package Tutorial;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class LoginForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtUserID;
	private JTextField txtUserPWD;
	static LoginForm frame = new LoginForm();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} // end of void main

	/**
	 * Create the frame.
	 */
	public LoginForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 484, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeToJavadb = new JLabel("Welcome to JAVADB CLASS");
		lblWelcomeToJavadb.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToJavadb.setFont(new Font("Jura SemiBold", Font.BOLD, 15));
		lblWelcomeToJavadb.setBounds(0, 33, 468, 15);
		contentPane.add(lblWelcomeToJavadb);
		
		txtUserID = new JTextField();
		txtUserID.setFont(new Font("Jura SemiBold", Font.PLAIN, 12));
		txtUserID.setBounds(300, 76, 116, 21);
		contentPane.add(txtUserID);
		txtUserID.setColumns(10);
		
		txtUserPWD = new JTextField();
		txtUserPWD.setFont(new Font("Jura SemiBold", Font.PLAIN, 12));
		txtUserPWD.setBounds(300, 122, 116, 21);
		contentPane.add(txtUserPWD);
		txtUserPWD.setColumns(10);
		
		JLabel Uid = new JLabel("USER NAME");
		Uid.setFont(new Font("Jura Medium", Font.PLAIN, 13));
		Uid.setBounds(191, 79, 97, 15);
		contentPane.add(Uid);
		
		JButton joinbt = new JButton("JOIN");
		joinbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				 dispose();
           		// 새로운 화면을 생성한 후 (MenberInfo)
           Join join = new Join();
       
           		// 새로운 화면을 보이게 한다 setVisable(ture);
           join.setVisible(true);
				
				
				
			}
		});
		joinbt.setFont(new Font("Jura SemiBold", Font.PLAIN, 12));
		joinbt.setBounds(185, 183, 97, 23);
		contentPane.add(joinbt);
		

		
		
		JButton loginbt = new JButton("LOGIN");
		loginbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	            // DB Connection
	            Connection conn = null;
	            PreparedStatement pstmt = null;
	            ResultSet result = null;
	            String sql = null;
	            String url = "jdbc:oracle:thin:@localhost:1521:xe";
	            String user = "madang";
	            String pwd = "madang";
	            
	            try {
	               Class.forName("oracle.jdbc.driver.OracleDriver");
	               conn = DriverManager.getConnection(url, user, pwd);
	               
	               String uid = txtUserID.getText(); // 얘 없으면 똑같이 userForm 뜸
	               String upwd = txtUserPWD.getText(); //
	                  
	                  
	               sql = "SELECT * FROM members WHERE userid=? AND userpwd = ?";
	               pstmt = conn.prepareStatement(sql);
	               pstmt.setString(1, txtUserID.getText());
	               pstmt.setString(2, txtUserPWD.getText());
	               
	               result = pstmt.executeQuery();
	               
	               if(result.next()) {
	                     dispose();
	                     if(uid.equals("admin")) {  //새로운 화면을 생성한 후
	                     MemberInfo membinfo = new MemberInfo();
	                     membinfo.setVisible(true);//새로운 화면을 보이게 한다.
	                     }
	                     else {
	                        UserForm userform = new UserForm();
	                        userform.setVisible(true);
	                     }
	                  }
	                  else {
	                     JOptionPane.showMessageDialog(null, "로그인 실패");
	                  }
	                  
	               
	               
	            } catch (ClassNotFoundException e1) {
	               // TODO Auto-generated catch block
	               e1.printStackTrace();
	            }  catch (SQLException e1) {
	               // TODO Auto-generated catch block
	               e1.printStackTrace();
	            }
				
			}
		});
		loginbt.setFont(new Font("Jura SemiBold", Font.PLAIN, 12));
		loginbt.setBounds(319, 183, 97, 23);
		contentPane.add(loginbt);
		
		JLabel Upw = new JLabel("PASSWORD");
		Upw.setFont(new Font("Jura Medium", Font.PLAIN, 13));
		Upw.setBounds(191, 125, 97, 15);
		contentPane.add(Upw);
		
		JLabel label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/login.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(10, 63, 136, 189);
		contentPane.add(label);
	} // end of public login form
} // end of calss
