package Tutorial;

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

public class LoginTest extends JFrame {

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
               LoginTest frame = new LoginTest();
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
   public LoginTest() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 286, 271);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      JLabel lblUserId = new JLabel("User ID");
      lblUserId.setBounds(44, 86, 57, 15);
      contentPane.add(lblUserId);
      
      JLabel lblUserPwd = new JLabel("User PWD");
      lblUserPwd.setBounds(44, 124, 57, 15);
      contentPane.add(lblUserPwd);
      
      txtUserID = new JTextField();
      txtUserID.setBounds(113, 83, 116, 21);
      contentPane.add(txtUserID);
      txtUserID.setColumns(10);
      
      txtUserPWD = new JTextField();
      txtUserPWD.setColumns(10);
      txtUserPWD.setBounds(113, 121, 116, 21);
      contentPane.add(txtUserPWD);
      
      JButton btnLogin = new JButton("Login");
      btnLogin.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            
            // DB Connection
            Connection conn = null;
            PreparedStatement pstmt = null;
            ResultSet result = null;
            String sql = null;
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String user = "madang";
            String pwd = "madang";
            
            //질의 구성
            
            try {
               Class.forName("oracle.jdbc.driver.OracleDriver");
               conn = DriverManager.getConnection(url, user, pwd);
               sql = "SELECT * FROM members WHERE userid=? AND userpwd = ?";
               pstmt = conn.prepareStatement(sql);
               pstmt.setString(1, txtUserID.getText());
               pstmt.setString(2, txtUserPWD.getText());
               
               
               //질의 실행 
               result = pstmt.executeQuery();
               
               
               // 결과 처리 
               if(result.next()) {
                  JOptionPane.showMessageDialog(null, "로그인 성공");
               }else {
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
      btnLogin.setBounds(25, 162, 97, 23);
      contentPane.add(btnLogin);
      
      JButton btnCancel = new JButton("Cancel");
      btnCancel.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            System.exit(0);
         }
      });
      btnCancel.setBounds(138, 162, 97, 23);
      contentPane.add(btnCancel);
      
      JLabel lblLoginTest = new JLabel("Login Test");
      lblLoginTest.setHorizontalAlignment(SwingConstants.CENTER);
      lblLoginTest.setFont(new Font("Tahoma", Font.BOLD, 13));
      lblLoginTest.setBounds(92, 10, 82, 43);
      contentPane.add(lblLoginTest);
   }

}