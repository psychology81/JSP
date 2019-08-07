package movie;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class guest extends JFrame {
	
	
	Connection conn;
	PreparedStatement pstmt;
	String sql;
	ResultSet result;
	

	private JPanel contentPane;
	private JTextField txtFilm;
	private JTextField txtDate;
	private JTextField txtGenre;
	private JTextField txtAge;
	private JTable table;
	private JTextField txtSearchTitle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					member frame = new member();
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
	public guest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1033, 561);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWahtcha = new JLabel("WATCHA");
		lblWahtcha.setHorizontalAlignment(SwingConstants.CENTER);
		lblWahtcha.setFont(new Font("Metal Mania", Font.PLAIN, 25));
		lblWahtcha.setBounds(0, 10, 1017, 52);
		contentPane.add(lblWahtcha);
		
		JLabel lblFilm = new JLabel("FILM");
		lblFilm.setBounds(52, 92, 57, 15);
		contentPane.add(lblFilm);
		
		JLabel lblNewLabel = new JLabel("DATE");
		lblNewLabel.setBounds(52, 122, 57, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("GENRE");
		lblNewLabel_1.setBounds(52, 154, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("AGE LIMIT");
		lblNewLabel_2.setBounds(52, 185, 67, 15);
		contentPane.add(lblNewLabel_2);
		
		txtFilm = new JTextField();
		txtFilm.setBounds(125, 89, 116, 21);
		contentPane.add(txtFilm);
		txtFilm.setColumns(10);
		
		txtDate = new JTextField();
		txtDate.setBounds(125, 120, 116, 21);
		contentPane.add(txtDate);
		txtDate.setColumns(10);
		
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
		ComboStars.setBounds(125, 213, 116, 21);
		contentPane.add(ComboStars);
		
		JLabel lblReview = new JLabel("REVIEW");
		lblReview.setBounds(52, 255, 57, 15);
		contentPane.add(lblReview);
		
		JTextArea txtReview = new JTextArea();
		txtReview.setBackground(Color.PINK);
		txtReview.setBounds(125, 255, 254, 185);
		contentPane.add(txtReview);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(445, 92, 540, 347);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		scrollPane.setViewportView(table);
		table.setBackground(Color.PINK);
		
		JButton btnLoad = new JButton("LOAD");
		btnLoad.setBounds(899, 59, 86, 23);
		contentPane.add(btnLoad);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setBounds(293, 88, 86, 23);
		contentPane.add(btnAdd);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setBounds(293, 150, 86, 23);
		contentPane.add(btnDelete);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setBounds(899, 449, 86, 23);
		contentPane.add(btnExit);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setBounds(293, 118, 86, 23);
		contentPane.add(btnUpdate);
		
		txtSearchTitle = new JTextField();
		txtSearchTitle.setBounds(552, 60, 116, 21);
		contentPane.add(txtSearchTitle);
		txtSearchTitle.setColumns(10);
		
		JLabel lblSearch = new JLabel("SEARCH TITLE");
		lblSearch.setBounds(445, 63, 95, 15);
		contentPane.add(lblSearch);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSearch.setBounds(680, 59, 95, 23);
		contentPane.add(btnSearch);
	}
}
