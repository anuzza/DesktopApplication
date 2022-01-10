package javaswing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class LoginForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
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
	public LoginForm() {
		setTitle("Login Form");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(21, 72, 97, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(128, 60, 193, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setForeground(Color.YELLOW);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(21, 127, 90, 14);
		contentPane.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(128, 119, 188, 30);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton(" LOG IN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(null, "HELLO");
				// login form validation
				
				if (textField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Username is required");
					return;
					
				}
				
				if (passwordField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "password is required");
					return;
					
				}
				
				String un = textField.getText();
				String psw = passwordField.getText();
				
				// check user in database
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/testtodo", "root", "");
					
					String sql = "select * from user where username= '"+ un +"' and password= '"+ psw +"'    ";
					Statement stm = con.createStatement();
					ResultSet rs = stm.executeQuery(sql);
					
					if ( rs.next()) {
						JOptionPane.showMessageDialog(null, "login sucess" );
						new Home().setVisible(true);
						dispose();
						
					}else {
						JOptionPane.showMessageDialog(null, "account does not exist");
					}
					
					
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				
				
//				if (un.equals("ram") && psw.equals("123")) {
//					
//					JOptionPane.showMessageDialog(null, " Login Success! ");
//					
//					new Home().setVisible(true);
//					dispose();
//				
//				}else {
//					JOptionPane.showMessageDialog(null, " Login Failed! ");
//					
//				}
				
				;
			}
		});
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(84, 165, 116, 30);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("User Login");
		lblNewLabel_2.setForeground(Color.GREEN);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_2.setBounds(131, 11, 221, 38);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("SIGN UP");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Signup().setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBackground(Color.GREEN);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(223, 165, 131, 30);
		contentPane.add(btnNewButton_1);
	}
}
