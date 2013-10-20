package regularTech;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class loginPanel extends JPanel {
	private JTextField loginInput;
	private JTextField passInput;
	
	private GridLayout layout;
	private static Dimension inputDim;
	
	public loginPanel(){
		inputDim = new Dimension(200, 80);
		loginInput = new JTextField();
		passInput = new JTextField();
		
		layout = new GridLayout(3, 2);
		
		JLabel loginText = new JLabel("Login:");
		JLabel passText = new JLabel("Password:");
		
		add(loginText);
		add(passText);
	
		
	}
}
