package javaswing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class SimpleInterest extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleInterest frame = new SimpleInterest();
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
	public SimpleInterest() {
		setFont(new Font("Arial Black", Font.BOLD, 12));
		setTitle("Simple Interest Calculation ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 365);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(205, 92, 92));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Principle");
		lblNewLabel.setForeground(new Color(255, 215, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(61, 35, 107, 25);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBorder(new LineBorder(Color.BLACK));
		textField.setBounds(142, 31, 152, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Time");
		lblNewLabel_1.setForeground(new Color(255, 215, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(63, 88, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBorder(new LineBorder(Color.BLACK));
		textField_1.setBounds(142, 79, 152, 25);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Rate");
		lblNewLabel_2.setForeground(new Color(255, 215, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(63, 134, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBorder(new LineBorder(Color.BLACK));
		textField_2.setBounds(142, 127, 152, 25);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton(" Calculate SI");
		btnNewButton.setBackground(new Color(255, 215, 0));
		btnNewButton.addActionListener(new ActionListener() {

	
			public void actionPerformed(ActionEvent e) {
				int p = Integer.parseInt(textField.getText());
				int t = Integer.parseInt(textField_1.getText());
				int r = Integer.parseInt(textField_2.getText());
				
				String SI = String.valueOf((p*t*r)/100);
				show_answer.setText(SI);
		
				
			}
						
				
				
				
				
				
				
				
			
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(38, 189, 165, 32);
		contentPane.add(btnNewButton);
		
	    show_answer = new JLabel("");
	    show_answer.setForeground(new Color(0, 0, 0));
	    show_answer.setBorder(new LineBorder(new Color(0, 0, 0)));
	    show_answer.setFont(new Font("Tahoma", Font.BOLD, 30));
		show_answer.setBounds(233, 189, 165, 32);
		contentPane.add(show_answer);
		
		JButton btnNewButton_1 = new JButton("Calculate Amount");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int p = Integer.parseInt(textField.getText());
				int I = Integer.parseInt(show_answer.getText());
				
				String A = String.valueOf((p+I));
				show_answer2.setText(A);
				
			}
		});
		btnNewButton_1.setBackground(new Color(255, 215, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(38, 246, 165, 32);
		contentPane.add(btnNewButton_1);
		
		show_answer2 = new JLabel("");
		show_answer2.setFont(new Font("Tahoma", Font.BOLD, 30));
		show_answer2.setForeground(new Color(0, 0, 0));
		show_answer2.setBorder(new LineBorder(new Color(0, 0, 0)));
		show_answer2.setBounds(233, 246, 165, 32);
		contentPane.add(show_answer2);
	}
	private JLabel show_answer;
	private JLabel show_answer2;
}
