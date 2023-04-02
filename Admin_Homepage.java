package proj;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Admin_Homepage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Homepage frame = new Admin_Homepage();
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
	public Admin_Homepage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 153, 204));
		panel.setBounds(0, 0, 186, 443);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\sgaya\\Downloads\\Hotpot Design\\Favicons\\favicon-144x144.png"));
		lblNewLabel.setBounds(10, 10, 166, 140);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Add Police");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Police_Registration pr=new Police_Registration();
				pr.setVisible(true);
			}
		});
		btnNewButton.setBounds(23, 215, 137, 21);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View Police");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewPolice pv=new ViewPolice();
				pv.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1.setBounds(23, 256, 137, 21);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("View Complaint");
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewComplaint vc=new ViewComplaint();
				vc.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(23, 297, 137, 21);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Logout");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l=new Login();
				l.setVisible(true);
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_3.setBounds(23, 339, 137, 21);
		panel.add(btnNewButton_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(183, 0, 523, 443);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("WELCOME \r\nADMIN");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_1.setBounds(87, 200, 333, 55);
		panel_1.add(lblNewLabel_1);
	}
}
