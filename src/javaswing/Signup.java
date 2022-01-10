package javaswing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Signup extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JPasswordField passwordField;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup frame = new Signup();
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
	public Signup() {
		setTitle("SIGN UP FORM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 387);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 165, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getTextField());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getPasswordField());
		contentPane.add(getBtnNewButton());
		contentPane.add(getBtnNewButton_1());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Username");
			lblNewLabel.setForeground(new Color(75, 0, 130));
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel.setBackground(new Color(47, 79, 79));
			lblNewLabel.setBounds(70, 72, 104, 19);
		}
		return lblNewLabel;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(184, 69, 154, 28);
			textField.setColumns(10);
		}
		return textField;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Password");
			lblNewLabel_1.setForeground(new Color(75, 0, 130));
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel_1.setBounds(70, 152, 104, 25);
		}
		return lblNewLabel_1;
	}
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(184, 149, 154, 28);
		}
		return passwordField;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("SIGN UP");
			btnNewButton.setBackground(new Color(75, 0, 130));
			btnNewButton.setForeground(new Color(255, 165, 0));
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if (textField.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Username is required");
						return;
						
					
						
						
					
						
					}
					
					
					
					if (passwordField.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "password is required");
						return;
						
					
						
					
						
						
						
					}
					
					String un = textField.getText();
					String pw = passwordField.getText();
									
					
					
					// insert into database
					
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testtodo", "root", "");
						
						String sql = "insert into user(username,password)values('"+ un +"','"+ pw +"') ";
						Statement stm = con.createStatement();
						stm.execute(sql);
						
						
						JOptionPane.showMessageDialog(null, "account created successfully!");
						
						
						
						
						
						
						
					} catch (Exception e1) {
					
						e1.printStackTrace();
					}
					
				}
			});
			btnNewButton.setBounds(121, 247, 198, 44);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("Back");
			btnNewButton_1.setBackground(new Color(75, 0, 130));
			btnNewButton_1.setForeground(new Color(255, 165, 0));
			btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new LoginForm().setVisible(true);
					dispose();
				}
			});
			btnNewButton_1.setBounds(345, 247, 115, 44);
		}
		return btnNewButton_1;
	}
}
