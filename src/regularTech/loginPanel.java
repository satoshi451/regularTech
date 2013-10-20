package regularTech;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import layout.TableLayout;

public class loginPanel extends JPanel {
	private JTextField loginInput;
	private JTextField passInput;
	
	private GridLayout layout;
	private static Dimension inputDim;
	
	public loginPanel(){
		super();
		
		inputDim = new Dimension(200, 40);
		loginInput = new JTextField();
		passInput = new JTextField();
		
		loginInput.setPreferredSize(inputDim);
		passInput.setPreferredSize(inputDim);
	
		passInput.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String pass = arg0.getActionCommand();
				String login = loginInput.getText();
				System.out.println("login: " + login + "; pass: " + pass);
			}
		});
		
		layout = new GridLayout(3, 2);
		
		JLabel loginText = new JLabel("Login:");
		JLabel passText = new JLabel("Password:");
		
		add(loginText);
		add(loginInput);
		add(passText);
		add(passInput);
		
	}
}
