package regularTech;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Workspace extends JPanel {
	private static int s;
	private JPanel panel; 
	
	public static final int LOGIN_WINDOW = 0;
	public static final int DESCTOP = 1;
	
	public Workspace(){
		setLayout(new BorderLayout());
		
		setMode(Workspace.LOGIN_WINDOW);
	}
	
	private void setMode(int mode) {
		// TODO Auto-generated method stub
		switch(mode){
			case Workspace.LOGIN_WINDOW:	this.panel = new loginPanel();
											break;
			case Workspace.DESCTOP:			;								
		}

		this.add(this.panel, BorderLayout.CENTER);
	}

}
