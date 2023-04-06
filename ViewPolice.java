package proj;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class ViewPolice extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPolice frame = new ViewPolice();
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
	public ViewPolice() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 719, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 89, 670, 245);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "NAME", "ADDRESS", "PHONE NUMBER"
			}
		));
		
		JLabel lblNewLabel = new JLabel("Police");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(318, 32, 78, 21);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("SHOW");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","electro","electro");
					Statement stmt=conn.createStatement();
					String s="select id,name,address,phnumber from police ";
					ResultSet rs=stmt.executeQuery(s);
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}catch(Exception e1) {
					System.out.println(e1);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.setBounds(41, 365, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin_Homepage ad=new Admin_Homepage();
				ad.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 10));
		btnNewButton_1.setBounds(610, 365, 85, 21);
		contentPane.add(btnNewButton_1);
	}
}
