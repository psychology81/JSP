package movie;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class admin extends JFrame {
	
	
	Connection conn;
	PreparedStatement pstmtmovie, pstmtmember;
	String sqlmovie, sqlmember;
	ResultSet resultmovie, resultmember;
	

	private JPanel contentPane;
	private JTextField txtTitle;
	private JTextField txtRuntime;
	private JTextField txtGenre;
	private JTextField txtAge;
	private JTable movieTable;
	private JTextField txtSearchTitle;
	private JTable memberTable;
	private JTextField txtUserID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin frame = new admin();
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
	public admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1040, 563);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWahtcha = new JLabel("WATCHA");
		lblWahtcha.setHorizontalAlignment(SwingConstants.CENTER);
		lblWahtcha.setFont(new Font("Metal Mania", Font.PLAIN, 25));
		lblWahtcha.setBounds(0, 0, 1017, 52);
		contentPane.add(lblWahtcha);
		
		JLabel title = new JLabel("TITLE");
		title.setBounds(52, 92, 57, 15);
		contentPane.add(title);
		
		JLabel lblNewLabel = new JLabel("RUN TIME");
		lblNewLabel.setBounds(52, 122, 57, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("GENRE");
		lblNewLabel_1.setBounds(52, 154, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("AGE LIMIT");
		lblNewLabel_2.setBounds(52, 185, 67, 15);
		contentPane.add(lblNewLabel_2);
		
		txtTitle = new JTextField();
		txtTitle.setBounds(125, 89, 116, 21);
		contentPane.add(txtTitle);
		txtTitle.setColumns(10);
		
		txtRuntime = new JTextField();
		txtRuntime.setBounds(125, 120, 116, 21);
		contentPane.add(txtRuntime);
		txtRuntime.setColumns(10);
		
		txtGenre = new JTextField();
		txtGenre.setBounds(125, 151, 116, 21);
		contentPane.add(txtGenre);
		txtGenre.setColumns(10);
		
		txtAge = new JTextField();
		txtAge.setBounds(125, 182, 116, 21);
		contentPane.add(txtAge);
		txtAge.setColumns(10);
		
		JLabel lblStars = new JLabel("STARS");
		lblStars.setBounds(52, 216, 57, 15);
		contentPane.add(lblStars);
		
		JComboBox ComboStars = new JComboBox();
		ComboStars.setModel(new DefaultComboBoxModel(new String []
				{"★", "★★", "★★★", "★★★★", "★★★★★"}));
		ComboStars.setBounds(125, 213, 116, 21);
		contentPane.add(ComboStars);
		
		JLabel lblReview = new JLabel("REVIEW");
		lblReview.setBounds(52, 255, 57, 15);
		contentPane.add(lblReview);
		
		JTextArea txtReview = new JTextArea();
		txtReview.setBackground(Color.PINK);
		txtReview.setBounds(125, 255, 254, 213);
		contentPane.add(txtReview);
		
		
		//-------------      --------------------------- MOVIE TABLE ---------------------------------------- //

		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(445, 121, 330, 347);
		contentPane.add(scrollPane);
		
		movieTable = new JTable();
		movieTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				 // 테이블을 클릭했을 때 / 행을 추출하고 / 추출된 행의 각 칼럼값을 / 왼쪽에 있는 텍스트필드들에 / 전달한다.
				movieTload(); 
				dbconnect();// 맨먼저 항상 db 연결
				int row = movieTable.getSelectedRow();    //  행 추출
				System.out.println("rowcnt" + row);
				String userid = (movieTable.getModel().getValueAt(row, 0)).toString(); // getValueAt 은 기본적으로 int 를 String으로 변환해줘야함. 
				System.out.println(userid);
				  sqlmovie = "SELECT * FROM movie WHERE userid=?";  // sql 에서 클릭한 값에 해당하는 uid를 이용해, db를 검색하고, 검색된 결과를, 텍스트필드에 전달.
				  
		            try {
						pstmtmovie = conn.prepareStatement(sqlmovie);
						pstmtmovie.setString(1, userid);
			
						  //질의 실행 
			            resultmember = pstmtmember.executeQuery();
			            
			            while(resultmovie.next()) {
			            	String MVuserid = resultmovie.getString("userid");
			            	String MVfilm = resultmovie.getString("title");
							String MVruntime = resultmovie.getString("runtime");
							String MVgenre = resultmovie.getString("genre");
							String MVage = resultmovie.getString("age");
							txtUserID.setText(MVuserid);
							txtTitle.setText(MVfilm);
							txtRuntime.setText(MVruntime);
							txtGenre.setText(MVgenre);
							txtAge.setText(MVage);
							
			            } // end of while 
		            }	// end of try 
		            catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
		            } // end of catch		
				
				
				
				
				
			}
		});
		scrollPane.setViewportView(movieTable);
		movieTable.setBackground(Color.PINK);
		
		

		//-------------      ---------------------------   L O A D ---------------------------------------- //
		
		
		
		JButton btnLoad = new JButton("LOAD");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbconnect();
				sqlmovie = "SELECT * FROM movie";
				sqlmember = "select * from memberlist";
				try {
					pstmtmovie = conn.prepareStatement(sqlmovie);
					resultmovie = pstmtmovie.executeQuery();
					movieTable.setModel(DbUtils.resultSetToTableModel(resultmovie)); // 질의 결과를 테이블에 넘겨준다.
					
					pstmtmember = conn.prepareStatement(sqlmember);
					resultmember = pstmtmember.executeQuery();
					memberTable.setModel(DbUtils.resultSetToTableModel(resultmember)); // 질의 결과를 테이블에 넘겨준다.
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				
				} // end of catch
				
			} // end of action P
		});
		btnLoad.setBounds(680, 51, 95, 23);
		contentPane.add(btnLoad);

		//-------------      --------------------	-----------------  A D D ---------------------------------------- //
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dbconnect();
				sqlmovie = "SELECT * FROM movie";
				sqlmember = "select * from memberlist";
				
				String MVuserid = txtUserID.getText();
				String MVfilm = txtTitle.getText();
				String MVruntime = txtRuntime.getText();
				String MVgenre = txtGenre.getText();
				String MVage = txtAge.getText();
			
			
	
	             if(!chkDuplicate(MVuserid)) {
	            	 sqlmovie =  "insert into members values (?, ?, ?, ?,?)";


	            	 try {

	            		 pstmtmovie = conn.prepareStatement(sqlmovie);
	            		 pstmtmovie.setString(1, MVuserid);
	            		 pstmtmovie.setString(2, MVfilm);
	            		 pstmtmovie.setString(3, MVruntime);
	            		 pstmtmovie.setString(4, MVgenre);
	            		 pstmtmovie.setString(5, MVage);
	            		 int rst = pstmtmovie.executeUpdate();
	            		 if(rst==1)JOptionPane.showMessageDialog(null, MVuserid + " 계정을 추가 하였습니다");

	            	 } 
	            	 catch (SQLException e1) {
	            		 // TODO Auto-generated catch block
	            		 e1.printStackTrace();
	            	 }
	             }else JOptionPane.showMessageDialog(null, "중복된 레코드가 있습니다");
			movieTload();	
			
			}
		});
		btnAdd.setBounds(293, 88, 86, 23);
		contentPane.add(btnAdd);
		
		
		//------------------------------------------	-----------DELETE-----------------------	 -----------------------------------	//
		
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbconnect();
				sqlmovie = "SELECT * FROM movie";
				sqlmember = "select * from memberlist";
				String userid = txtUserID.getText();
	            sqlmovie = "DELETE from movie WHERE userid=?";
	            
	            
				try {
					pstmtmovie = conn.prepareStatement(sqlmovie);
					pstmtmovie.setString(1, userid);
					int rst = pstmtmovie.executeUpdate();
					if(rst==1)JOptionPane.showMessageDialog(null, userid + " 계정을 삭제하였습니다.");
				
				} 
				
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				movieTload();
			}
		});
		btnDelete.setBounds(293, 150, 86, 23);
		contentPane.add(btnDelete);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 System.exit(0);
			}
		});
		btnExit.setBounds(919, 476, 86, 23);
		contentPane.add(btnExit);
		
		
		
		
		// ---------------------    -----------------   ----- update ------------- ---------- ----------------//
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbconnect();
				movieTload();
				sqlmovie = "SELECT * FROM movie";
				sqlmember = "select * from memberlist";
				
				String MVuserid = txtUserID.getText();
				String MVfilm = txtTitle.getText();
				String MVruntime = txtRuntime.getText();
				String MVgenre = txtGenre.getText();
				String MVage = txtAge.getText();
			
			
	
	             if(!chkDuplicate(MVuserid)) {
	            	 sqlmovie =  "insert into members values (?, ?, ?, ?,?)";


	            	 try {

	            		 pstmtmovie = conn.prepareStatement(sqlmovie);
	            		 pstmtmovie.setString(1, MVuserid);
	            		 pstmtmovie.setString(2, MVfilm);
	            		 pstmtmovie.setString(3, MVruntime);
	            		 pstmtmovie.setString(4, MVgenre);
	            		 pstmtmovie.setString(5, MVage);
	            		 int rst = pstmtmovie.executeUpdate();
	            		 if(rst==1)JOptionPane.showMessageDialog(null, MVuserid + " 계정을 추가 하였습니다");

				}   catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				movieTload();
				
	             }}
		});
		btnUpdate.setBounds(293, 118, 86, 23);
		contentPane.add(btnUpdate);
		
		
		
		
		
		
		txtSearchTitle = new JTextField();
		txtSearchTitle.setBounds(552, 85, 116, 21);
		contentPane.add(txtSearchTitle);
		txtSearchTitle.setColumns(10);
		
		JLabel lblSearch = new JLabel("SEARCH TITLE");
		lblSearch.setBounds(445, 88, 95, 15);
		contentPane.add(lblSearch);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSearch.setBounds(680, 84, 95, 23);
		contentPane.add(btnSearch);
		
		
		
		//-------------      --------------------------- MEMBER TABLE ---------------------------------------- //
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(790, 122, 215, 346);
		contentPane.add(scrollPane2);
	
		memberTable = new JTable();
		memberTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

		
			}
		});
		scrollPane2.setViewportView(memberTable);
		
		
		JLabel lblMemberList = new JLabel("MEMBER LIST");
		lblMemberList.setBounds(789, 92, 116, 15);
		contentPane.add(lblMemberList);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(52, 62, 57, 15);
		contentPane.add(lblId);
		
		txtUserID = new JTextField();
		txtUserID.setBounds(125, 58, 116, 21);
		contentPane.add(txtUserID);
		txtUserID.setColumns(10);
		

		//------------------------------------------	-----------reset-----------------------	 -----------------------------------	//
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				dbconnect();
				movieTload();
				sqlmovie = "SELECT * FROM movie";
				sqlmember = "select * from memberlist";
				String userid = txtUserID.getText();
	            sqlmovie = "SELECT * FROM members WHERE userid=?"; 
	            try {
					pstmtmovie = conn.prepareStatement(sqlmovie);
					pstmtmovie.setString(1, userid);
		
					  //질의 실행 
		            resultmovie = pstmtmovie.executeQuery();
		            
		            while(resultmovie.next()) {
		            	String MVuserid = resultmovie.getString("userid");
		            	String MVfilm = resultmovie.getString("title");
						String MVruntime = resultmovie.getString("runtime");
						String MVgenre = resultmovie.getString("genre");
						String MVage = resultmovie.getString("age");
						txtUserID.setText(MVuserid);
						txtTitle.setText(MVfilm);
						txtRuntime.setText(MVruntime);
						txtGenre.setText(MVgenre);
						txtAge.setText(MVage);
						
		            } // end of while 
	            }	// end of try 
	        
	            catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
	            } // end of catch			
	            
			}
		});
		btnReset.setBounds(293, 181, 86, 23);
		contentPane.add(btnReset);
	} // end of
	
	
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
		String userid = newID;
       sqlmember = "SELECT * FROM members WHERE userid=?"; 
       try {
			pstmtmember = conn.prepareStatement(sqlmember);
			pstmtmember.setString(1, userid);

			  //질의 실행 
           resultmember = pstmtmember.executeQuery();
           
           if(resultmember.next()) flag = true;
           else flag = false;
       }	// end of try 
   
       catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
       } // end of catch			
       return flag;
       
       
	} // end of boolean chkDuplicate();
	

		

	private void movieTload() {
		dbconnect();
		sqlmovie = "SELECT * FROM movie";
		sqlmember = "select * from memberlist";
		try {
			pstmtmovie = conn.prepareStatement(sqlmovie);
			resultmovie = pstmtmovie.executeQuery();
			movieTable.setModel(DbUtils.resultSetToTableModel(resultmovie)); // 질의 결과를 테이블에 넘겨준다.
			
			pstmtmember = conn.prepareStatement(sqlmember);
			resultmember = pstmtmember.executeQuery();
			memberTable.setModel(DbUtils.resultSetToTableModel(resultmember)); // 질의 결과를 테이블에 넘겨준다.
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		
		}//end of catch
	     
		
		
	
} // end of class 
}
