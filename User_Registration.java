package proj;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class User_Registration extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField addr;
	private JTextField phn;
	private JTextField username;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_Registration frame = new User_Registration();
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
	public User_Registration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 490);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel.setBounds(233, 20, 211, 31);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String pass=new String(passwordField.getPassword());
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","electro","electro");
				Statement stmt = conn.createStatement();
				String query = "select count(id) from Users";
				
				ResultSet rs = stmt.executeQuery(query);
				rs.next();
				int uid = rs.getInt(1);
				int newuid = uid+1;
				
				String sql = "insert into Users values(?,?,?,?,?,?,?)";
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.setInt(1,newuid);
				ps.setString(2,name.getText());
				ps.setString(3,addr.getText());
				ps.setString(4,phn.getText());
				ps.setString(5,username.getText());
				ps.setString(6,pass);
				ps.setInt(7, 3);
				
				try {
					int i = ps.executeUpdate();
					System.out.println(i);
					if(i!=0) {
						String qy = "select count(id) from login";
						ResultSet rs1 = stmt.executeQuery(qy);
						rs1.next();
						int lid = rs1.getInt(1);
						int newlid = lid+1;
						
						String p = "insert into login values(?,?,?,?)";
						PreparedStatement ps1 = conn.prepareStatement(p);
						
						ps1.setInt(1, newlid);
						ps1.setString(2,username.getText());
						ps1.setString(3, pass);
						ps1.setInt(4, 3);
						
						ps1.executeUpdate();
						
						JOptionPane.showMessageDialog(null, "Data inserted succesfully");
					}
					else {
						JOptionPane.showMessageDialog(null, "Data Insertion Failed");
					}
				}catch(Exception e2) {
					System.out.println(e2);
				}
				
				
				}catch(Exception e1)
				{
					System.out.println(e1);			
					}
				}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_1.setBounds(214, 374, 102, 31);
		contentPane.add(btnNewButton_1);
		
		name = new JTextField();
		name.setBounds(410, 91, 96, 19);
		contentPane.add(name);
		name.setColumns(10);
		
		addr = new JTextField();
		addr.setBounds(410, 137, 96, 19);
		contentPane.add(addr);
		addr.setColumns(10);
		
		phn = new JTextField();
		phn.setBounds(410, 184, 96, 19);
		contentPane.add(phn);
		phn.setColumns(10);
		
		username = new JTextField();
		username.setBounds(410, 232, 96, 19);
		contentPane.add(username);
		username.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(410, 278, 96, 19);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(178, 94, 102, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Address");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(178, 139, 85, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Enter PhoneNo");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(178, 186, 102, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Enter Username");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(178, 234, 102, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Enter Password");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(178, 280, 102, 13);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l=new Login();
				l.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(410, 374, 85, 31);
		contentPane.add(btnNewButton);
	}
}
