package proj;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AddComplaint extends JFrame {
int id;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField txt_title;
	JTextArea desc = new JTextArea();
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddComplaint frame = new AddComplaint();
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
	public AddComplaint() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel("Register a Complaint");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(203, 31, 290, 30);
		contentPane.add(lblNewLabel);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Enter Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(84, 89, 110, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Title");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(84, 159, 68, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Description");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(84, 241, 82, 13);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","electro","electro");
					Statement stmt = conn.createStatement();
					String query = "select count(id) from complaint";
					ResultSet rs = stmt.executeQuery(query);
					rs.next();
					int cid = rs.getInt(1);
					int newcid = cid+1;
					
                    String query1 = "select count(id) from cust_complaint";
					ResultSet rs1 = stmt.executeQuery(query1);
					rs1.next();
					int ccid = rs1.getInt(1);
					int newccid = ccid+1;
					
					String sql1 = "insert into complaint values(?,?,?)";
					PreparedStatement ps1 = conn.prepareStatement(sql1);
					ps1.setInt(1, newcid);
					ps1.setString(2,txt_title.getText());
					ps1.setString(3,desc.getText());
					
					ps1.executeUpdate();
					String sql2 = "insert into cust_complaint values(?,?,?)";

					PreparedStatement ps2 = conn.prepareStatement(sql2);
					
                    System.out.println(id);
					ps2.setInt(1,newccid);
					ps2.setInt(2,newcid);
					ps2.setInt(3,id);
					
					ps2.executeUpdate();
					JOptionPane.showMessageDialog(null, "Data inserted succesfully");

}catch(SQLException se) {
	se.printStackTrace();
}
				catch(Exception e1) {
				System.out.println(e1);
			}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnNewButton.setBounds(84, 358, 110, 21);
		contentPane.add(btnNewButton);
		
		
		desc.setBounds(84, 264, 268, 64);
		contentPane.add(desc);
		
		textField = new JTextField();
		textField.setBounds(84, 117, 268, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		txt_title = new JTextField();
		txt_title.setBounds(84, 192, 268, 30);
		contentPane.add(txt_title);
		txt_title.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User_Homepage uh = new User_Homepage();
			uh.getid(id);
				uh.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnNewButton_1.setBounds(510, 360, 85, 21);
		contentPane.add(btnNewButton_1);
	}
	void getid(int id) {
		this.id=id;
	}
}
