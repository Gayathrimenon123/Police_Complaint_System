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
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Police_Registration extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField addr;
	private JTextField phn;
	private JTextField txtuser;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Police_Registration frame = new Police_Registration();
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
	public Police_Registration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 489);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Police Registration");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel.setBounds(221, 10, 237, 51);
		contentPane.add(lblNewLabel);
		
		name = new JTextField();
		name.setBounds(431, 98, 96, 19);
		contentPane.add(name);
		name.setColumns(10);
		
		addr = new JTextField();
		addr.setBounds(431, 150, 96, 19);
		contentPane.add(addr);
		addr.setColumns(10);
		
		phn = new JTextField();
		phn.setBounds(431, 200, 96, 19);
		contentPane.add(phn);
		phn.setColumns(10);
		
		txtuser = new JTextField();
		txtuser.setBounds(431, 246, 96, 19);
		contentPane.add(txtuser);
		txtuser.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(431, 290, 96, 19);
		contentPane.add(passwordField);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String pass=new String(passwordField.getPassword());
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","electro","electro");
					Statement stmt = conn.createStatement();
					String query = "select count(id) from police";
					
					ResultSet rs = stmt.executeQuery(query);
					rs.next();
					int uid = rs.getInt(1);
					int newuid = uid+1;
					
					String sql = "insert into police values(?,?,?,?,?,?)";
					PreparedStatement ps = conn.prepareStatement(sql);
					
					ps.setInt(1,newuid);
					ps.setString(2,name.getText());
					ps.setString(3,addr.getText());
					ps.setString(4,phn.getText());
					ps.setString(5,txtuser.getText());
					ps.setString(6,pass);
					
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
							ps1.setString(2,txtuser.getText());
							ps1.setString(3, pass);
							ps1.setInt(4, 2);
							
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
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnNewButton_1.setBounds(221, 373, 96, 33);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(184, 100, 102, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Address");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(184, 152, 102, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Enter PhoneNo");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(184, 202, 102, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Enter Username");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(184, 248, 102, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Enter Password");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(184, 292, 102, 13);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(397, 373, 96, 33);
		contentPane.add(btnNewButton);
	}

}
