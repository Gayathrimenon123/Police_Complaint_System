package proj;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Login extends JFrame {
	int id;
	private JPanel contentPane;
	private JTextField user;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 490);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel username = new JLabel("Username");
		username.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		username.setBounds(185, 136, 113, 34);
		contentPane.add(username);
		
		JLabel password = new JLabel("Password");
		password.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		password.setBounds(185, 206, 85, 24);
		contentPane.add(password);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","electro","electro");
					Statement stmt = conn.createStatement();
					String pass=new String(passwordField.getPassword());
					String query1="select * from users where username='"+user.getText()+"' and password = '"+pass+"' ";
					System.out.println(query1);
					
					ResultSet rs = stmt.executeQuery(query1);
					/*if(rs.next()) {
						System.out.println(rs.getInt(1)+""+rs.getString(2)+""+rs.getString(3)+""+rs.getInt(4));
					}*/
				
					if(rs.next()) {
						System.out.println("HELLO");
						int typeid;
					    
					    	System.out.println(rs.getInt(1));
					    	 id=rs.getInt(1);
					    	 System.out.println("id ="+id);
					    
						typeid=rs.getInt(7);
						System.out.println(typeid);
						//rs.next();
						//frame.setVisible(false);
						JOptionPane.showMessageDialog(null, "Login Successfully");
						switch(typeid) {
						case 1:Admin_Homepage ad=new Admin_Homepage();
						ad.setVisible(true);
						break;
						case 2:Police_Homepage pg=new Police_Homepage();
						pg.setVisible(true);
							break;
						case 3:User_Homepage uh = new User_Homepage();
						uh.getid(id);
						uh.setVisible(true);
							break;
						}
					}else {
						JOptionPane.showMessageDialog(null, "Invalid Credential");
					}
			}catch(Exception e1) {
				System.out.println(e1);
			}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnNewButton.setBounds(317, 325, 85, 21);
		contentPane.add(btnNewButton);
		
		user = new JTextField();
		user.setBounds(386, 146, 154, 19);
		contentPane.add(user);
		user.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(386, 211, 154, 19);
		contentPane.add(passwordField);
	}
}
