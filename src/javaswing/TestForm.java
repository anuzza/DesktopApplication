package javaswing;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class TestForm {
	public static void main(String[] args) {
		JFrame jf = new JFrame();
		
		jf.setSize(600, 500);
		jf.setTitle("Test Form");
		jf.setLayout(null);;
		
		//create label
		JLabel jl = new JLabel("WELCOME!");
		
		//jl.setSize(90, 20);
		jl.setBounds(120, 50, 90, 20);
		jf.add(jl);
		
		
		
		
		
		
		jf.setVisible(true);
	}

}
