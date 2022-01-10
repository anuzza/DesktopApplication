package javaswing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TableForm extends JFrame {

	private JPanel contentPane;
	private JTextField nametxt;
	private JTextField addresstxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableForm frame = new TableForm();
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
	public TableForm() {
		setTitle("Table Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 753, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(10, 27, 46, 14);
		contentPane.add(lblNewLabel);
		
		nametxt = new JTextField();
		nametxt.setBounds(56, 24, 140, 29);
		contentPane.add(nametxt);
		nametxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Address");
		lblNewLabel_1.setBounds(218, 27, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		addresstxt = new JTextField();
		addresstxt.setBounds(274, 24, 134, 29);
		contentPane.add(addresstxt);
		addresstxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("College");
		lblNewLabel_2.setBounds(435, 27, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JComboBox collegecmb = new JComboBox();
		collegecmb.setModel(new DefaultComboBoxModel(new String[] {"", "ISIT", "NCC", "KEC", "PE", "SNSC", "TSC", "", " "}));
		collegecmb.setBounds(491, 23, 134, 29);
		contentPane.add(collegecmb);
		
		JLabel lblNewLabel_3 = new JLabel("Gender");
		lblNewLabel_3.setBounds(10, 109, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JRadioButton malerbt = new JRadioButton("Male");
		buttonGroup.add(malerbt);
		malerbt.setBounds(62, 105, 59, 23);
		contentPane.add(malerbt);
		
		JRadioButton femalerbt = new JRadioButton("Female");
		buttonGroup.add(femalerbt);
		femalerbt.setBounds(123, 107, 72, 18);
		contentPane.add(femalerbt);
		
		JCheckBox agreechk = new JCheckBox("Agree");
		agreechk.setBounds(274, 105, 97, 23);
		contentPane.add(agreechk);
		
		JButton addbtn = new JButton("Add");
		addbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// input form validation
				
				if( nametxt.getText().isEmpty() ) {
					JOptionPane.showMessageDialog(nametxt, "name is required");
					return;
					
				}
				
				if (addresstxt.getText().isEmpty()) {
					JOptionPane.showMessageDialog(addresstxt, "address is required");
					return;
				}
				
				
							
				if( !malerbt.isSelected()&& !femalerbt.isSelected()) {
					
					JOptionPane.showMessageDialog(malerbt, "gender is required");
					return;
				}
				
			
				
				String nm = nametxt.getText();
				String ad = addresstxt.getText();
				String colz= collegecmb.getSelectedItem().toString();
				String gender;
				if (malerbt.isSelected()) {
					gender= "Male";
					
				}else {
					gender="Female";
				}
				
				String agree;
				if(agreechk.isSelected()) {
					agree="Yes";
					
				}else {
					agree="No";}
				
				//display data on jtable
				
				
				DefaultTableModel tmodel = (DefaultTableModel) table.getModel();
				tmodel.addRow(new Object [] {nm, ad, colz, gender, agree });
				
				// clear input format
				nametxt.setText("");
				addresstxt.setText("");
				collegecmb.setSelectedIndex(0);
				buttonGroup.clearSelection();
				agreechk.setSelected(false);
			}
		});
		addbtn.setBounds(498, 105, 89, 23);
		contentPane.add(addbtn);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(7, 151, 718, 23);
		contentPane.add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		scrollPane.setBounds(44, 165, 601, 227);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Address", "College", "Gender", "Agree"
			}
		));
		scrollPane.setViewportView(table);
	}
}
